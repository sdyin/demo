package com.sdyin.demo.tomcat.classloader;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: liuye
 * @time: 2021/2/27$ 上午10:20$
 */
public class DemoClassLoader extends ClassLoader{

    private String classPath;

    public DemoClassLoader(String classPath) {
        this.classPath = classPath;
    }

    /**
     * 自定义类加载器：重写findClass方法
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            return defineClass(name, data, 0 , data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    private byte[] loadByte(String name) throws Exception{
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
        final int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;
    }

    /**
     * 重写loadClass方法,打破双亲委托
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);


            if (c == null) {
                // If still not found, then invoke findClass in order
                // to find the class.
                long t1 = System.nanoTime();
                //自定义类加载方式
                if(name.equals("com.sdyin.demo.tomcat.classloader.User")){
                    c = findClass(name);
                } else {
                    c = this.getParent().loadClass(name);
                }
                // this is the defining class loader; record the stats
                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();
            }

            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    /**
     * 打印结果： 可看出来是由不同类加载器加载
     * ==========自定义加载器类调用方法============
     * com.sdyin.demo.tomcat.classloader.DemoClassLoader@45ee12a7
     * ==========自定义加载器类调用方法============
     * com.sdyin.demo.tomcat.classloader.DemoClassLoader@4b67cf4d
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        DemoClassLoader demoClassLoader = new DemoClassLoader("/Users/liuye/Downloads/test/test1");
        Class<?> clazz = demoClassLoader.loadClass("com.sdyin.demo.tomcat.classloader.User");
        Object object1 = clazz.newInstance();
        Method method1 = clazz.getDeclaredMethod("sout", null);
        method1.invoke(object1, null);
        System.out.println(clazz.getClassLoader());

        DemoClassLoader demoClassLoader2 = new DemoClassLoader("/Users/liuye/Downloads/test/test2");
        Class<?> clazz2 = demoClassLoader2.loadClass("com.sdyin.demo.tomcat.classloader.User");
        Object object2 = clazz2.newInstance();
        Method method2 = clazz2.getDeclaredMethod("sout", null);
        method2.invoke(object2, null);
        System.out.println(clazz2.getClassLoader());
    }





}
