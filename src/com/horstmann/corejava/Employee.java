package com.horstmann.corejava;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Employee  extends Person implements Comparable  {
    private static int nextId;

    @Override
    public int compareTo(Object otherObject) {
        Employee other = (Employee)otherObject;
        return Double.compare(salary, other.salary);
    }

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
        PrintStream out = System.out;

        Employee Harry = new Employee("harry", 2222, 2020, 12, 1);
        Harry.getDescription();

        Employee Mazka =  new Employee("MazKa", 55555, 2020, 12, 1);

        Employee Milk = new Employee("milk", 44433, 1999,1,1);

        Employee Rockefeller = new Employee("feller", 77777, 2011, 5, 4);

        Employee[] staff = new Employee[4];

        staff[0] = Harry;
        staff[1] = Mazka;
        staff[2] = Milk;
        staff[3] = Rockefeller;

        out.println( Arrays.toString( staff));
        Arrays.sort(staff);

        out.printf("sorted staff: %s\n", Arrays.toString( staff ));




    }
}