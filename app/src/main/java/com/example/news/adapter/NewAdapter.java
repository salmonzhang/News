package com.example.news.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.home.BasePage;

import java.util.List;

/**
 * author:salmonzhang
 * Description:新闻中心新闻条目的适配器
 * Date:2018/9/11 0011 23:15
 */

public class NewAdapter extends PagerAdapter {

    private final Context mContext;
    private final List<BasePage> mDatas;
    private final List<String> mTitles;

    public NewAdapter(Context context, List<BasePage> datas, List<String> titles) {
        this.mContext = context;
        this.mDatas = datas;
        this.mTitles = titles;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0:mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mDatas.get(position).getRootView());
        return mDatas.get(position).getRootView();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((View) object));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
