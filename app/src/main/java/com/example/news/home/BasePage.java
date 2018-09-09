package com.example.news.home;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.news.R;
import com.example.news.act.HomeActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * author:salmonzhang
 * Description:五个条目对象的基类
 * Date:2018/8/31 0031 23:34
 */

public abstract class BasePage {

    public boolean isLoad = false;//判断每个页面对象是否已经加载了数据，取消重复加载

    public Context mContext;
    private View mRootView;
    private final SlidingMenu mSlidingMenu;
    public TextView mTxt_title;

    public BasePage(Context context) {
        this.mContext = context;
        mRootView = initView();
        mSlidingMenu = ((HomeActivity) mContext).getSlidingMenu();
    }

    public abstract View initView();

    public View getRootView() {
        return mRootView;
    }

    public abstract void initData();

    public void initTitleBar(View view) {
        Button btn_left = (Button) view.findViewById(R.id.btn_left);
        btn_left.setVisibility(View.GONE);
        ImageButton imgbtn_left = (ImageButton) view.findViewById(R.id.imgbtn_left);
        imgbtn_left.setImageResource(R.mipmap.img_menu);
        imgbtn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlidingMenu.toggle();
            }
        });

        mTxt_title = (TextView) view.findViewById(R.id.txt_title);

        ImageButton imgbtn_right = (ImageButton) view.findViewById(R.id.imgbtn_right);
        imgbtn_right.setVisibility(View.GONE);
    }
}
