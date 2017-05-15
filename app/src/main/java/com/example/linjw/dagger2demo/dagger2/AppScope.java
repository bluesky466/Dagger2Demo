package com.example.linjw.dagger2demo.dagger2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by linjw on 17-5-14.
 */

@Scope
@Retention(RUNTIME)
public @interface AppScope {
}
