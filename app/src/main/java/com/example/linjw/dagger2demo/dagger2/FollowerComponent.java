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
