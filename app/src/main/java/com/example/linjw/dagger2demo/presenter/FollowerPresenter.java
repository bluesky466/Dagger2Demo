package com.example.linjw.dagger2demo.presenter;

import android.util.Log;

import com.example.linjw.dagger2demo.model.UserInfoLoader;
import com.example.linjw.dagger2demo.view.FollowerView;
import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;

/**
 * Created by linjw on 17-5-14.
 */

public class FollowerPresenter {
    public static final String TAG = "FollowerPresenter";
    @Inject
    FollowerView mView;

    @Inject
    UserInfoLoader mUserInfoLoader;

    @Inject
    public FollowerPresenter() {

    }

    public void loadFollowers() {
        Log.d(TAG, "login : " + mUserInfoLoader.getLogin());
        mUserInfoLoader.loadFollowersInfo(new UserInfoLoader.LoadFinishListener() {
            @Override
            public void onLoadSuccess(UserInfoLoader loader) {
                mView.showFollowers(loader.getFollowers());
            }

            @Override
            public void onLoadError(UserInfoLoader loader) {

            }
        });
    }
}
