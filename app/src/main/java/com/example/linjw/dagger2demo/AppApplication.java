package com.example.linjw.dagger2demo;

import android.app.Application;

import com.example.linjw.dagger2demo.dagger2.AppComponent;
import com.example.linjw.dagger2demo.dagger2.AppModule;
import com.example.linjw.dagger2demo.dagger2.DaggerAppComponent;

/**
 * Created by linjw on 17-5-14.
 */

public class AppApplication extends Application {
    private AppComponent mAppComponent;

    public AppApplication() {
        super();

        mAppComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
