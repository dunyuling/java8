package com.rc.java8.lambda;

/**
 * @ClassName Test
 * @Description lambda表达式初探
 * @Author liux
 * @Date 19-5-23 下午3:04
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        InterfaceOne interfaceOne = () -> System.out.println("InterfaceOne save");
        ClassImpl cl = new ClassImpl(interfaceOne);
        cl.save();
        System.out.println(interfaceOne.getClass().getInterfaces().length);
    }
}

@FunctionalInterface
interface InterfaceOne {
    void save();

    String toString();//直接继承自Object类,故不影响InterfaceOne接口抽象方法的数量
}

class ClassImpl implements InterfaceOne {

    ClassImpl(InterfaceOne interfaceOne) {
        interfaceOne.save();
    }

    @Override
    public void save() {
        System.out.println("ClassImpl save");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}