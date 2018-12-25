package com.sdyin.demo.java8.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 函数式接口
 * @author: liuye
 * @Date: 2018/12/25 10:58
 * @Description
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

  String process(BufferedReader b) throws IOException;
}
