package com.example.news.home;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

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
//        TextView textView = new TextView(mContext);
//        textView.setText("设置");
//        return textView;

        ListView listView = new ListView(mContext);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, initData());
        listView.setAdapter(adapter);
        return listView;
    }

    private List<String> initData() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            datas.add(i + "");
        }
        return datas;
    }

}
