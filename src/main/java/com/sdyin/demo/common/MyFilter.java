package com.sdyin.demo.common;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: liuye
 * @Date: 2018/6/30 10:16
 */
public class MyFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("过滤器初始化init");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    System.out.println("执行过滤器doFilter");
    System.out.println("请求名："+servletRequest.getServerName()+" 请求路径:"+ servletRequest.getRemoteHost()+" "+ servletRequest.getServerPort());
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
    System.out.println("销毁过滤器destroy");
  }
}
