package com.cskaoyan.day7_stream._01introduct;

import org.junit.Test;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo3EndStream1 {
    @Test
    public void testAnyMatch1(){
        //是否有北京的学生
        List<Student> studentList = new StudentList().studentList;
        long count = studentList.stream().filter(student -> Student.Address.BJ.equals(student.getAddress())).count();
        if (count > 0){
            System.out.println("有北京的学生");
        }
        //终止流操作有哪些 count和anymatch都是的 只要调用了终止操作就会变成一个普通的元素了 就不是流了
        boolean anyMatch = studentList.stream().anyMatch(student -> Student.Address.BJ.equals(student.getAddress()));
        System.out.println(anyMatch);

        //判断高于190的是否存在北京人
        boolean anyMatch1 = studentList.stream().filter(student -> student.getHeight() > 190).anyMatch(student -> Student.Address.BJ.equals(student.getAddress()));
        System.out.println(anyMatch1);
        //控制台检验一下
        List<Student> collect = studentList.stream().filter(student -> student.getHeight() > 190).collect(Collectors.toList());
        System.out.println(collect);

    }
    @Test
    public void testAllMatch(){
        //判断是否都是北京人
        List<Student> studentList = new StudentList().studentList;
        boolean b = studentList.stream().allMatch(student -> Student.Address.BJ.equals(student.getAddress()));
        System.out.println(b);
        boolean b1 = studentList.stream().filter(student -> Student.Address.BJ.equals(student.getAddress())).allMatch(student -> Student.Address.BJ.equals(student.getAddress()));
        System.out.println(b1);
        //判断高于200的是否都是上海人
        boolean b2 = studentList.stream().filter(student -> student.getHeight() > 200).allMatch(student -> Student.Address.SH.equals(student.getAddress()));
        System.out.println(
                b2
        );
    }

    @Test
    public void testNoneMatch(){
        //代码中尽量不要使用带反义的 会很绕
        List<Student> studentList = new StudentList().studentList;
        //没有大于30的 也就是都小于等于30才返回true
        boolean b = studentList.stream().noneMatch(student -> student.getAge() > 30);
        System.out.println(b);
    }
    @Test
    public void testFindAny(){
        //找到任意一个
        List<Student> studentList = new StudentList().studentList;
        Optional<Student> any = studentList.stream().filter(student -> Student.Address.BJ.equals(student.getAddress())).findAny();
        System.out.println(any.isPresent());
    }


}
