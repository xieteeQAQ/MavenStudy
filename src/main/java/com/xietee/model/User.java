package com.xietee.model;

/*
编写 User 类，包含 name、age，重写 toString()、equals()、hashCode()，创建两个内容相同的对象测试 equals()
 */

import java.util.Objects;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        if (age < 0) {
            System.out.println("年龄不能为负, 已置 0");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("年龄不能为负");
        } else {
            this.age = age;
        }
    }

    @Override
    public String toString() {
        return "名字: " + name + ", 岁数: " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && age == user.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
