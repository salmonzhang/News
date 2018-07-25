package com.example.news.act;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.news.R;
import com.example.news.view.CustomViewPager;

public class GuideActivity extends AppCompatActivity {

    private CustomViewPager mViewPager;
    private int[] imageIds = {R.mipmap.guide_1,R.mipmap.guide_2,R.mipmap.guide_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        mViewPager = (CustomViewPager) findViewById(R.id.viewpager);
        GuideAdapter guideAdapter = new GuideAdapter();
        mViewPager.setAdapter(guideAdapter);

        /**
         * docs中index.html中两种viewPager动画效果
         */
        //mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        //mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class GuideAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            //显示图片的张数
            return imageIds.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //初始化条目
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = new ImageView(GuideActivity.this);
            //iv.setImageResource(imageIds[position]);
            //当设置为资源图片时，左右两侧显示出来有白边，当设置为背景资源时，就没有该问题。
            iv.setBackgroundResource(imageIds[position]);
            container.addView(iv);

            //将当前页面的对象在初始化的时候传递给控件来操作
            mViewPager.addChildView(iv,position);
            return iv;
        }

        //销毁条目
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(((View) object));

            //将当前页面的对象从集合中删除
            mViewPager.removeChildView(position);
        }
    }
}
