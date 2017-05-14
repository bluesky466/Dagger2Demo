package com.example.linjw.dagger2demo.dagger2;

import com.example.linjw.dagger2demo.UserInfoActivity;
import com.example.linjw.dagger2demo.presenter.UserInfoPresenter;
import com.example.linjw.dagger2demo.view.UserInfoView;

import dagger.Component;

/**
 * Created by linjw on 17-5-14.
 */

@Component(dependencies = AppComponent.class, modules = {UserInfoPresenterModule.class, UserInfoPresenterModule.class})
public interface UserInfoComponent {
    void inject(UserInfoPresenter presenter);

    void inject(UserInfoActivity activity);
}
