package com.example.linjw.dagger2demo.view;

import com.example.linjw.dagger2demo.bean.FollowerInfo;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by linjw on 17-5-14.
 */

public interface FollowerView {
    void showFollowers(List<FollowerInfo> followers);
}
