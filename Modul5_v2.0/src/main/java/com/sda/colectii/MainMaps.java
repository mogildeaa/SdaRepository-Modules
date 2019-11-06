package com.sda.colectii;

import java.util.HashMap;
import java.util.Map;

public class MainMaps {

    public static void main(String[] args) {
        Map<String, User> utilizatori = new HashMap<>();

        User gigel = new User( "gigel1200xxx", "gigel@google.com", "asd" );
        User dorel = new User( "ladiesman69", "dorel_1@yahoo.co.uk", "asd" );
        User mircica = new User( "BenDover", "gigel@google.com", "asd" );

        setPairInMap(utilizatori, gigel);
        setPairInMap(utilizatori, dorel);
        setPairInMap(utilizatori, mircica);

//        System.out.println(utilizatori);
//        System.out.println(utilizatori.keySet());
//        System.out.println(utilizatori.values());

        printMap(utilizatori);
    }

    private static void setPairInMap(Map<String, User> userMap, User user) {
        if(userMap.containsKey(user.getEmail())){
            System.out.println("Key already exists. Will not save.");
        } else {
            userMap.put(user.getEmail(), user);
        }
    }

    private static void printMap(Map<String, User> map) {
        for (String key : map.keySet()){
            System.out.println(key + " = " + map.get(key));
        }
    }
}
