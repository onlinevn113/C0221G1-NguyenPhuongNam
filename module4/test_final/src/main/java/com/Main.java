package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String a = "abccda";
        System.out.println(new Main().maxCharacter(a));
    }

    public static List<String> maxCharacter(String s) {
        String[] arr = s.split("");
        Map<String, Integer> map = new HashMap();
        List<String> arr2 = new ArrayList();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (!arr[i].equals(" ") && arr[i].equals(arr[j])) {
                    map.put(arr[i], 1);
                    break;
                }
            }
        }
        arr2.add(String.valueOf(map.keySet()));
        return arr2;
    }
}
