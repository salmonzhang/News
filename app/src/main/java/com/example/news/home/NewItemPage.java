package com.example.news.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListView;

import com.example.news.R;
import com.example.news.adapter.NewItemAdapter;
import com.example.news.bean.NewItemBean;
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
 * Description:新闻中心中新闻条目的页面对象
 * Date:2018/9/11 0011 23:09
 */

public class NewItemPage extends BasePage {
    private final String mUrl;
    private ListView mLv;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
//                    RollViewPager rollViewPager = new RollViewPager(mContext);
                    int headerViewsCount = mLv.getHeaderViewsCount();//获取头视图的个数
                    if (headerViewsCount == 0) {//防止头视图重复加载
                        mLv.addHeaderView(mTopView);
                    }

                    if (mNewItemAdapter == null) {
                        mNewItemAdapter = new NewItemAdapter(mContext, newItems);
                        mLv.setAdapter(mNewItemAdapter);
                    } else {
                        mNewItemAdapter.notifyDataSetChanged();
                    }
                    break;
            }
        }
    };
    private NewItemAdapter mNewItemAdapter;
    private View mTopView;

    public NewItemPage(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.frag_item_news, null);
        mLv = view.findViewById(R.id.lv_item_news);

        //初始化头视图的view
        mTopView = View.inflate(mContext, R.layout.layout_roll_view, null);
        return mLv;
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
                isLoad = true;//防止头视图重复加载
                String json = response.body().string();
                parseJson(json);
            }
        });
    }

    List<NewItemBean.DataBean.NewsBean> newItems = new ArrayList<>();
    private void parseJson(String json) {
        NewItemBean newItemBean = GsonTools.changeGsonToBean(json, NewItemBean.class);
        System.out.println(newItemBean);

        newItems.addAll(newItemBean.getData().getNews());
        mHandler.sendEmptyMessage(0);
    }
}
