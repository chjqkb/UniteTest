import java.io.PrintStream;
import java.util.Scanner;

public class UniteTest {
    public static void main(String [] args){
        PrintStream out = System.out;
/*
        out.println("请输入你要检测的整数： ");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        out.printf("你输入的整数是奇数？ %b\n", isOdd(i));
 */


    }

    public static  boolean isOdd(int i){
        return i%2 !=0;
    }
}

class Employee {


    private static int nextId = 1;

    private String name;
    private int id;
    private float salary;

    public Employee(String empname,  float empsalary) {
        name = empname;
        salary = empsalary;
    }

    public  void setNextId() {
        id = nextId;
        nextId++;
    }

    public  int getNextId() {
        return nextId;
    }
    public String  getName() {
        return name;
    }

    public int getId(){
        return  id;
    }

    public float getSalary(){
        return salary;
    }

    public static void main(String[] args) {
        Employee stuff = new Employee("TomCat", 500);
        stuff.setNextId();
        System.out.printf("Stuff's name %s, number: %d, salary: %f\n", stuff.getName(), stuff.getId(), stuff.getSalary());
        System.out.println("nextId: "+ stuff.getNextId());
    }
}


class Child {
    private int age = 0;
    private int weight = 0;

    public static Child newChild(int age, int weight) {
        Child child = new Child();
        child.weight = weight;
        child.age = age;
        return child;
    }

    public static Child newChildWithAge(int age) {
        Child child = new Child();
        child.age = age;
        return  child;
    }

    public static Child newChildWithWeight(int weight) {
        Child child = new Child();
        child.weight = weight;
        return  child;
    }
}