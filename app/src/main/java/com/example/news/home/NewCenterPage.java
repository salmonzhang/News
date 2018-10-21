package com.example.news.home;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;

import com.example.news.R;
import com.example.news.act.HomeActivity;
import com.example.news.bean.NewsCenterBean;
import com.example.news.menu.ActionPage;
import com.example.news.menu.NewPage;
import com.example.news.menu.PicPage;
import com.example.news.menu.TopicPage;
import com.example.news.utils.GsonTools;
import com.example.news.utils.HMAPI;
import com.example.news.utils.SpUtil;

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

    public List<String> newsCenterTitles = new ArrayList<>();//新闻中心网络数据中的标题集合
    private int index = 0;//记录当前新闻中心界面显示的界面索引
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    //通过HomeActivity获取到MenuFragment2中的setMenuTitle方法
                    ((HomeActivity) mContext).getMenuFragment().setMenuTitle(newsCenterTitles);

                    //默认显示新闻界面
                    switchView(0);
                    break;
            }
        }
    };
    private FrameLayout mNew_center_fl;
    private ArrayList<BasePage> mNewCenterPages;

    public NewCenterPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.news_center_frame, null);
        mNew_center_fl = (FrameLayout) view.findViewById(R.id.news_center_fl);

        //设置初始化标题的方法
        initTitleBar(view);
        return view;
    }

    @Override
    public void initData() {
        System.out.println("获取新闻中心的页面数据");
        //先从数据库中获取缓存的数据，防止断网后上次加载的内容为空
        String json = SpUtil.getString(mContext, HMAPI.NEW_CENTER, "");
        if (!TextUtils.isEmpty(json)) {
            parseJson(json);
        }
        //从本地获取缓存数据后，然后再从网络去获取数据，再覆盖掉上一次数据库中保存的数据
        getNetData();
    }

    //获取网络数据
    private void getNetData() {
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
                //获取到json数据后，应该使用数据库进行保存，用来缓存数据，但这里为了方便使用sp保存
                SpUtil.saveString(mContext,HMAPI.NEW_CENTER,json);
                //获取到网络数据后，将isLoad置为true
                isLoad = true;
                parseJson(json);
            }
        });
    }

    //解析json数据
    private void parseJson(String json) {
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

        //创建出新闻中心的4个页面对象，并封装在集合中
        mNewCenterPages = new ArrayList<>();
        mNewCenterPages.add(new NewPage(mContext,newsCenterBean.getData().get(0)));//将新闻中心中的新闻数据传递给新闻界面
        mNewCenterPages.add(new TopicPage(mContext));
        mNewCenterPages.add(new PicPage(mContext));
        mNewCenterPages.add(new ActionPage(mContext));

        //获取到新闻中心的标题集合后，使用Handler在主线程中修改UI
        mHandler.sendEmptyMessage(0);
    }

    public void switchView(int position) {
        index = position;
        System.out.println("切换新闻中心中的view = " + position);
        //当左边菜单列表被点击时，让新闻中心帧布局展示对应的页面
        //因为帧布局addView后，view会一直叠加，所以在addView之前，应先清空之前添加的View
        mNew_center_fl.removeAllViews();
        BasePage basePage = mNewCenterPages.get(position);
        mNew_center_fl.addView(basePage.getRootView());

        //当页面切换时，动态改变标题
        mTxt_title.setText(newsCenterTitles.get(position));

        //页面展示了，同时也需要调用该界面的数据初始化方法
        if (!basePage.isLoad) {
            basePage.initData();
        }

        //新闻中心四个页面切换时，动态调用对应界面的仿生命周期方法onResume
        basePage.onResume();
    }

    @Override
    public void onResume() {
        super.onResume();
        //判断新闻中心当前显示的是哪个界面，然后动态地调用显示界面的仿生命周期方法
        if (mNewCenterPages != null && mNewCenterPages.size() > 0) {
            BasePage basePage = mNewCenterPages.get(index);//新闻、组图、专题、互动中的一个页面对象
            basePage.onResume();
        }
    }
}
