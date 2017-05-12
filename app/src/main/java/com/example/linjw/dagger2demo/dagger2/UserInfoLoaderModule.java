package com.example.linjw.dagger2demo.dagger2;

import com.example.linjw.dagger2demo.UserInfoLoader;

import dagger.Module;
import dagger.Provides;

/**
 * Created by linjw on 17-5-12.
 */

@Module
public class UserInfoLoaderModule {
    @Provides
    UserInfoLoader provideUserInfoLoader() {
        return new UserInfoLoader();
    }
}
