package com.sdyin.demo.java.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap(链表 + 数组) 可以指定按照访问时间排序
 * @Description TODO
 * @Author admin
 * @Date 2019/9/8 9:51
 **/
public class LinkedHashMapDemo {

    public static void main(String[] args) {
        // 10 -> 初始大小
        // 0.75 -> 装载因子
        // true -> 按访问时间排序
        HashMap<Integer, Integer> map =
                new LinkedHashMap<>(10,0.75f,true);
        map.put(3,11);
        map.put(1,12);
        map.put(5,23);
        map.put(2,22);

        //3,1,5,2
        for (Map.Entry e : map.entrySet()){
            System.out.println(e.getKey());
        }

        map.put(3,26);
        map.get(5);

        //1,2,3,5
        for (Map.Entry e : map.entrySet()){
            System.out.println(e.getKey());
        }

    }
}
