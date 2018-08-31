package com.example.news.home;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * author:salmonzhang
 * Description:设置对象
 * Date:2018/8/31 0031 23:34
 */

public class SettingPage extends BasePage {
    public SettingPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mContext);
        textView.setText("设置");
        return textView;
    }
}
