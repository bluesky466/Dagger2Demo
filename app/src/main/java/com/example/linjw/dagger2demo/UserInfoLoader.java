package com.example.linjw.dagger2demo;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Inject;

/**
 * Created by linjw on 17-5-11.
 */

public class UserInfoLoader {
    public static final String QUERY_URL = "https://api.github.com/users/";

    @Inject
    public UserInfoLoader() {

    }

    @SerializedName("name")
    private String mName;

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    @SerializedName("login")
    private String mLogin;

    public String getLogin() {
        return mLogin;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String mAvatarUrl) {
        this.mAvatarUrl = mAvatarUrl;
    }


    public interface LoadFinishListener {
        void onLoadSuccess(UserInfoLoader loader);

        void onLoadError(UserInfoLoader loader);
    }

    public void loadUserInfo(String login, final LoadFinishListener listener) {
        mLogin = login;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = queryJsonStringFromServer(mLogin);
                    UserInfoLoader info = new Gson().fromJson(json, UserInfoLoader.class);
                    UserInfoLoader.this.mLogin = info.mLogin;
                    UserInfoLoader.this.mName = info.mName;
                    UserInfoLoader.this.mAvatarUrl = info.mAvatarUrl;

                    if (listener != null) {
                        listener.onLoadSuccess(UserInfoLoader.this);
                    }
                } catch (IOException e) {
                    e.printStackTrace();

                    if (listener != null) {
                        listener.onLoadError(UserInfoLoader.this);
                    }
                }
            }
        }).start();
    }

    private String queryJsonStringFromServer(String login) throws IOException {
        HttpURLConnection connection = null;
        StringBuilder response = null;
        try {
            URL url = new URL(QUERY_URL + mLogin);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream in = connection.getInputStream();
            BufferedReader buf = new BufferedReader(new InputStreamReader(in));
            response = new StringBuilder();
            String line = null;
            while ((line = buf.readLine()) != null) {
                response.append(line);
            }
        } catch (MalformedURLException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return response != null ? response.toString() : null;
    }
}
