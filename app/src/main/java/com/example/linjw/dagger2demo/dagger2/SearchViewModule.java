package com.example.linjw.dagger2demo.dagger2;

import com.example.linjw.dagger2demo.presenter.SearchPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by linjw on 17-5-14.
 */
@Module
public class SearchViewModule {
    @Provides
    SearchPresenter provideSearchPresenter(SearchPresenter presenter) {
        return presenter;
    }

}
