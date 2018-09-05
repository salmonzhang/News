package com.example.news.menu;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.news.home.BasePage;

/**
 * author:salmonzhang
 * Description:互动页面
 * Date:2018/9/5 0005 23:00
 */

public class ActionPage extends BasePage {

    public ActionPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mContext);
        textView.setText("互动");
        return textView;
    }

    @Override
    public void initData() {

    }
}
