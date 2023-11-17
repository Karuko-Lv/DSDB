package com.cskaoyan.day7_stream._01introduct;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo2CreateStream {
    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("aa");
        list.add("aa");
        Stream<String> stream = list.stream();
        System.out.println(stream);
    }
    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("aa");
        list.add("aa");
        Stream<String> stringStream = Stream.of(list.get(0), list.get(1),list.get(2));
        System.out.println(stringStream);
    }

    @Test
    public void test3(){
        String[] strs = {"zs","ls","wu"};
        Stream<String> stream = Arrays.stream(strs);
    }
}
