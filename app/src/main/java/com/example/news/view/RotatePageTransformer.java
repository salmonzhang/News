package com.example.news.view;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * author:salmonzhang
 * Description:
 * Date:2018/7/31 0031 22:36
 */

public class RotatePageTransformer implements ViewPager.PageTransformer {
    private final float MAX_ROTATION = 25.0f;//旋转的最大角度

    @Override
    public void transformPage(View view, float position) {

        /**
         *分析结论：
         * view是viewpager的初始化方法中返回的view对象，view是多个不同的对象
         * A页面的position,[0 , -1]
         * B页面的position,[1 , 0]
         */

        int pageWidth = view.getWidth();
        //pageWidth，为viewpager中单个view对象的宽度

        //根据postion的取值范围，区分A,B页面并设置不同的动画
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setRotation(0);//设置最左边的图片不旋转
        } else if (position <= 0) { // [-1,0]
            //A页面的position,[0 , -1]
            //A页面执行旋转动画[0,-25度]
            view.setRotation(position*MAX_ROTATION);
            view.setPivotX(pageWidth/2);
            view.setPivotY(view.getHeight());

        } else if (position <= 1) { // (0,1]
            //B页面的position,[1 , 0]
            //B页面执行旋转动画[25度，0]
            view.setRotation(position*MAX_ROTATION);
            view.setPivotX(pageWidth/2);
            view.setPivotY(view.getHeight());

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setRotation(0);//设置最右边的图片不旋转
        }
    }
}
