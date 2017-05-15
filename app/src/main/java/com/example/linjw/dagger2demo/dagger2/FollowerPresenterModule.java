package com.example.linjw.dagger2demo.dagger2;

import com.example.linjw.dagger2demo.view.FollowerView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by linjw on 17-5-14.
 */

@Module
public class FollowerPresenterModule {
    private FollowerView mView;

    public FollowerPresenterModule(FollowerView view) {
        mView = view;
    }

    @Provides
    FollowerView provideFollowerView(){
        return mView;
    }
}
