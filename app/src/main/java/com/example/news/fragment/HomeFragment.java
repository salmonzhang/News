package com.example.news.fragment;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;

import com.example.news.R;
import com.example.news.home.BasePage;
import com.example.news.home.FuncationPage;
import com.example.news.home.GoverPage;
import com.example.news.home.NewCenterPage;
import com.example.news.home.SettingPage;
import com.example.news.home.SmartServicePage;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * author:salmonzhang
 * Description:内容界面
 * Date:2018/8/29 0029 22:57
 */

public class HomeFragment extends BaseFragment {

    private ViewPager mViewPager;
//    private Context mContext;
    private RadioGroup mMain_radio;
//    private SlidingMenu mSlidingMenu;//homeActivity中侧滑菜单

    //初始化方法
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mContext = getActivity();
//        mSlidingMenu = ((HomeActivity) mContext).getSlidingMenu();
//    }

    //界面初始化
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.frag_home, null);
//        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
//
//        mMain_radio = (RadioGroup)view.findViewById(R.id.main_radio);
//
//        return view;
//    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.frag_home, null);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);

        mMain_radio = (RadioGroup)view.findViewById(R.id.main_radio);

        return view;
    }

    //数据初始化
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        List<BasePage> homePages = new ArrayList();
//        homePages.add(new FuncationPage(mContext));
//        homePages.add(new NewCenterPage(mContext));
//        homePages.add(new SmartServicePage(mContext));
//        homePages.add(new GoverPage(mContext));
//        homePages.add(new SettingPage(mContext));
//
//        mViewPager.setAdapter(new HomeAdapter(mContext, homePages));
//
//        //给单选按钮设置点击事件
//        mMain_radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.rb_function:
//                        mViewPager.setCurrentItem(0,false);//直接跳转到对应索引，并不设置滚动效果
//                        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
//                        break;
//                    case R.id.rb_news_center:
//                        mViewPager.setCurrentItem(1,false);//直接跳转到对应索引，并不设置滚动效果
//                        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//                        break;
//                    case R.id.rb_smart_service:
//                        mViewPager.setCurrentItem(2,false);//直接跳转到对应索引，并不设置滚动效果
//                        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//                        break;
//                    case R.id.rb_gov_affairs:
//                        mViewPager.setCurrentItem(3,false);//直接跳转到对应索引，并不设置滚动效果
//                        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//                        break;
//                    case R.id.rb_setting:
//                        mViewPager.setCurrentItem(4,false);//直接跳转到对应索引，并不设置滚动效果
//                        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
//                        break;
//                }
//            }
//        });
//
//        mMain_radio.check(R.id.rb_function);//设置首页按钮默认选中,注意，这里要写在设置监听之后
//    }

    @Override
    public void initData() {
        List<BasePage> homePages = new ArrayList();
        homePages.add(new FuncationPage(mContext));
        homePages.add(new NewCenterPage(mContext));
        homePages.add(new SmartServicePage(mContext));
        homePages.add(new GoverPage(mContext));
        homePages.add(new SettingPage(mContext));

        mViewPager.setAdapter(new HomeAdapter(mContext, homePages));

        //给单选按钮设置点击事件
        mMain_radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_function:
                        mViewPager.setCurrentItem(0,false);//直接跳转到对应索引，并不设置滚动效果
                        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);//不让侧滑菜单显示
                        break;
                    case R.id.rb_news_center:
                        mViewPager.setCurrentItem(1,false);//直接跳转到对应索引，并不设置滚动效果
                        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//让侧滑菜单显示
                        break;
                    case R.id.rb_smart_service:
                        mViewPager.setCurrentItem(2,false);//直接跳转到对应索引，并不设置滚动效果
                        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//让侧滑菜单显示
                        break;
                    case R.id.rb_gov_affairs:
                        mViewPager.setCurrentItem(3,false);//直接跳转到对应索引，并不设置滚动效果
                        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//让侧滑菜单显示
                        break;
                    case R.id.rb_setting:
                        mViewPager.setCurrentItem(4,false);//直接跳转到对应索引，并不设置滚动效果
                        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);//不让侧滑菜单显示
                        break;
                }
            }
        });

        mMain_radio.check(R.id.rb_function);//设置首页按钮默认选中,注意，这里要写在设置监听之后
    }
}
