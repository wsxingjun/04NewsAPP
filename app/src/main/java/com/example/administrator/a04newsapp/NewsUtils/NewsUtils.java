package com.example.administrator.a04newsapp.NewsUtils;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.administrator.a04newsapp.NewsBean.NewsBean;
import com.example.administrator.a04newsapp.StreamUtils.StreamUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017-10-24.
 */


public class NewsUtils {
    private final String NewsPath_URL = "";
    //从网络数据库中读取的数据
    public static ArrayList<NewsBean> getAllNewsForNetWork(Context mContext){
        ArrayList<NewsBean> arrayList = new ArrayList<NewsBean>();


        try {
            //1.使用网络请求数据库；
            URL url = new URL("NewsPath_URL");
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(10*1000);

            int reponsCode = urlConnection.getResponseCode();
            if (200 == reponsCode){
                //获取请求到信息
                InputStream inputStream = urlConnection.getInputStream();
                String result = StreamUtils.StreamToString(inputStream);
                ////2.解析获得的网络数据；
                //将获取的String数组封装成为了一个jsonObject对象
                JSONObject root_json = new JSONObject(result);
                //获取JSONObject中的第一个字段："newss"
                JSONArray jsonArray = root_json.getJSONArray("newss");
                //循环遍历jsonArray，解析数据；
                for (int i=0; i < jsonArray.length(); i++){
                    JSONObject new_json = jsonArray.getJSONObject(i);

                    NewsBean newsBean = new NewsBean();
                    newsBean.id = new_json.getInt("id");
                    newsBean.comment  = new_json.getInt("comment");
                    newsBean.category = new_json.getInt("category");
                    newsBean.time     = new_json.getString("time");
                    newsBean.desc     = new_json.getString("desc");
                    newsBean.title    = new_json.getString("title");
                    newsBean.news_url = new_json.getString("news_url");
                    newsBean.icon_url = new_json.getString("icon_url");

                    arrayList.add(newsBean);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //3.将解析之后的数据返回给listview



        return arrayList;
    }
}
