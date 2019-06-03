package com.rc.java8.methodreference;

/**
 * @ClassName StudentComparator
 * @Description Student对象比较器
 * @Author liux
 * @Date 19-5-24 下午11:45
 * @Version 1.0
 */
public class StudentComparator {

    public static int compareStudentByScore1(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }

    public static int compareStudentByName1(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());
    }

    public int compareStudentByScore2(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }

    public int compareStudentByName2(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());

    }
}
