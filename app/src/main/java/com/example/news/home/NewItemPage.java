package com.example.news.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.news.R;
import com.example.news.adapter.NewItemAdapter;
import com.example.news.bean.NewItemBean;
import com.example.news.utils.DensityUtil;
import com.example.news.utils.GsonTools;
import com.example.news.utils.HMAPI;
import com.example.news.view.RollViewPager;

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
                    RollViewPager rollViewPager = new RollViewPager(mContext);
                    rollViewPager.setTitles(mTop_news_title,newItemTitles);
                    //根据top views的个数去动态创建小圆点
                    initDots(mNewItemBean.getData().getTopnews().size());
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

    private ArrayList<ImageView> dots = new ArrayList<>();//用来管理轮播图的小圆点
    private TextView mTop_news_title;

    //初始化动态小圆点
    private void initDots(int size) {
        mDots_ll.removeAllViews();//先清空，再添加，避免重复
        dots.clear();
        for (int i = 0; i < size; i++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DensityUtil.dip2px(mContext, 5),
                    DensityUtil.dip2px(mContext, 5));
            ImageView point = new ImageView(mContext);
            if (i != 0) {
                point.setImageResource(R.mipmap.dot_normal);
                layoutParams.leftMargin = DensityUtil.dip2px(mContext, 5);
            } else {
                point.setImageResource(R.mipmap.dot_focus);
            }
            point.setLayoutParams(layoutParams);
            mDots_ll.addView(point);
            dots.add(point);
        }
    }

    private NewItemAdapter mNewItemAdapter;
    private View mTopView;
    private LinearLayout mDots_ll;//动态小圆点的容器
    private NewItemBean mNewItemBean;

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
        //初始化小圆点的容器
        mDots_ll = (LinearLayout) mTopView.findViewById(R.id.dots_ll);
        //初始化热门新闻标题
        mTop_news_title = (TextView) mTopView.findViewById(R.id.top_news_title);
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

    private List<NewItemBean.DataBean.NewsBean> newItems = new ArrayList<>();//新闻列表数据集合
    private List<String> newItemTitles = new ArrayList<>();//热门新闻标题数据集合
    private void parseJson(String json) {
        mNewItemBean = GsonTools.changeGsonToBean(json, NewItemBean.class);
        System.out.println(mNewItemBean);

        newItems.addAll(mNewItemBean.getData().getNews());
        newItemTitles.clear();
        for (NewItemBean.DataBean.TopnewsBean topnewsBean : mNewItemBean.getData().getTopnews()) {
            newItemTitles.add(topnewsBean.getTitle());
        }
        mHandler.sendEmptyMessage(0);
    }
}
