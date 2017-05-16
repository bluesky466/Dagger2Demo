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

    // 用@Inject标注需要注入的成员变量
    // 被@Inject标注的成员变量不可以
    @Inject
    SearchView mSearchView;

    @Inject
    Context mContext;

    //@Inject 注解可以用来告诉Dagger用哪个构造方法去构造SearchPresenter,这里使用默认构造函数去构造
    @Inject
    public SearchPresenter() {
        Log.d(TAG, "SearchPresenter()");
    }

    //@Inject 注解可以用来告诉Dagger用哪个构造方法去构造SearchPresenter
    //context 参数由SearchPresenterModule提供
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
