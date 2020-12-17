package com.horstmann.corejava;

/*
类工厂方法测试
 */
public  class Child {
    private int age = 11;
    private int weight = 120;

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

    public int getAga() { return age;    }

    public int getWeight(){ return weight;   }


    public static void main(String[] args) {
        Child yoki = Child.newChild(12, 139);
        Child xiaoming = Child.newChildWithAge(10);
        Child xiaohong = Child.newChildWithWeight(141);

        System.out.println(yoki.getAga() + " " + yoki.getWeight());
        System.out.println(xiaohong.getAga() + " " + xiaohong.getWeight());
        System.out.println(xiaoming.getAga() + " " + xiaoming.getWeight());

        Integer n = 5;
        Double m = 6.0;

        System.out.println( true ? n: m);

        String s = "333";
        n = Integer.parseInt(s);

        System.out.println(n);

    }
}