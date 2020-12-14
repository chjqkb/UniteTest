package com.horstmann.corejava;


public abstract  class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract void getDescription();

    public  String getName(){
        return name;
    }
}
