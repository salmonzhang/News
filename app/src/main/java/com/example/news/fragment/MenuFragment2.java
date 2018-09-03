package com.example.news.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.news.R;
import com.example.news.adapter.MenuAdapter;

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
                break;
            case R.id.lv_menu_smart_service:
                break;
            case R.id.lv_menu_govaffairs:
                break;
        }
    }
}
