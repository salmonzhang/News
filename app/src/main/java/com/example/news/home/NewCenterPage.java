package com.example.news.home;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.news.bean.NewsCenterBean;
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

        Request request = new Request.Builder().url(HMAPI.NEW_CENTER).build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        //异步请求
        call.enqueue(new Callback() {
            //网络请求失败
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("网络请求失败");
            }

            //网络请求有响应
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                System.out.println(json);

                //使用Gson解析json数据的原始写法
//                Gson gson = new Gson();
//                NewsCenterBean newsCenterBean = gson.fromJson(json, NewsCenterBean.class);
//                System.out.println(newsCenterBean);

                //使用GsonTools解析对象型json
                NewsCenterBean newsCenterBean = GsonTools.changeGsonToBean(json, NewsCenterBean.class);
                System.out.println(newsCenterBean);

                //使用GsonTools解析数组型json
//                NewsCenterBean arrayJsonBean = GsonTools.changeGsonToList(json, ArrayJsonBean.class);

            }
        });
    }

}
