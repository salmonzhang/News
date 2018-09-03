package com.example.news.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.news.R;

import java.util.List;

/**
 * author:salmonzhang
 * Description:菜单界面的adapter
 * Date:2018/9/3 0003 23:22
 */

public class MenuAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mDatas;
    private int mClickPosition;

    public MenuAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public String getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.layout_item_menu, null);
            holder = new ViewHolder();
            holder.iv_arrow = (ImageView) convertView.findViewById(R.id.iv_menu_item);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_menu_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (mClickPosition == position) {
            holder.iv_arrow.setImageResource(R.drawable.menu_arr_select);
            holder.tv_title.setTextColor(Color.RED);
        } else {
            holder.iv_arrow.setImageResource(R.drawable.menu_arr_normal);
            holder.tv_title.setTextColor(Color.WHITE);
        }

        String title = mDatas.get(position);
        holder.tv_title.setText(title);
        return convertView;
    }

    public void setClickPosition(int position) {
        this.mClickPosition = position;
        notifyDataSetChanged();
    }

    class ViewHolder{
        ImageView iv_arrow;
        TextView tv_title;
    }
}
