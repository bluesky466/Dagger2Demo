package com.example.linjw.dagger2demo.dagger2;

import com.example.linjw.dagger2demo.UserInfoActivity;
import com.example.linjw.dagger2demo.model.UserInfoLoader;

/**
 * Created by linjw on 17-5-14.
 */

@AppScope
@dagger.Component(modules = {AppModule.class})
public interface AppComponent {
    FollowerComponent plus(FollowerPresenterModule module);

    UserInfoComponent plus(UserInfoPresenterModule module);
}
