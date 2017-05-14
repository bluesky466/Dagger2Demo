package com.example.linjw.dagger2demo.dagger2;

import android.content.Context;

import com.example.linjw.dagger2demo.SearchActivity;
import com.example.linjw.dagger2demo.presenter.SearchPresenter;
import com.example.linjw.dagger2demo.view.SearchView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by linjw on 17-5-14.
 */
@Module
public class SearchPresenterModule {
    private SearchActivity mSearchActivity;

    public SearchPresenterModule(SearchActivity view) {
        mSearchActivity = view;
    }

    @Provides
    SearchView provideSearchView() {
        return mSearchActivity;
    }

    @Provides
    Context provideContext() {
        return mSearchActivity;
    }
}
