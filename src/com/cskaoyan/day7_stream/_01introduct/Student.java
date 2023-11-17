package com.cskaoyan.day7_stream._01introduct;

import java.util.Objects;

public class Student {
    //枚举规范常量 定义命名常量集合
    public enum Address{
        BJ, SH, WH, SZ
    }
    private String name;
    private int age;
    private int height;
    private Address address;

    public Student(String name, int age, int height, Address address) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && height == student.height && Objects.equals(name, student.name) && address == student.address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height, address);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", address=" + address +
                '}';
    }
}
