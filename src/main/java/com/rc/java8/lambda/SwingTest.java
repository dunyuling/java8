package com.rc.java8.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName SwingTest
 * @Description TODO
 * @Author liux
 * @Date 19-5-23 下午2:22
 * @Version 1.0
 */
public class SwingTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My Frame");
        JButton jButton = new JButton("My Button");
        jButton.addActionListener((ActionEvent e) -> System.out.println("I am clicked"));
//        jButton.addActionListener(e -> System.out.println("I am clicked"));

        jFrame.add(jButton);
//        jFrame.pack();
        jFrame.setVisible(true);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

/*
        new Thread(() -> {

        }).start();

        jButton.addActionListener((ActionEvent e) -> {

        });*/
    }
}
