package com.example.administrator.a04newsapp.NewAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.a04newsapp.NewsBean.NewsBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-10-24.
 */

public class NewsAdapter extends BaseAdapter{
    private ArrayList<NewsBean> list;
    private Context mContext;
    public NewsAdapter(Context mContext,ArrayList<NewsBean> list) {
        //1.通过构造方法接收要显示的新闻集合
        this.list = list;
        this.mContext = mContext;


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
       return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
