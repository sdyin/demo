package com.sdyin.demo.threadlocal;

import com.sdyin.demo.utils.ThreadPoolUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author liuye
 * @Date 2020/11/3 17:53
 **/
@RequestMapping
@RestController
public class Test {

    /**
     * 测试父子线程ThreadLocal 传递
     */
    @RequestMapping("/test")
    private void test1() {
        ThreadLocal threadLocal = new InheritableThreadLocal();
        try {
            threadLocal.set("成功传递");
            ThreadPoolUtil.getPool().execute(() -> System.out.println("测试threadLocal 父子线程传递值 =" + threadLocal.get()));
        }finally {
            //ThreadLocal 内部维护 ThreadLocalMap -》 Entry 为 WeakReference 弱引用对象，
            //ThreadLocal在没有外部强引用时，发生GC时会被回收，
            // 如果创建ThreadLocal的线程一直持续运行，那么这个Entry对象中的value就有可能一直得不到回收，发生内存泄露。
            // 所以补充finally 语句移除
            threadLocal.remove();
        }
    }
}
