package com.sdyin.demo.qiniu;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * 测试上传: 本地文件方式,还支持数组及流上传 参考链接
 * @author: liuye
 * @Date: 2018/10/25 22:00
 * @Description 参考链接: https://developer.qiniu.com/kodo/sdk/1239/java#4
 */
public class Test {

  public static void main(String[] args) {
    //构造一个带指定Zone对象的配置类
    Configuration cfg = new Configuration(Zone.zone2());
    UploadManager uploadManager = new UploadManager(cfg);
    //...生成上传凭证，然后准备上传
    String accessKey = "your access key";
    String secretKey = "your secret key";
    String bucket = "your bucket name";
    //如果是Windows情况下，格式是 D:\\qiniu\\test.png
    String localFilePath = "/home/qiniu/test.png";
    //默认不指定key的情况下，以文件内容的hash值作为文件名
    String key = null;

    Auth auth = Auth.create(accessKey, secretKey);
    String upToken = auth.uploadToken(bucket);

    try {
      Response response = uploadManager.put(localFilePath, key, upToken);
      //解析上传成功的结果
      DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
      System.out.println(putRet.key);
      System.out.println(putRet.hash);
    } catch (QiniuException ex) {
      Response r = ex.response;
      System.err.println(r.toString());
      try {
        System.err.println(r.bodyString());
      } catch (QiniuException ex2) {
        //ignore
      }
    }
  }
}
