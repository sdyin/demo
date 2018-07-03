package com.sdyin.demo.common;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: liuye
 * @Date: 2018/6/30 10:13
 */
public class MyServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println(">>>>>>>>>>doService()<<<<<<<<<<<");
   // super.service(req, resp);
  }
}
