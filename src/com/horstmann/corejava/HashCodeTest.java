package com.horstmann.corejava;

import java.io.PrintStream;
import java.util.Objects;

public class HashCodeTest {

    public static void main(String[] args) {
        PrintStream out = System.out;

        Character character1 = new Character("Trump");

        Character character2 = new Character( "Trump");

        out.println( character1);
        out.println( character1.hashCode());

        out.println( character2);
        out.println( character2.hashCode());

        out.println( character1.hashCode() == character2.hashCode());
        out.println( character1.equals( character2));

        out.println("" + character1);

    }

}

class Character{

    private String Name = "";

    public Character( String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if ( otherObject == null ) return  false;

        if (getClass() != otherObject.getClass()) return  false;

        Character other = (Character)otherObject;

        return Objects.equals( Name, other.Name);
    }

    @Override
    public int hashCode() {

        return getName() != "" ? getName().hashCode() : 0;
    }

}
