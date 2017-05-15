package com.example.linjw.dagger2demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.example.linjw.dagger2demo.dagger2.DaggerSearchComponent;
import com.example.linjw.dagger2demo.dagger2.SearchComponent;
import com.example.linjw.dagger2demo.dagger2.SearchPresenterModule;
import com.example.linjw.dagger2demo.presenter.SearchPresenter;
import com.example.linjw.dagger2demo.view.SearchView;

import javax.inject.Inject;

/**
 * Created by linjw on 17-5-14.
 */

public class SearchActivity extends Activity implements SearchView {
    private EditText mEditText;

    @Inject
    SearchPresenter mSearchPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.search_activity);

        mEditText = (EditText) findViewById(R.id.edit_text);

        SearchComponent component = DaggerSearchComponent.builder()
                .searchPresenterModule(new SearchPresenterModule(this))
                .build();

        // 注意调用顺序,先使mSearchPresenter非空,再往mSearchPresenter注入依赖
        component.inject(this);
        component.inject(mSearchPresenter);
    }

    void onClick(View view){
        mSearchPresenter.search();
    }

    @Override
    public String getLogin() {
        return mEditText.getText().toString();
    }
}
