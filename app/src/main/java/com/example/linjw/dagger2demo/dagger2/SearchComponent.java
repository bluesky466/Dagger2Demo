package com.example.linjw.dagger2demo.dagger2;

import com.example.linjw.dagger2demo.SearchActivity;
import com.example.linjw.dagger2demo.presenter.SearchPresenter;

import dagger.Component;

/**
 * Created by linjw on 17-5-14.
 */

@Component(modules = {SearchPresenterModule.class})
public interface SearchComponent {
    void inject(SearchActivity activity);
    void inject(SearchPresenter presenter);
}
