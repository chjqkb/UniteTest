package com.horstmann.corejava;

import java.time.LocalDate;
import java.util.Random;

public class Employee {


    private static int nextId;

    private String name = ""; //instance field initialiation
    private int id;
    private double salary;
    private LocalDate hireDate =null;

    // 静态初始化块
    static {
        System.out.println("In Static initialiation block ... ");
        int n = new Random().nextInt(1000);
        nextId = n;

    }

    //对象初始化块
    {
        System.out.println("In instance initialiation block ... ");
        id = nextId;
        nextId++;
    }


    public Employee(String n,  double s) {
        name = n;
        salary = s;
        hireDate = LocalDate.now();
    }

    public Employee(double s){
        //this的作用之一： 调用该类的其他构造器：
        this("Employee #", s);
    }

    public Employee() {
       /*
       所有都被初始化为默认值。
       name --- ""
       id --- 对象初始化块
       salary --- explicity initialized  0
        */
       System.out.println("In Employee() empty constructor...");
    }

    /*
    public  void setNextId() {
        id = nextId;
        nextId++;
    }
    */

    public  static int getNextId() {
        return nextId;
    }
    public String  getName() {
        return name;
    }

    public int getId(){
        return  id;
    }

    public double getSalary(){
        return salary;
    }

    public void raiseSalary(double percent) {
        salary = salary * ( 1.0 + percent);
    }

    public LocalDate getHireDate() { return  hireDate; }

    public static void main(String[] args) {
        Employee harry = new Employee( 6666);
        System.out.printf("Stuff's name: %s, number: %d, salary: %.2f\n", harry.getName(), harry.getId(), harry.getSalary());
        System.out.println("nextId: "+ harry.getNextId());
        harry.raiseSalary( 0.1);
        System.out.println("new salary: " + harry.getSalary());

        Employee kong = new Employee();
        System.out.printf("Stuff's name: %s, number: %d, salary: %.2f\n", kong.getName(), kong.getId(), kong.getSalary());
        System.out.println("nextId: "+ kong.getNextId());
        harry.raiseSalary( 0.1);
        System.out.println("new salary: " + kong.getSalary());

    }
}