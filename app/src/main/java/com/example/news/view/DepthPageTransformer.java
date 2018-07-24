package com.example.news.view;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * author:salmonzhang
 * Description:
 * Date:2018/7/23 0023 23:02
 */

public class DepthPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;//最小缩放

    //viewpager滑动时，该方法实时执行
    public void transformPage(View view, float position) {

        System.out.println("view:" + view);
        System.out.println("position" + position);

        /**
         *分析结论：
         * view是viewpager的初始化方法中返回的view对象，view是多个不同的对象
         * A页面的position,[0 , -1]
         * B页面的position,[1 , 0]
         */

        int pageWidth = view.getWidth();
        System.out.println("pageWidth" + pageWidth);
        //pageWidth，为viewpager中单个view对象的宽度

        //根据postion的取值范围，区分A,B页面并设置不同的动画
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);//设置最左边的图片不可见
        } else if (position <= 0) { // [-1,0]
            //A页面的position,[0 , -1]
            // Use the default slide transition when moving to the left page
            view.setAlpha(1);//设置A页面完全可见
            view.setTranslationX(0);//设置A页面在X轴不移动，A页面的移动是viewpager自身的
            view.setScaleX(1);//设置A页面在X轴不缩放
            view.setScaleY(1);//设置A页面在Y轴不缩放

        } else if (position <= 1) { // (0,1]
            //B页面的position,[1 , 0]
            // Fade the page out.
            //透明度的取值范围：[0,1]
            view.setAlpha(1 - position);

            // Counteract the default slide transition
            //X轴的取值范围[-320,0]
            view.setTranslationX(pageWidth * -position);//设置B页面不管怎么滑动，都始终保证显示在屏幕的正中间

            // Scale the page down (between MIN_SCALE and 1)
            //缩放值的范围[0.75 , 1]
            //0.75 + 0.25 * 0 = 0.75
            //0.75 + 1 * 0.25 = 1
             float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);//设置B页面的缩放
            view.setScaleY(scaleFactor);

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);//设置最右边的图片不可见
        }
    }
}
