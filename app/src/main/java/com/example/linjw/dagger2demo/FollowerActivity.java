package com.example.linjw.dagger2demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.linjw.dagger2demo.bean.FollowerInfo;
import com.example.linjw.dagger2demo.dagger2.AppComponent;
import com.example.linjw.dagger2demo.dagger2.FollowerComponent;
import com.example.linjw.dagger2demo.dagger2.FollowerPresenterModule;
import com.example.linjw.dagger2demo.presenter.FollowerPresenter;
import com.example.linjw.dagger2demo.view.FollowerView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by linjw on 17-5-14.
 */

public class FollowerActivity extends Activity implements FollowerView {
    @Inject
    FollowerPresenter mPresenter;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.follower_activity);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);

        FollowerComponent component = getAppComponent().plus(new FollowerPresenterModule(this));
        component.inject(this);
        component.inject(mPresenter);

        mPresenter.loadFollowers();
    }
    AppComponent getAppComponent() {
        return ((AppApplication)getApplication()).getAppComponent();
    }

    @Override
    public void showFollowers(final List<FollowerInfo> followers) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.setAdapter(new FollowerListAdapter(FollowerActivity.this, followers));
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
            }
        });
    }

    class FollowerListAdapter extends RecyclerView.Adapter<FollowerListAdapter.Holder> {
        private List<FollowerInfo> mFollowers;
        private LayoutInflater mLayoutInflater;
        private Context mContext;

        public FollowerListAdapter(Context context, List<FollowerInfo> followers) {
            mLayoutInflater = LayoutInflater.from(context);
            mFollowers = followers;
            mContext = context;
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(mLayoutInflater.inflate(R.layout.follower_list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            Glide.with(mContext)
                    .load(mFollowers.get(position).mAvatar)
                    .into(((Holder)holder).mAvatar);
        }

        @Override
        public int getItemCount() {
            return mFollowers.size();
        }

        class Holder extends RecyclerView.ViewHolder{
            public ImageView mAvatar;

            public Holder(View itemView) {
                super(itemView);

                mAvatar = (ImageView) itemView.findViewById(R.id.avatar);
            }
        }
    }
}
