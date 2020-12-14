package com.horstmann.corejava;

public class Student  extends  Person{

    private String major;

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public void getDescription() {
       System.out.printf("Student name: %s, Majoring: %s\n", getName(), major);
    }



    public static void main(String [] args) {
        Student mjj = new Student("Majjia", "Math");
        mjj.getDescription();
    }
}
