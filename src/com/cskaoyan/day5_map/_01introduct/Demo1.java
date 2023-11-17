package com.cskaoyan.day5_map._01introduct;

import java.util.HashMap;
import java.util.Map;

/**
 * Map就是存储键值对数据的。我们需要根据key，找value的时候，就可以使用到这个Map
 *
 * 110 是警察局
 * 120 是医院
 * 119 是火警
 * 122 是车辆救援
 *
 */
public class Demo1 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(110,"是警察局");
        map.put(120,"是医院");
        map.put(119,"是火警");
        map.put(122,"是车辆救援");
        System.out.println(map);
        System.out.println(map.get(110));
    }
}
