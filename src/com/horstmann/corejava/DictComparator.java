package com.horstmann.corejava;

import java.util.Comparator;

public class DictComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Person staff1 = (Person)o1;
        Person staff2 = (Person)o2;

        return staff1.getName().toString().compareTo( staff2.getName().toString());
    }
}
