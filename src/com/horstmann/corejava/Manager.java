package com.horstmann.corejava;

import java.io.PrintStream;

public class Manager extends Employee {

    private double bounus;

    public void setBounus( double n) {
        bounus = n;

    }

    public double getBounus() {
        return bounus;
    }

    public Manager(String name, double salary) {
        super(name, salary);
        this.bounus = 0;
    }

    public double getSalary() {
        return bounus + super.getSalary();
        //return bounus + salary;   //如果salary在超类Employee中是private修饰，则访问不到。

    }

    public static void main(String[] args) {
        PrintStream out = System.out;
        Manager Alex = new Manager("Alex", 7777);
        Alex.setBounus(6000);
        out.printf("mananger name: %s, salary: %.2f, hireDate: %s",
                Alex.getName(), Alex.getSalary(), Alex.getHireDate().toString());
    }
}
