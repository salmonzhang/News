package com.example.news.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

/**
 * author:salmonzhang
 * Description:
 * Date:2018/7/25 0025 22:12
 */

public class CustomViewPager extends ViewPager {

    private static final float MIN_SCALE = 0.5f;
    private ImageView leftView;//A页面
    private ImageView rightView;//B页面

    private Map<Integer, ImageView> images = new HashMap<>();//记录当前子控件的所有view对象

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void addChildView(ImageView iv, int position) {
        images.put(position, iv);
    }

    public void removeChildView(int position) {
        images.remove(position);
    }

    /**
     *
     * @param position 当前页面的索引
     * @param offset   页面滑动的比例值
     * @param offsetPixels 页面滑动的像素值
     */
    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        super.onPageScrolled(position, offset, offsetPixels);

        System.out.println("position = [" + position + "], offset = [" + offset + "], offsetPixels = [" + offsetPixels + "]");

        leftView = images.get(position);
        rightView = images.get(position + 1);

        startLauncherAnimation(leftView,rightView,position,offset,offsetPixels);
    }

    //实现模拟器launcher界面的动画
    private void startLauncherAnimation(ImageView leftView, ImageView rightView, int position, float offset, int offsetPixels) {
        //让B页面执行缩放，x轴的平移
        if (rightView != null) {
            // Fade the page out.
            // Counteract the default slide transition
            //X轴的取值范围[-320,0]
            rightView.setTranslationX(-(rightView.getWidth() - offsetPixels));//设置B页面不管怎么滑动，都始终保证显示在屏幕的正中间

            // Scale the page down (between MIN_SCALE and 1)
            //0.5 + 0.5 * 0 = 0.5
            //0.5 + 0.5 * 1 = 1
            //缩放值的范围[0.5 , 1]
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * Math.abs(offset);
            rightView.setScaleX(scaleFactor);//设置B页面的缩放
            rightView.setScaleY(scaleFactor);
        }

        //让leftView显示在最上面
        if (leftView != null) {
            leftView.bringToFront();
        }
    }
}
