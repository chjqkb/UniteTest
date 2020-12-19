package com.horstmann.corejava;


public abstract  class Person implements Cloneable {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract void getDescription();

    public  String getName(){
        return name;
    }

    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}
