package com.example.news.fragment;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.home.BasePage;

import java.util.List;

/**
 * author:salmonzhang
 * Description:
 * Date:2018/8/31 0031 23:43
 */

public class HomeAdapter extends PagerAdapter {

    private final Context mContext;
    private final List<BasePage> mDatas;

    public HomeAdapter(Context context, List<BasePage> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //条目初始化方法
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mDatas.get(position).getRootView());
        return mDatas.get(position).getRootView();
    }

    //条目销毁方法
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
