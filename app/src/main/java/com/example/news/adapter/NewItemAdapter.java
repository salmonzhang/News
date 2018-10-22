package com.example.news.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.news.R;
import com.example.news.bean.NewItemBean;

import java.util.List;

/**
 * author:salmonzhang
 * Description:
 * Date:2018/10/22 0022 23:14
 */

public class NewItemAdapter extends MyBaseAdapter<NewItemBean.DataBean.NewsBean> {
    public NewItemAdapter(Context context, List datas) {
        super(context, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.layout_news_item, null);
            holder = new ViewHolder();
            holder.iv = convertView.findViewById(R.id.iv_img);
            holder.tv_title = convertView.findViewById(R.id.tv_title);
            holder.tv_time = convertView.findViewById(R.id.tv_pub_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        NewItemBean.DataBean.NewsBean newsBean = getItem(position);
        holder.tv_title.setText(newsBean.getTitle());
        holder.tv_time.setText(newsBean.getPubdate());
        Glide.with(mContext).load(newsBean.getListimage()).into(holder.iv);
        return convertView;
    }

    class ViewHolder{
        ImageView iv;
        TextView tv_title;
        TextView tv_time;
    }
}
