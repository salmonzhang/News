package com.example.news.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.news.R;
import com.example.news.fragment.MenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class HomeActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置内容界面的视图
        setContentView(R.layout.activity_home);//不是原来的setContentView

        //设置第一个菜单界面的视图
        setBehindContentView(R.layout.activity_menu);

        //获取侧滑菜单对象
        SlidingMenu slidingMenu = getSlidingMenu();

        //设置显示模式
        /**
         * SlidingMenu.LEFT 菜单显示在左边
         * SlidingMenu.RIGHT 菜单显示在右边
         * SlidingMenu.LEFT_RIGHT 菜单显示在左右边
         */
        slidingMenu.setMode(SlidingMenu.LEFT);

        //设置侧滑菜单的触摸模式
        /**
         * SlidingMenu.TOUCHMODE_FULLSCREEN 全屏模式
         * SlidingMenu.TOUCHMODE_MARGIN 边缘模式
         * SlidingMenu.TOUCHMODE_NONE 禁止模式
         */
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        //设置菜单界面显示之后内容界面显示宽度
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_width);//能够通过dimens.xml直接在代码写入dp值

        //设置菜单与内容界面的阴影效果
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);

        //如果要左右都显示必须设置第二个菜单
//        slidingMenu.setSecondaryMenu(R.layout.activity_menu);
//        slidingMenu.setSecondaryShadowDrawable(R.drawable.shadow);

        //将第一个菜单页面用fragment替换
        MenuFragment menuFragment = new MenuFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_menu, menuFragment).commit();
    }

    public void switchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, fragment).commit();
    }
}
