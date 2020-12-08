package com.sdyin.demo.threadlocal;

import com.sdyin.demo.utils.ThreadPoolUtil;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * 测试结果：
 *
 * 当前线程：main 变量值：111
 * 当前线程：Thread-0 变量值：111
 * 当前线程：pool-1-thread-1 变量值：null
 * 当前线程：main 变量值：111
 *
 * 结论： InheritableThreadLocal 支持父子线程间线程传递,但是线程池可能获取不到值。
 * 注意！！！ 此处线程池如果是之前创建的线程就获取不到
 * 如果是当前创建的线程池仍然可以获取到，因为当前创建的线程池创建线程仍然会执行 Thread的init方法。
 * @Author: liuye
 * @time: 2020/12/8$ 下午5:04$
 */
public class InheritableThreadLocalDemo {

    private static InheritableThreadLocal<String> local = new InheritableThreadLocal<>();

    private static ThreadPoolExecutor pool = ThreadPoolUtil.getPool();

    public static void main(String[] args) {
        try {
            local.set("111");
            test1();
            new Thread(() -> test1()).start();
            pool.execute(() -> test1());
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
