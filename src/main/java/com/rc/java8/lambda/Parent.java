package com.rc.java8.lambda;

import java.util.List;

/**
 * @ClassName Parent
 * @Description Parent pojo
 * @Author liux
 * @Date 19-5-24 下午6:30
 * @Version 1.0
 */
public class Parent {

    private String name;

    private List<Child> children;

    public Parent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
