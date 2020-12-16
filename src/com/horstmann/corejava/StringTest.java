package com.horstmann.corejava;

import java.io.PrintStream;

public class StringTest {

    public static void main(String[] args) {
        PrintStream out = System.out;

        //测试 == 和 equals 的区别
        int m = 3;
        int n = 3;

        String sName = new String("You");  // 每次 new String() 都会创建一个新的 String Object. 但是，如果用 字面字符串，则字面字符串对象会在 String Pool 保存。
        String tName = new String( "You");
        String bName = new String("You");

        out.println(m == n);
        out.println( "You" == "You");
        out.println( sName == tName ); //引用了不同的对象。
        out.println( sName.equals( tName )); // String 重写了 Objcet 的 equals 方法，比较的是内容。
        out.println(sName.hashCode());   // String 重写 Object 的 hashCode 方法。 equals 返回true，hashCode 也要返回 true
        out.println(tName.hashCode());

        tName = bName;
        sName = bName;
        out.println( tName);
        out.println("sName value: " + sName);
        out.println( tName == sName);  //tName 和 sName 引用相同的 String Object -- bName。 所以，它们的对象地址就一样了。测试的是「数值」

    }
}
