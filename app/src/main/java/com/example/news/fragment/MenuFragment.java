package com.example.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.news.act.HomeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * author:salmonzhang
 * Description:
 * Date:2018/8/28 0028 21:35
 */

public class MenuFragment extends Fragment implements AdapterView.OnItemClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ListView listView = new ListView(getActivity());
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, initData());
        listView.setAdapter(adapter);
        //设置listview的点击事件
        listView.setOnItemClickListener(this);
        return listView;
    }

    private List<String> initData() {
        List<String> datas = new ArrayList<>();
        datas.add("页面一");
        datas.add("页面二");
        datas.add("页面三");
        return datas;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //点击条目，创建出对应的fragment,传递给HomeActivity，让右边的内容界面改变
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment2();
                break;
            case 2:
                fragment = new Fragment3();
                break;
        }

        if (getActivity() instanceof HomeActivity) {
            ((HomeActivity) getActivity()).switchFragment(fragment);
        }
    }

}
