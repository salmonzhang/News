package com.example.news.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.List;

/**
 * author:salmonzhang
 * Description:专门实现轮播图的功能
 * Date:2018/10/23 0023 22:57
 */

public class RollViewPager extends ViewPager{

    private TextView tv_title;
    private List<String> titles;

    public RollViewPager(Context context) {
        super(context);
    }

    public RollViewPager(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //统一管理标题数据与展示
    public void setTitles(TextView top_news_title, List<String> newItemTitles) {
        this.tv_title = top_news_title;
        this.titles = newItemTitles;
        //默认显示第一个标题
        tv_title.setText(this.titles.get(0));
    }
}
