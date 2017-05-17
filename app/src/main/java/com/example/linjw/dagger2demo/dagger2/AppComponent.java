package com.example.linjw.dagger2demo.dagger2;

import com.example.linjw.dagger2demo.UserInfoActivity;
import com.example.linjw.dagger2demo.model.UserInfoLoader;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by linjw on 17-5-14.
 */
@AppScope
@Component(modules = {AppModule.class})
public interface AppComponent {
    FollowerComponent plus(FollowerPresenterModule module);
    UserInfoComponent plus(UserInfoPresenterModule module);
}

//共用AppModule
//@Component(modules = {AppModule.class})
//public interface AppComponent {
//}

// 用@Inject标注UserInfoLoader构造方法可以不用依赖AppModule或者AppComponent
//@AppScope
//@Component(modules = {AppModule.class})
//public interface AppComponent {
//}


// dependencies实现复用
//@Component(modules = {AppModule.class})
//public interface AppComponent {
//    UserInfoLoader provideUserInfoLoader();
//}
