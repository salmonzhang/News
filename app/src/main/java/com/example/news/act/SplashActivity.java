package com.example.news.act;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.news.R;
import com.example.news.utils.SpUtil;
import com.example.news.view.myVideoView;

public class SplashActivity extends AppCompatActivity {

    private myVideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mVideoView = (myVideoView) findViewById(R.id.videoview);
        mVideoView.setVideoURI(Uri.parse("android.resource://"+this.getPackageName()+"/"+R.raw.kr36));
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mVideoView.start();
            }
        });
        mVideoView.start();
    }

    public void enterHome(View view) {
        //只有第一次进入的时候才进入引导界面，其余都进入主界面
        //使用SP保存是否是第一次进入

        boolean isFirst = SpUtil.getBoolean(this, "isFirst", true);
        if (true) {
            //进入引导界面
            startActivity(new Intent(this, GuideActivity.class));
            //保存状态
            SpUtil.saveBoolean(this, "isFirst",false);
        } else {
            //进入主界面
            startActivity(new Intent(this,HomeActivity.class));
        }

        //关闭视频播放，因为播放的视频资源非常耗内存
        if (mVideoView != null && mVideoView.isPlaying()) {
            mVideoView.stopPlayback();
        }

        //进入主界面或引导界面后，销毁当前的activity
        finish();
    }
}
