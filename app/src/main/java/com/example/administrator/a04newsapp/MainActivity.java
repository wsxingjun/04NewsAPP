package com.example.administrator.a04newsapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.a04newsapp.NewAdapter.NewsAdapter;
import com.example.administrator.a04newsapp.NewsBean.NewsBean;
import com.example.administrator.a04newsapp.NewsUtils.NewsUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        //1.写布局 listview
        //2.找到listview 设置条目的点击事件
        ListView lv_newApp = (ListView) findViewById(R.id.lv_newApp);

        //3.先从网络获取数据提供给listview进行显示；
        ArrayList<NewsBean> allNews = NewsUtils.getAllNewsForNetWork(mContext);
        //3.1 获取本地数据库缓存的数据，让listview显示，如果没有网络不至于显示空白界面
        //3.2请求服务器获取新闻数据，是一个json字符串，需要解析json,封装到list集合，提供给listview展示

        //3.3 获取服务端数据成功后，需要缓存到本地数据库，缓存前需要清空本地数据库的数据；
        //4.创建一个Adatper继承BaseAdatpter,封装4个方法，需要接收新闻数据
        //5.将adapter设置给listview
        NewsAdapter newsAdapter = new NewsAdapter(mContext,);
        lv_newApp.setAdapter(newsAdapter);


    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
