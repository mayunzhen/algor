package com.example.something;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map=new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        }
        );
        map.put(5, 10);
        map.put(3, 20);
        map.put(4, 40);
        map.put(2, 30);
        map.put(1, 10);
        for(Map.Entry<Integer, Integer> aEntry:map.entrySet()) {
            System.out.println(aEntry.getKey()+":"+aEntry.getValue());
        }
    }
}
