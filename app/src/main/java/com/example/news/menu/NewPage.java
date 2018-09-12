package com.example.news.menu;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.news.R;
import com.example.news.adapter.NewAdapter;
import com.example.news.bean.NewsCenterBean;
import com.example.news.home.BasePage;
import com.example.news.home.NewItemPage;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * author:salmonzhang
 * Description:新闻页面
 * Date:2018/9/5 0005 22:58
 */

public class NewPage extends BasePage {


    private final NewsCenterBean.DataBean mDataBean;//viewpager中的数据
    private TabPageIndicator mIndicator;
    private ViewPager mPager;

    public NewPage(Context context, NewsCenterBean.DataBean dataBean) {
        super(context);
        this.mDataBean = dataBean;
    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.simple_tabs, null);
        mIndicator = view.findViewById(R.id.indicator);
        mPager = (ViewPager) view.findViewById(R.id.pager);
        return view;
    }

    @Override
    public void initData() {
        isLoad = true;

        //根据mDataBean中的条目数动态的创建新闻条目的标题和页面对象
        List<String> newItemTitels = new ArrayList<>();
        List<BasePage> newItemPages = new ArrayList<>();
        for (NewsCenterBean.DataBean.ChildrenBean childrenBean : mDataBean.getChildren()) {
            newItemTitels.add(childrenBean.getTitle());
            newItemPages.add(new NewItemPage(mContext));
        }

        //创建适配器，展示界面
        NewAdapter newAdapter = new NewAdapter(mContext, newItemPages, newItemTitels);
        mPager.setAdapter(newAdapter);
        mIndicator.setViewPager(mPager);
    }
}
