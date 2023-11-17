package com.cskaoyan.day7_stream._01introduct;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        //对学生列表处理：得到来自北京的 身高最高的三位同学
//        List<Student> studentList = new StudentList().studentList;//用一个类来初始化列表
        List<Student> studentList = new ArrayList<>();//面向接口编程的思想，即尽量使用接口类型来声明变量，从而使得程序更加灵活和可扩展。
        studentList.add(new Student("aa", 18, 170, Student.Address.BJ));
        studentList.add(new Student("bb", 20, 163, Student.Address.SH));
        studentList.add(new Student("cc", 30, 182, Student.Address.WH));
        studentList.add(new Student("dd", 16, 190, Student.Address.BJ));
        studentList.add(new Student("ee", 15, 210, Student.Address.SH));
        studentList.add(new Student("ff", 17, 160, Student.Address.WH));
        studentList.add(new Student("gg", 18, 169, Student.Address.BJ));
        studentList.add(new Student("hh", 20, 173, Student.Address.WH));
        studentList.add(new Student("ii", 22, 192, Student.Address.SH));
        studentList.add(new Student("jj", 25, 172, Student.Address.SH));
        studentList.add(new Student("kk", 24, 188, Student.Address.BJ));
        // 重复元素 kk
        studentList.add(new Student("kk", 24, 188, Student.Address.BJ));
        studentList.add(new Student("kk", 24, 188, Student.Address.BJ));
        studentList.add(new Student("ll", 17, 161, Student.Address.WH));
        studentList.add(new Student("mm", 18, 169, Student.Address.SH));
        studentList.add(new Student("nn", 20, 162, Student.Address.BJ));
        studentList.add(new Student("oo", 22, 166, Student.Address.SH));
        studentList.add(new Student("pp", 24, 176, Student.Address.WH));
        studentList.add(new Student("qq", 22, 173, Student.Address.BJ));
        // 重复元素 qq
        studentList.add(new Student("qq", 22, 173, Student.Address.BJ));
        studentList.add(new Student("rr", 24, 177, Student.Address.BJ));
        studentList.add(new Student("ss", 17, 169, Student.Address.SH));
        studentList.add(new Student("tt", 18, 170, Student.Address.SH));
        studentList.add(new Student("uu", 20, 171, Student.Address.WH));
        studentList.add(new Student("vv", 22, 172, Student.Address.WH));
        studentList.add(new Student("ww", 24, 181, Student.Address.BJ));
        studentList.add(new Student("xx", 18, 188, Student.Address.SH));
        studentList.add(new Student("yy", 20, 183, Student.Address.BJ));
        studentList.add(new Student("zz", 22, 191, Student.Address.WH));


        //来自北京的
        List<Student> beijingStudentList = new ArrayList<>();
        for (Student student : studentList) {
            if (Student.Address.BJ.equals(student.getAddress())){
                beijingStudentList.add(student);
            }
        }
        //排序拿前三个
        beijingStudentList.sort((o1, o2) -> o1.getHeight()-o2.getHeight());
        System.out.println(beijingStudentList.get(0));
        System.out.println(beijingStudentList.get(1));
        System.out.println(beijingStudentList.get(2));


    }
    @Test
    public void testSelectUseStream(){
        List<Student> studentList = new StudentList().studentList;
        List<Student> beijingHigher3StudentList = studentList.stream()
                .filter(s -> Student.Address.BJ.equals(s.getAddress()))
                .sorted(((o1, o2) -> o1.getHeight()-o2.getHeight()))
                .limit(3).collect(Collectors.toList());
        System.out.println(beijingHigher3StudentList);
    }
}
