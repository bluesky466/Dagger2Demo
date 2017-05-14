package com.example.linjw.dagger2demo.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.linjw.dagger2demo.model.UserInfoLoader;
//import com.example.linjw.dagger2demo.dagger2.DaggerComponent;
import com.example.linjw.dagger2demo.view.UserInfoView;

import javax.inject.Inject;

/**
 * Created by linjw on 17-5-12.
 */

public class UserInfoPresenter {
    public static final String TAG = "UserInfoPresenter";

    @Inject
    UserInfoView mView;

    @Inject
    UserInfoLoader mUserInfoLoader;

    @Inject
    public UserInfoPresenter(){

    }


    public void loadUserInfo(final String login) {
        mUserInfoLoader.loadUserInfo(login, new UserInfoLoader.LoadFinishListener() {
            @Override
            public void onLoadSuccess(UserInfoLoader loader) {
                Log.d(TAG, loader.getName());
                Log.d(TAG, loader.getAvatarUrl());
                Log.d(TAG, loader.getLogin());

                mView.setAvatar(loader.getAvatarUrl());
                mView.setName(loader.getName());
            }

            @Override
            public void onLoadError(UserInfoLoader loader) {
                mView.setName("can't find user " + login);
            }
        });
    }

    public void gotoFollowersList(Context context) {
        Toast.makeText(context, "gotoFollowersList", Toast.LENGTH_SHORT).show();
    }
}
