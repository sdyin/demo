package com.sdyin.demo.https;

import javax.net.ssl.TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @Author: liuye
 * @Date: 2018/7/10 12:22
 */
public interface X509TrustManager extends TrustManager {

  void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException;

  void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException;

  X509Certificate[] getAcceptedIssuers();
}
