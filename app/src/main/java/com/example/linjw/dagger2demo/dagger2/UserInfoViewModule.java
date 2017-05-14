package com.example.linjw.dagger2demo.dagger2;

import com.example.linjw.dagger2demo.presenter.UserInfoPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by linjw on 17-5-14.
 */

@Module
public class UserInfoViewModule {
    @Provides
    UserInfoPresenter provideUserInfoPresenter(UserInfoPresenter presenter) {
        return presenter;
    }
}
