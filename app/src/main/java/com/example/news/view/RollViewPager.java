package com.example.news.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.news.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author:salmonzhang
 * Description:专门实现轮播图的功能
 * Date:2018/10/23 0023 22:57
 */

public class RollViewPager extends ViewPager{

    private TextView tv_title;
    private List<String> titles;
    private List<String> images;
    private ArrayList<ImageView> dots;
    private RollAdapter mAdapter;
    private int prevousPosition;

    public RollViewPager(Context context) {
        this(context,null);
    }

    public RollViewPager(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //设置页面切换监听，让标题和小圆点都一起动起来
        this.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //动态修改热门新闻标题和圆点的显示
                tv_title.setText(titles.get(position));
                //让前一个点不选中
                dots.get(prevousPosition).setImageResource(R.mipmap.dot_normal);
                prevousPosition = position;
                //让当前点选中
                dots.get(position).setImageResource(R.mipmap.dot_focus);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //统一管理标题数据与展示
    public void setTitles(TextView top_news_title, List<String> newItemTitles) {
        this.tv_title = top_news_title;
        this.titles = newItemTitles;
        //默认显示第一个标题
        tv_title.setText(this.titles.get(0));
    }

    public void setImages(List<String> newItemImages) {
        this.images = newItemImages;
    }

    public void setDots(ArrayList<ImageView> dots) {
        this.dots = dots;
    }

    public void start() {
        //设置适配器展示
        if (mAdapter == null) {
            mAdapter = new RollAdapter();
        } else {
            mAdapter.notifyDataSetChanged();
        }
        this.setAdapter(mAdapter);
    }

    private class RollAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = new ImageView(getContext());
            iv.setScaleType(ImageView.ScaleType.FIT_XY);//图片适配全屏
            Glide.with(getContext()).load(images.get(position)).into(iv);
            container.addView(iv);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(((View) object));
        }
    }
}
