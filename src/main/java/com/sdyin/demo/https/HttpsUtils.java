package com.sdyin.demo.https;

import sun.net.www.protocol.https.Handler;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.net.URL;

/**
 * @Author: liuye
 * @Date: 2018/7/10 12:23
 */
public class HttpsUtils {

  public static void main(String[] args) {
   /* URL url = new URL(null, path, new Handler());//handler是为了创建https协议的连接,否则下一步报错
    HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
    //实现自定义SSLSocketFactory，见下一步
    SSLSocketFactory sslFac = UMBX509TrustManager.getSSLFactory();

    if(StringUtils.isNotEmpty(method)){
      if(method.equalsIgnoreCase("GET")){
        conn.setRequestMethod("GET");
        //Get请求不需要DoOutPut
        conn.setDoOutput(false);
      }
      else if (method.equalsIgnoreCase("POST")){
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setUseCaches(false);
      }
    }
    //设置SSLSocketFactory对象
    conn.setSSLSocketFactory(sslFac);
    conn.setDoInput(true);
    //设置连接超时时间和读取超时时间
    conn.setConnectTimeout(connectTimeout);
    conn.setReadTimeout(readTimeout);
    conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");*/
    //connection初始化完成
  }

}
