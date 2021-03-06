package com.example.linjw.dagger2demo;

import android.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.linjw.dagger2demo.dagger2.AppComponent;
//import com.example.linjw.dagger2demo.dagger2.DaggerUserInfoComponent;
import com.example.linjw.dagger2demo.dagger2.AppModule;
//import com.example.linjw.dagger2demo.dagger2.DaggerUserInfoComponent;
import com.example.linjw.dagger2demo.dagger2.UserInfoComponent;
import com.example.linjw.dagger2demo.dagger2.UserInfoPresenterModule;
import com.example.linjw.dagger2demo.presenter.UserInfoPresenter;
import com.example.linjw.dagger2demo.view.UserInfoView;

import javax.inject.Inject;

/**
 * Created by linjw on 17-5-14.
 */

public class UserInfoActivity extends Activity implements UserInfoView{
    private ImageView mAvatar;
    private TextView mName;

    @Inject
    UserInfoPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo_activity);

        mAvatar = (ImageView) findViewById(R.id.avatar);
        mName = (TextView) findViewById(R.id.name);

//        使用dependencies实现依赖继承
//        UserInfoComponent component = DaggerUserInfoComponent.builder()
//                .appComponent(getAppComponent())
//                .userInfoPresenterModule(new UserInfoPresenterModule(this))
//                .build();

//      用@Inject标注UserInfoLoader构造方法可以不用依赖AppModule或者AppComponent
//        UserInfoComponent component = DaggerUserInfoComponent.builder()
//                .userInfoPresenterModule(new UserInfoPresenterModule(this))
//                .build();

//        共用AppModule
//        UserInfoComponent component = DaggerUserInfoComponent.builder()
//                .userInfoPresenterModule(new UserInfoPresenterModule(this))
//                .build();

        UserInfoComponent component = getAppComponent().plus(new UserInfoPresenterModule(this));

        component.inject(this);
        component.inject(mPresenter);

        mPresenter.loadUserInfo(getIntent().getStringExtra("login"));
    }

    AppComponent getAppComponent() {
        return ((AppApplication)getApplication()).getAppComponent();
    }

    @Override
    public void setName(final String name) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mName.setText(name);
            }
        });
    }

    @Override
    public void setAvatar(final String url) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Glide.with(UserInfoActivity.this)
                        .load(url)
                        .into(mAvatar);
            }
        });
    }

    public void onClick(View view) {
        mPresenter.gotoFollowersList(this);
    }
}
