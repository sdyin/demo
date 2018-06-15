package com.sdyin.demo.redisLock2;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: liuye
 * @Date: 2018/6/15 16:18
 */
@RestController
@RequestMapping("/test")
public class RedisTest2 {

  @Autowired
  private RedisDao redisDao;

  int n = 100;

  @GetMapping("/test2")
  public void test() {

    //1.设置连接池的配置对象
    JedisPoolConfig config = new JedisPoolConfig();
    //设置池中最大连接数
    config.setMaxTotal(50);
    //设置空闲时池中保有的最大连接数
    config.setMaxIdle(10);
    //2.设置连接池对象
    JedisPool pool = new JedisPool(config,"172.30.1.211",6379,2000,"iboxpay");
    //3.从池中获取连接对象
    Jedis jedis = pool.getResource();
    jedis.select(15);
    String key = "LOCK";


    for(int i = 0; i < 5; i++){
      Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {

          String uuid = UUID.randomUUID().toString();
          RedisTool.tryGetDistributedLock(jedis,key,uuid,3000);
          System.out.println(Thread.currentThread().getName() + " 起跑");
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println(Thread.currentThread().getName() + " 到达终点");
          RedisTool.releaseDistributedLock(jedis,key,uuid);
        }
      });
      thread.start();
    }

    /*//所有线程阻塞，然后统一开始
     CountDownLatch begin = new CountDownLatch(1);

    //主线程阻塞，直到所有分线程执行完毕
    CountDownLatch end = new CountDownLatch(5);
    for(int i = 0; i < 5; i++){
      Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {
          try {
            begin.await();
            String uuid = UUID.randomUUID().toString();
            RedisTool.tryGetDistributedLock(jedis,key,uuid,3000);
            System.out.println(Thread.currentThread().getName() + " 起跑");
            //Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " 到达终点");
            RedisTool.releaseDistributedLock(jedis,key,uuid);
            end.countDown();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });
      thread.start();
    }
    try {
      System.out.println("1秒后统一开始");
      Thread.sleep(1000);
      begin.countDown();

      end.await();
      System.out.println("停止比赛");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/
  }

  @RequestMapping("/test3")
  public void test3(){

    redisDao.setEx("sdyin","sdyin",1000, TimeUnit.SECONDS);

  }
}
