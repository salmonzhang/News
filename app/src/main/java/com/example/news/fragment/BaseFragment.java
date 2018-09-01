package com.example.news.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.act.HomeActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * author:salmonzhang
 * Description:Fragment的基类
 * Date:2018/9/1 0001 23:24
 */

public abstract class BaseFragment extends Fragment {

    public Context mContext;
    public SlidingMenu mSlidingMenu;//homeActivity中侧滑菜单

    //初始化方法
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        mSlidingMenu = ((HomeActivity) mContext).getSlidingMenu();
    }

    //界面初始化方法
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = initView(inflater);
        return view;
    }

    public abstract View initView(LayoutInflater inflater);

    //数据初始化方法
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initData();
    }

    public abstract void initData();
}
