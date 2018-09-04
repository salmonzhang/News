package com.example.news.home;

import android.content.Context;
import android.view.View;

/**
 * author:salmonzhang
 * Description:五个条目对象的基类
 * Date:2018/8/31 0031 23:34
 */

public abstract class BasePage {

    public boolean isLoad = false;//判断每个页面对象是否已经加载了数据，取消重复加载

    public Context mContext;
    private View mRootView;

    public BasePage(Context context) {
        this.mContext = context;
        mRootView = initView();
    }

    public abstract View initView();

    public View getRootView() {
        return mRootView;
    }

    public abstract void initData();
}
