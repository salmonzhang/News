package com.example.news.menu;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.news.R;
import com.example.news.adapter.NewAdapter;
import com.example.news.bean.NewsCenterBean;
import com.example.news.home.BasePage;
import com.example.news.home.NewItemPage;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
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
    private int currentItem = 0;//当前显示的条目索引
    private List<BasePage> mNewItemPages;
    private List<String> mNewItemTitels;

    public NewPage(Context context, NewsCenterBean.DataBean dataBean) {
        super(context);
        this.mDataBean = dataBean;
    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.simple_tabs, null);
        mIndicator = (TabPageIndicator)view.findViewById(R.id.indicator);
        mPager = (ViewPager) view.findViewById(R.id.pager);
        return view;
    }

    @Override
    public void initData() {
        isLoad = true;

        //根据mDataBean中的条目数动态的创建新闻条目的标题和页面对象
        mNewItemTitels = new ArrayList<>();
        mNewItemPages = new ArrayList<>();
        for (NewsCenterBean.DataBean.ChildrenBean childrenBean : mDataBean.getChildren()) {
            mNewItemTitels.add(childrenBean.getTitle());
            mNewItemPages.add(new NewItemPage(mContext,childrenBean.getUrl()));
        }

        //创建适配器，展示界面
        NewAdapter newAdapter = new NewAdapter(mContext, mNewItemPages, mNewItemTitels);
        mPager.setAdapter(newAdapter);
        mIndicator.setViewPager(mPager);

        //给Indicator设置页面切换监听，只有当position为0，向右滑动时，才让显示SlidingMenu
        mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentItem = position;
                if (position == 0) {
                    //全屏模式下，父控件就会拦截触摸事件，自己消费
                    mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                } else {
                    //禁止模式下，父控件不拦截触摸事件，让子控件消费
                    mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                }

                //新闻子条目界面显示时，动态地手动调用该界面的数据初始化方法
                BasePage basePage = mNewItemPages.get(position);

                if (!basePage.isLoad) {
                    basePage.initData();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //第一次进来手动调用北京界面的数据初始化操作
        BasePage basePage = mNewItemPages.get(0);
        if (!basePage.isLoad) {
            basePage.initData();
        }
    }

    //仿照生命周期方法onResume()，实现一个新闻界面重新显示的方法

    @Override
    public void onResume() {
        super.onResume();
        if (currentItem == 0) {
            mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        } else {
            mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }
    }
}
