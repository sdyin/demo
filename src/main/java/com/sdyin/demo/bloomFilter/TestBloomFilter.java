package com.sdyin.demo.bloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * 测试布隆过滤器
 * @author: liuye
 * @Date: 2018/10/27 17:13
 * @Description
 */
public class TestBloomFilter {

  public static void main(String[] args) {

    BloomFilter<Integer> filter = BloomFilter.create(
            Funnels.integerFunnel(),
            500,  //预期插入数值
            0.01);             //错误率

    filter.put(1);
    filter.put(2);
    filter.put(3);

    boolean result = filter.mightContain(4);
    System.out.println(result);
  }

}
