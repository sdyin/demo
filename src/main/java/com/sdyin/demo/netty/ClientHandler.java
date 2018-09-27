package com.sdyin.demo.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 客户端处理逻辑
 * @author: liuye
 * @Date: 2018/9/27 17:42
 * @Description
 */
public class ClientHandler extends SimpleChannelInboundHandler<String> {

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
    //打印服务端的发送数据
    System.out.println(s);
  }
}
