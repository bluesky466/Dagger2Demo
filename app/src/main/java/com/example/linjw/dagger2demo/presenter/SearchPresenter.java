package com.example.linjw.dagger2demo.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.linjw.dagger2demo.UserInfoActivity;
import com.example.linjw.dagger2demo.view.SearchView;

import javax.inject.Inject;

/**
 * Created by linjw on 17-5-14.
 */

public class SearchPresenter{
    public static final String TAG = "SearchPresenter";

    @Inject
    SearchView mSearchView;

    Context mContext;

    //@Inject 注解可以用来告诉Dagger用哪个构造方法去构造SearchPresenter
    public SearchPresenter() {
        Log.d(TAG, "SearchPresenter()");
    }

    @Inject
    public SearchPresenter(Context context) {
        Log.d(TAG, "SearchPresenter(Context context)");
        mContext = context;
    }

    public void search() {
        Log.d(TAG, mSearchView.getLogin());

        Intent intent = new Intent(mContext, UserInfoActivity.class);
        intent.putExtra("login", mSearchView.getLogin());
        mContext.startActivity(intent);
    }
}
