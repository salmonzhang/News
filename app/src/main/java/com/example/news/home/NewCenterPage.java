package com.example.news.home;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.example.news.act.HomeActivity;
import com.example.news.bean.NewsCenterBean;
import com.example.news.utils.GsonTools;
import com.example.news.utils.HMAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public List<String> newsCenterTitles = new ArrayList<>();
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    //通过HomeActivity获取到MenuFragment2中的setMenuTitle方法
                    ((HomeActivity) mContext).getMenuFragment().setMenuTitle(newsCenterTitles);
                    break;
            }
        }
    };

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

                //每次网络请求后，应先清空newsCenterTitles中的数据，防止数据重复
                newsCenterTitles.clear();
                //获取网络数据新闻中心中标题集合
                List<NewsCenterBean.DataBean> dataBeans = newsCenterBean.getData();
                for (NewsCenterBean.DataBean dataBean : dataBeans) {
                    newsCenterTitles.add(dataBean.getTitle());
                }
                //获取到新闻中心的标题集合后，使用Handler在主线程中修改UI
                mHandler.sendEmptyMessage(0);
            }
        });
    }

}
