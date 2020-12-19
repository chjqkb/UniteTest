package com.horstmann.corejava;

import java.io.PrintStream;
import java.util.Scanner;

public class EnumTest {

    public static void main(String[] args) {
        PrintStream out = System.out;

        Scanner scan = new Scanner(System.in);

        out.println("请输入你的Size: "+ "(SMALL, MEDIUM, LARGE, EXTRA_LARGE)");

        String intput = scan.next().toUpperCase();

        Size size = Enum.valueOf(Size.class, intput);

        out.println("size="+ size);

        out.println("size abbreviation= " + size.getAbbrivation());

        Size kerry = Size.MEDIUM;

        out.println("kerry size="+ kerry);
        out.println("kerry abbreviation=" + kerry.getAbbrivation());
    }

}


enum Size{
    SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");

    private String abbrivation;

    private Size( String abbrivation){ this.abbrivation = abbrivation;}

    public String getAbbrivation() {
        return this.abbrivation;
    }
}
