package com.example.news.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.news.R;
import com.example.news.utils.DensityUtil;
import com.example.news.view.RotatePageTransformer;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    //    private CustomViewPager mViewPager;
    private ViewPager mViewPager;
    private int[] imageIds = {R.mipmap.guide_1,R.mipmap.guide_2,R.mipmap.guide_3};
    private Button mButton;
    private LinearLayout mLinearLayout;
    private ImageView mIv_focus;
    private int mPointMargin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initData();
    }

    private void initData() {
        //根据引导界面的图片长度，动态添加小白点
        for (int i = 0; i < imageIds.length; i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DensityUtil.dip2px(this, 5), DensityUtil.dip2px(this, 5));
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.mipmap.dot_normal);
            if (i != 0) {
                params.leftMargin = DensityUtil.dip2px(this, 5);
            }
            point.setLayoutParams(params);
            mLinearLayout.addView(point);
        }

        mIv_focus.post(new Runnable() {//当view显示之后执行的任务
            @Override
            public void run() {
                mPointMargin = mLinearLayout.getChildAt(1).getLeft() - mLinearLayout.getChildAt(0).getLeft();
            }
        });
    }

    private void initView() {
        mButton = (Button) findViewById(R.id.bt);
        mButton.setOnClickListener(this);

        mLinearLayout = (LinearLayout) findViewById(R.id.ll_point_group);
        mIv_focus = (ImageView) findViewById(R.id.iv_focus);

//        mViewPager = (CustomViewPager) findViewById(R.id.viewpager);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        GuideAdapter guideAdapter = new GuideAdapter();
        mViewPager.setAdapter(guideAdapter);

        /**
         * docs中index.html中两种viewPager动画效果
         */
        //mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        //mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.setPageTransformer(true, new RotatePageTransformer());

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == mViewPager.getAdapter().getCount() - 1) {
                    mButton.setVisibility(View.VISIBLE);
                } else {
                    mButton.setVisibility(View.INVISIBLE);
                }

                //手指滑动时，让选中的点实时的动起来
                mIv_focus.setTranslationX((position + positionOffset) * mPointMargin);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,HomeActivity.class));
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
//            mViewPager.addChildView(iv,position);
            return iv;
        }

        //销毁条目
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(((View) object));

            //将当前页面的对象从集合中删除
//            mViewPager.removeChildView(position);
        }
    }
}
