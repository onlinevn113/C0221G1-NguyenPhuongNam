package testzone;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestLined_Array_List {
    public static void main(String[] args) {
        List<String> linkedList	=	new LinkedList<>();
        linkedList.add("New York");
        linkedList.add("Atlanta");
        linkedList.add("Dallas");
        linkedList.add("Madison");
        System.out.println(linkedList);

        List<String> arrayList	=	new ArrayList<>();
        arrayList.add("New York");
        arrayList.add("Atlanta");
        arrayList.add("Dallas");
        arrayList.add("Madison");
        System.out.println(arrayList);
    }
}
