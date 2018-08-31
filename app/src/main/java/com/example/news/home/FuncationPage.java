package com.example.news.home;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * author:salmonzhang
 * Description:首页对象
 * Date:2018/8/31 0031 23:34
 */

public class FuncationPage extends BasePage {


    public FuncationPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mContext);
        textView.setText("首页");
        return textView;
    }
}
