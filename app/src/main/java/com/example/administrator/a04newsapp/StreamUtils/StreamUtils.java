package com.example.administrator.a04newsapp.StreamUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017-10-24.
 */

public class StreamUtils {
    public static String StreamToString(InputStream inputStream) {
        String result = "";


        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,length);
                outputStream.flush();
            }
            //将字节流转换为string
            result = new String(outputStream.toByteArray(),"utf-8");
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

}
