package com.rc.java8.lambda;

/**
 * @ClassName Child
 * @Description Child pojo
 * @Author liux
 * @Date 19-5-24 下午6:30
 * @Version 1.0
 */
public class Child {

    private String name;

    public Child(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                '}';
    }
}
