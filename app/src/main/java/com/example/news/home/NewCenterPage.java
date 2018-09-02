package com.example.news.home;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * author:salmonzhang
 * Description:新闻中心对象
 * Date:2018/8/31 0031 23:34
 */

public class NewCenterPage extends BasePage {
    public NewCenterPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mContext);
        textView.setText("新闻中心");
        return textView;
    }

    @Override
    public void initData() {
        System.out.println("获取新闻中心的页面数据");
    }
}
