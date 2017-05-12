package com.example.linjw.dagger2demo.dagger2;

import com.example.linjw.dagger2demo.presenter.UserInfoPresenter;
import com.example.linjw.dagger2demo.view.UserInfoView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by linjw on 17-5-12.
 */

@Module
public class UserInfoPresenterModule {
    private UserInfoView mView;

    public UserInfoPresenterModule(UserInfoView view) {
        mView = view;
    }

    @Provides
    UserInfoPresenter provideUserInfoPresenter() {
        return new UserInfoPresenter(mView);
    }
}
