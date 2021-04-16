package testzone;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestHashSet {
    public static void main(String[] args) {
        HashSet hashSet=new HashSet();
        hashSet.add("c"+1);
        hashSet.add("controllers"+2);
        hashSet.add("b"+3);
        hashSet.add("d"+0);
        System.out.println(hashSet);
        TreeSet treeSet=new TreeSet();
        treeSet.add(232);
        treeSet.add(222);
        treeSet.add(2212);
        System.out.println(treeSet);
        LinkedHashSet set=new LinkedHashSet();
        set.add(2321);
        set.add(2322);
        set.add(2323);
        System.out.println(set);
        
    }
}
