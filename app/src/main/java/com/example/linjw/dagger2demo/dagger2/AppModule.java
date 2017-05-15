package com.example.linjw.dagger2demo.dagger2;

import com.example.linjw.dagger2demo.model.UserInfoLoader;

import dagger.Module;
import dagger.Provides;

/**
 * Created by linjw on 17-5-12.
 */

@Module
public class AppModule {

    @AppScope
    @Provides
    UserInfoLoader provideUserInfoLoader() {
        return new UserInfoLoader();
    }
}
