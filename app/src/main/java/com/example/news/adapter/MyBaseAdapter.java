package com.example.news.adapter;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * author:salmonzhang
 * Description:抽取adapter的基类
 * Date:2018/9/4 0004 23:04
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {

    public Context mContext;
    public List<T> mDatas;

    public MyBaseAdapter(Context context, List<T> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return null;
//    }
}
