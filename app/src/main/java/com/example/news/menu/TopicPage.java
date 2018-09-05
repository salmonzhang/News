package com.example.news.menu;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.news.home.BasePage;

/**
 * author:salmonzhang
 * Description:专题页面
 * Date:2018/9/5 0005 22:58
 */

public class TopicPage extends BasePage {
    public TopicPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mContext);
        textView.setText("专题");
        return textView;
    }

    @Override
    public void initData() {

    }
}
