package com.sdyin.demo.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import com.sdyin.demo.utils.ThreadPoolUtil;

import java.util.concurrent.Executor;

/**
 * @Description:
 * 测试结果：
 * 当前线程：main 变量值：111
 * 当前线程：Thread-1 变量值：111
 * 当前线程：pool-1-thread-1 变量值：111
 * 当前线程：main 变量值：111
 *
 * 结论：
 * TTL 可以支持线程池内变量传递
 *
 * @Author: liuye
 * @time: 2020/12/8$ 下午5:22$
 */
public class TransmittableThreadLocalDemo {

    private static TransmittableThreadLocal<String> local = new TransmittableThreadLocal<>();

    //注意！！！： 使用TTL 要想传递的值不出问题，线程池必须得用TTL加一层代理
    private static Executor executor = TtlExecutors.getTtlExecutor(ThreadPoolUtil.getPool());


    public static void main(String[] args) {
        try {
            local.set("111");
            test1();
            new Thread(() -> test1()).start();
            executor.execute(() -> test1());
            Thread.sleep(100);
            test1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            local.remove();
        }
    }

    private static void test1() {
        System.out.println("当前线程：" + Thread.currentThread().getName() + " 变量值：" + local.get());
    }
}
