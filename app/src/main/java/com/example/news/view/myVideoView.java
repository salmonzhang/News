package com.example.news.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * author:salmonzhang
 * Description:
 * Date:2018/2/6 0006 23:07
 */

public class myVideoView extends VideoView {
    public myVideoView(Context context) {
        super(context);
    }

    public myVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public myVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //将size定义为0，就是让videoview按照xml中的定义的宽高去显示
        //videoView默认是按照视频本身的大小去显示
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);

        setMeasuredDimension(width,height);
    }
}
