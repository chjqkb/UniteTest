package com.horstmann.corejava;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.*;

public class Employee  extends Person implements Comparable,Cloneable  {

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

    @Override
    public int compareTo(Object otherObject) {
        Employee other = (Employee)otherObject;
        return Double.compare(salary, other.salary);
    }

    public Employee clone() throws CloneNotSupportedException{
/*
            int year = this.getHireDate().getYear();
            int month = this.getHireDate().getMonthValue();
            int day = this.getHireDate().getDayOfMonth();
            double salary = this.getSalary();
            String name = this.getName();

            Employee cloned = new Employee(name, salary, year, month, day);
*/

            Employee cloned = (Employee) super.clone();
            return cloned;

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


        /*
        //按名字长度排序
        Comparator compar = new LengthComparator();
        Arrays.sort(staff, compar);

        out.printf("sort by  length: \n");
        for (Employee item: staff ) {
            out.print(item.getName() + "\t");
        }
*/

        //按名字的字典排序
        Arrays.sort(staff, new DictComparator());
        out.println("\nsort by dict: ");
        for (Employee item: staff ) {
            out.print(item.getName() + "\t");
        }
        Employee copy = null;

        try {
            copy = Harry.clone();
        }catch (CloneNotSupportedException e) {
            System.out.println("Error Clone().");
        }

        if(copy != null){
            out.println("cloned: ");
            copy.getDescription();
        }

        //用lambda表达式实现 Comparator<T> 接口，按照雇员的name的长度排序
        out.println("lambda sort by name length: ");
        Arrays.sort(staff, (a, b)->a.getName().length() - b.getName().length());

        for( Employee e : staff){
            out.print( e.getName() +"\t");
        }

        //测试，用lambda表达式实现名字长度的判断，如果长度等于6的名字就会被删除。
        out.println("\ndelete name length == 6");
        ArrayList<Employee> list = new ArrayList<>();

        for (Employee item : staff) {
            list.add(item);
        }

        list.removeIf(item -> item.getName().length() > 5);

        out.println(  list.toString());


    }
}