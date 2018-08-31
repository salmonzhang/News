package com.example.news.home;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * author:salmonzhang
 * Description:智慧服务对象
 * Date:2018/8/31 0031 23:34
 */

public class SmartServicePage extends BasePage {

    public SmartServicePage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mContext);
        textView.setText("智慧服务");
        return textView;
    }
}
