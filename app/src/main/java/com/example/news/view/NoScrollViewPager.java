package com.example.news.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * author:salmonzhang
 * Description:自定义一个不左右滑动的ViewPager
 * Date:2018/9/1 0001 23:54
 */

public class NoScrollViewPager extends ViewPager {
    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
//        return super.onTouchEvent(ev);//将触摸事件传递给源码，就能够实现ViewPager的左右滑动的效果
        return false;//不拦截、不处理
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return super.onInterceptTouchEvent(ev);//如果源码中返回的是true，则子控件就得不到触摸事件（ListView、ScrollView等）
        return false;//保证不拦截，让子控件能够获取到触摸事件
    }
}
