package com.example.news.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.R;
import com.example.news.home.BasePage;
import com.example.news.home.FuncationPage;
import com.example.news.home.GoverPage;
import com.example.news.home.NewCenterPage;
import com.example.news.home.SettingPage;
import com.example.news.home.SmartServicePage;

import java.util.ArrayList;
import java.util.List;

/**
 * author:salmonzhang
 * Description:内容界面
 * Date:2018/8/29 0029 22:57
 */

public class HomeFragment extends Fragment {

    private ViewPager mViewPager;
    private Context mContext;

    //初始化方法
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    //界面初始化
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, null);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        return view;
    }

    //数据初始化
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<BasePage> homePages = new ArrayList();
        homePages.add(new FuncationPage(mContext));
        homePages.add(new NewCenterPage(mContext));
        homePages.add(new SmartServicePage(mContext));
        homePages.add(new GoverPage(mContext));
        homePages.add(new SettingPage(mContext));

        mViewPager.setAdapter(new HomeAdapter(mContext, homePages));
    }
}
