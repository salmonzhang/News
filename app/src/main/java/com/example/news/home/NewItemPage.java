package com.example.news.home;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.example.news.bean.NewItemBean;
import com.example.news.utils.GsonTools;
import com.example.news.utils.HMAPI;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * author:salmonzhang
 * Description:新闻中心中新闻条目的页面对象
 * Date:2018/9/11 0011 23:09
 */

public class NewItemPage extends BasePage {
    private final String mUrl;

    public NewItemPage(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Override
    public View initView() {
        ListView lv = new ListView(mContext);
        return lv;
    }

    @Override
    public void initData() {
        getNetData();
    }

    private void getNetData() {
        Request request = new Request.Builder().url(HMAPI.BASE_URL + mUrl).build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                parseJson(json);
            }
        });
    }

    private void parseJson(String json) {
        NewItemBean newItemBean = GsonTools.changeGsonToBean(json, NewItemBean.class);
        System.out.println(newItemBean);
    }
}
