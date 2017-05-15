package com.example.linjw.dagger2demo.dagger2;

import android.content.Context;

import com.example.linjw.dagger2demo.UserInfoActivity;
import com.example.linjw.dagger2demo.presenter.UserInfoPresenter;
import com.example.linjw.dagger2demo.view.UserInfoView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by linjw on 17-5-12.
 */

@Module
public class UserInfoPresenterModule {
    private UserInfoActivity mActivity;

    public UserInfoPresenterModule(UserInfoActivity activity) {
        mActivity = activity;
    }

    @Provides
    UserInfoView provideUserInfoActivity() {
        return mActivity;
    }

    @Provides
    Context provideContext() {
        return mActivity;
    }
}
