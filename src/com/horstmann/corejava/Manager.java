package com.horstmann.corejava;

import sun.security.action.PutAllAction;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Objects;

public class Manager extends Employee {

    private double bounus = 0;

    public void setBounus( double n) {
        bounus = n;

    }

    public double getBounus() {
        return bounus;
    }

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.bounus = 0;
    }

    public double getSalary() {
        return bounus + super.getSalary();
        //return bounus + salary;   //如果salary在超类Employee中是private修饰，则访问不到。

    }

    public boolean equals (Manager otherObject) {
        /*
        Manager 是 Employee 的子类。
        所以，先检测它的父类的域是否相等，
        如果检测过父类的域都相等，则再检测子类的域是否相等。
         */
        if (!super.equals(otherObject)) return false;
        Manager other = (Manager) otherObject;
        return  this.getBounus() == other.getBounus();
    }

    @Override
    public int hashCode() {
        int hash = 0;

        if (this instanceof Manager) {
            hash = super.hashCode() + Objects.hashCode(bounus);
        }

        return  hash;

    }

    public String toString() {
        return super.toString() + " " + getBounus();
    }

    public static void main(String[] args) {
        PrintStream out = System.out;
        Manager Alex = new Manager("Alex", 78777, 2019, 2, 24);
        Alex.setBounus(6000);
        Manager Gaslex = new Manager("Gaslex", 71777, 2009, 5, 19);
        Gaslex.setBounus(666);
        out.println(Alex.equals( Gaslex));

        Manager Soros = new Manager("Soros", 87772, 2016, 9, 14);

        Manager Buffie = new Manager("Buffie", 98822, 2005, 1, 20);


        Manager[] manager = new Manager[]{Alex, Gaslex, Soros, Buffie};


        //按名字长度排序
        Arrays.sort(manager, new LengthComparator());
        out.println("sort by length: ");
        for ( Manager item : manager) {
            out.print(item.getName() + " ");
        }
        out.println();


        //按字典顺序排序
        Arrays.sort(manager, new DictComparator());

        out.println("sort by Dict: ");
        for ( Manager item : manager) {
            out.print(item.getName() + " ");
        }
        out.println();



    }
}
