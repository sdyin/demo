package com.sdyin.demo.redisLock;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author: liuye
 * @Date: 2018/6/15 15:53
 */
public class RedisTest {

  private static RedisTemplate<Object, Object> redisTemplate;

  public static void main(String[] args) {

    RedisDistributedLock lock = new RedisDistributedLock(redisTemplate);

  }
}
