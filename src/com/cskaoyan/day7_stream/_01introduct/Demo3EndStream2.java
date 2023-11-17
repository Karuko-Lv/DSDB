package com.cskaoyan.day7_stream._01introduct;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo3EndStream2 {
    @Test
    public void testCollect1(){
        //获取武汉同学的集合
        List<Student> studentList = new StudentList().studentList;
        List<Student> collect = studentList.stream().filter(student -> Student.Address.WH.equals(student.getAddress())).collect(Collectors.toList());
        System.out.println(collect);
    }


}
