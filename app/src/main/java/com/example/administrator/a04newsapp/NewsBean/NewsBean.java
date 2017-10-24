package com.example.administrator.a04newsapp.NewsBean;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2017-10-24.
 */

public class NewsBean {
    public String news_url;//新闻的地址
    public int id; //新闻的id???
    public String time; //新闻发生时间
    public String icon_url;//图片的地址
    public Bitmap bitmap; //新闻的简图
    public String title;  //新闻的标题
    public String desc;  //新闻的简要内容
    public int comment;  //新闻的评论数
    public int category; // 新闻的类别
}
