package com.sda.colectii;

import java.util.*;

public class Main {


    static List<String> stringList = new LinkedList<>();
    static Set<String> stringSet = new HashSet<>();

    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "b";

        stringList.add(a);
        stringList.add(b);
        stringList.add(c);
        stringList.add(d);
        System.out.println(stringList);

        stringSet.add(a);
        stringSet.add(b);
        stringSet.add(c);
        stringSet.add(d);
        System.out.println(stringSet);

        //extragem elemente
        System.out.println(stringList.get(2));

        //stergem elemente
        stringList.remove("a");
        System.out.println(stringList);
        stringList.remove(2);
        System.out.println(stringList);

        String[] strings = stringSet.toArray(new String[0]);
//        printArray(stringSet);
//        printCollection(stringSet);
    }

    private static void  printCollection (Collection<String> strings){
        //cazul cel mai intalnit
        for (String s : strings){
            System.out.println(s);
        }

        //alternativa
//        Iterator<String> iterator = strings.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
    }

    static void printArray(String[] strings) {
        for (String s : strings){
            System.out.println(s);
        }
    }
}


