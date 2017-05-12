package com.example.linjw.dagger2demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.linjw.dagger2demo.dagger2.Component;
import com.example.linjw.dagger2demo.dagger2.DaggerComponent;
import com.example.linjw.dagger2demo.dagger2.UserInfoPresenterModule;
import com.example.linjw.dagger2demo.presenter.UserInfoPresenter;
import com.example.linjw.dagger2demo.view.UserInfoView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements UserInfoView {
    private ImageView mAvatar;
    private TextView mName;

    @Inject
    UserInfoPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAvatar = (ImageView) findViewById(R.id.avatar);
        mName = (TextView) findViewById(R.id.name);

        Component component = DaggerComponent.builder()
                .userInfoPresenterModule(new UserInfoPresenterModule(this))
                .build();
        component.inject(this);
        component.inject(mPresenter);

        mPresenter.loadUserInfo("bluesky466");
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
                Glide.with(MainActivity.this)
                        .load(url)
                        .into(mAvatar);
            }
        });
    }
}
