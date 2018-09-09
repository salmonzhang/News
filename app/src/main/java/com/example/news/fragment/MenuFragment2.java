package com.example.news.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.news.R;
import com.example.news.act.HomeActivity;
import com.example.news.adapter.MenuAdapter;
import com.example.news.home.NewCenterPage;

import java.util.ArrayList;
import java.util.List;

/**
 * author:salmonzhang
 * Description:
 * Date:2018/9/3 0003 23:10
 */

public class MenuFragment2 extends BaseFragment implements AdapterView.OnItemClickListener {

    private ListView mLv_menu_news_center;
    private ListView mLv_menu_smart_service;
    private ListView mLv_menu_govaffairs;
    private MenuAdapter mNewsCenterAdapter;

    public static final int TYPE_NEWS_CENTER = 0;//新闻中心类型
    public static final int TYPE_SMART_SERVICE = 1;//智慧服务类型
    public static final int TYPE_GOVER = 2;//政务指南类型

    public int currentType = TYPE_NEWS_CENTER;//当前类型

    //初始化界面
    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.layout_left_menu, null);
        mLv_menu_news_center = (ListView) view.findViewById(R.id.lv_menu_news_center);
        mLv_menu_smart_service = (ListView) view.findViewById(R.id.lv_menu_smart_service);
        mLv_menu_govaffairs = (ListView) view.findViewById(R.id.lv_menu_govaffairs);

        //给ListView设置点击事件
        mLv_menu_news_center.setOnItemClickListener(this);
        mLv_menu_smart_service.setOnItemClickListener(this);
        mLv_menu_govaffairs.setOnItemClickListener(this);
        return view;
    }

    //初始化数据
    @Override
    public void initData() {

    }

    public void setMenuTitle(List<String> newsCenterTitles) {
        if (mNewsCenterAdapter == null) {
            mNewsCenterAdapter = new MenuAdapter(mContext, newsCenterTitles);
            mLv_menu_news_center.setAdapter(mNewsCenterAdapter);
        } else {
            mNewsCenterAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.lv_menu_news_center:
                //记录选中的索引，并让适配器刷新
                mNewsCenterAdapter.setClickPosition(position);

                //隐藏侧滑菜单
                mSlidingMenu.toggle();

                //控制新闻中心页面切换
                NewCenterPage newsCenterPage = ((HomeActivity) mContext).getHomeFragment().getNewsCenterPage();
                newsCenterPage.switchView(position);
                break;
            case R.id.lv_menu_smart_service:
                break;
            case R.id.lv_menu_govaffairs:
                break;
        }
    }

    public void setMenuType(int type) {
        mLv_menu_news_center.setVisibility(View.GONE);
        mLv_menu_smart_service.setVisibility(View.GONE);
        mLv_menu_govaffairs.setVisibility(View.GONE);

        this.currentType = type;
        switch (currentType) {
            case TYPE_NEWS_CENTER:
                mLv_menu_news_center.setVisibility(View.VISIBLE);
                if (mNewsCenterAdapter != null) {
                    mNewsCenterAdapter.notifyDataSetChanged();
                }
                break;
            case TYPE_SMART_SERVICE:
                mLv_menu_smart_service.setVisibility(View.VISIBLE);
                List<String> smartTitles = new ArrayList<>();
                smartTitles.add("智慧服务1");
                smartTitles.add("智慧服务2");
                smartTitles.add("智慧服务3");
                mLv_menu_smart_service.setAdapter(new MenuAdapter(mContext,smartTitles));
                break;
            case TYPE_GOVER:
                mLv_menu_govaffairs.setVisibility(View.VISIBLE);
                List<String> goverTitles = new ArrayList<>();
                goverTitles.add("政务指南1");
                goverTitles.add("政务指南2");
                goverTitles.add("政务指南3");
                mLv_menu_govaffairs.setAdapter(new MenuAdapter(mContext,goverTitles));
                break;
        }
    }
}
