package com.sdyin.demo.classloader;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author liuye
 * @Date 2020/11/3 14:05
 **/
public class Sample {

    private Sample instance;

    public void setSample(Object instance) {
        this.instance = (Sample) instance;
    }

    public static void testClassIdentity() {
        String classDataRootPath = "D:\\develop\\test_work\\demo\\target\\classes";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
        String className = "com.sdyin.demo.classloader.Sample";
        try {
            Class<?> class1 = fscl1.findClass(className);
            Object obj1 = class1.newInstance();
            Class<?> class2 = fscl2.findClass(className);
            Object obj2 = class2.newInstance();
            Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
            //java.lang.reflect.InvocationTargetException
            //运行时抛出了 java.lang.ClassCastException 异常。
            // 虽然两个对象 obj1 和 obj2 的类的名字相同，但是这两个类是由不同的类加载器实例来加载的，因此不被 Java 虚拟机认为是相同的。
            setSampleMethod.invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testClassIdentity();
    }
}
