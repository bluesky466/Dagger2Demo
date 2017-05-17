package com.example.linjw.dagger2demo.dagger2;

import com.example.linjw.dagger2demo.FollowerActivity;
import com.example.linjw.dagger2demo.presenter.FollowerPresenter;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by linjw on 17-5-14.
 */
@Subcomponent(modules = {FollowerPresenterModule.class})
public interface FollowerComponent {
    void inject(FollowerPresenter presenter);
    void inject(FollowerActivity activity);
}

// 共用AppModule
//@Component(modules = {AppModule.class,FollowerPresenterModule.class})
//public interface FollowerComponent {
//    void inject(FollowerPresenter presenter);
//    void inject(FollowerActivity activity);
//}


// 用@Inject标注UserInfoLoader构造方法可以不用依赖AppModule或者AppComponent
//@Component(modules = {FollowerPresenterModule.class})
//public interface FollowerComponent {
//    void inject(FollowerPresenter presenter);
//    void inject(FollowerActivity activity);
//}

// dependencies实现复用
//@Component(dependencies = AppComponent.class, modules = {FollowerPresenterModule.class})
//public interface FollowerComponent {
//    void inject(FollowerPresenter presenter);
//    void inject(FollowerActivity activity);
//}
