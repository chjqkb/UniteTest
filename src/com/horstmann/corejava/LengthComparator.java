package com.horstmann.corejava;

import java.util.Comparator;

public class LengthComparator implements Comparator {
    @Override
    public int compare(Object ob1, Object ob2) {
        Person staff1 = (Person ) ob1;
        Person staff2 = (Person) ob2;
        return staff1.getName().length() - staff2.getName().length();
    }
}
