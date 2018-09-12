package com.example.news.home;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * author:salmonzhang
 * Description:新闻中心中新闻条目的页面对象
 * Date:2018/9/11 0011 23:09
 */

public class NewItemPage extends BasePage {
    public NewItemPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mContext);
        textView.setText("新闻中心条目数据");
        return textView;
    }

    @Override
    public void initData() {

    }
}
