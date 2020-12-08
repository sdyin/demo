package com.sdyin.demo.threadlocal;

/**
 * @Description:
 * 测试结果：
 * 当前线程：main 变量值：111
 * 当前线程：Thread-0 变量值：null
 * 当前线程：main 变量值：111
 *
 * 结论： threadlocal 不能父子线程传递
 * @Author: liuye
 * @time: 2020/12/8$ 下午4:56$
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> local = new ThreadLocal<String>();

    public static void main(String[] args) {
        try {
            local.set("111");
            test1();
            new Thread(() -> test1()).start();
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
