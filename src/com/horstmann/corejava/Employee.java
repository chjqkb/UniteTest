package com.horstmann.corejava;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Employee extends Person {
    private static int nextId;
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


    public Employee(String name,  double s, int year, int month, int day) {
        super(name);
        salary = s;
        hireDate = LocalDate.of(year, month, day);
    }

    public Employee(double s, int year, int month, int day){
        //this的作用之一： 调用该类的其他构造器：
        this("Employee #", s, year, month, day);
    }

    public Employee() {
       super("");
       System.out.println("In Employee() empty constructor...");
    }

    public  static int getNextId() {
        return nextId;
    }

    @Override
    public void getDescription() {
        System.out.printf("Name: %s, Salary: %.2f\n", getName(), getSalary());
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


    public boolean equals(Employee otherObject) {
        if(otherObject == null) return false;

        if(this == otherObject) return true;

        if(getClass() != otherObject.getClass()) return false;


        Employee other = (Employee)otherObject;
        return Objects.equals(getName(), other.getName())
                && getSalary() == other.getSalary()
                && Objects.equals(getHireDate(), other.getHireDate());

    }

    @Override
    public int hashCode() {

        int hash = 0;
        if (this instanceof Employee) {
            hash = super.getName().hashCode() + Double.hashCode(salary) + Objects.hashCode(hireDate);
        }


        return hash;
    }

    @Override
    public String toString() {

            return getName() + " : " + getHireDate() + " " + getSalary();

    }

    public static void main(String[] args) {
        Employee harry = new Employee("harry", 2222, 2020, 12, 1);
        harry.getDescription();

        Employee MazKula =  harry;//new Employee("MazKula", 2222, 2020, 12, 1);
        Employee Kong = null;
        MazKula.getDescription();

        System.out.println(harry.equals(Kong));


    }
}