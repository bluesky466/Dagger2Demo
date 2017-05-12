package com.example.linjw.dagger2demo.dagger2;

import com.example.linjw.dagger2demo.MainActivity;
import com.example.linjw.dagger2demo.presenter.UserInfoPresenter;

/**
 * Created by linjw on 17-5-12.
 */

@dagger.Component(modules = {UserInfoPresenterModule.class, UserInfoLoaderModule.class})
public interface Component {
    void inject(UserInfoPresenter presenter);

    void inject(MainActivity activity);
}
