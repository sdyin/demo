package com.sdyin.demo.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

import static org.apache.zookeeper.CreateMode.PERSISTENT;

/**
 * @Description:
 * @Author: liuye
 * @time: 2020/9/18$ 下午11:13$
 */
@Slf4j
public class ZkDemo {

    final static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws Exception {

        final ZooKeeper zooKeeper = new ZooKeeper("101.132.103.136:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //如果收到了服务端的响应事件,连接成功
                countDownLatch.countDown();
                log.info("receiver watch event:" + watchedEvent);
            }
        });

        final String path = zooKeeper.create("/yege1", "yege".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, PERSISTENT);
        log.info("success create path:" + path);

        countDownLatch.await();
        log.info("【初始化ZooKeeper连接状态....】={}", zooKeeper.getState());
    }
}
