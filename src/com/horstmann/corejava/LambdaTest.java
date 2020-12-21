package com.horstmann.corejava;

import javax.management.timer.Timer;
import javax.swing.*;
import java.util.Date;

public class LambdaTest {

    public static void main(String[] args) {

        Thread run = new Thread( ()-> System.out.println("hello lambda thread..."));
        run.start();

        //调用的时候，传入一个 lambda 表达式，代替函数式接口（3）
        repead(10, v ->System.out.println("Countdown : " + (9-v)));


    }

    //需要函数式接口的方法（2）
    public static void repead(int n, intConsumer action ){
        for (int i = 0; i < n; i++) {
            action.repead(i);
        }
    }
}

//函数式接口（1）
interface intConsumer{
     void repead(int value);
}