package com.example.news.menu;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.news.home.BasePage;

/**
 * author:salmonzhang
 * Description:组图页面
 * Date:2018/9/5 0005 22:59
 */

public class PicPage extends BasePage {

    public PicPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mContext);
        textView.setText("组图");
        return textView;
    }

    @Override
    public void initData() {

    }
}
