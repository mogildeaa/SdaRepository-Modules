package com.sda.streams;

import com.sda.lambdas.Person;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {

        List<Person> people = com.sda.lambdas.Main.getPeople();

        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            String name = person.getName();
            System.out.println(name);
        }

        for (Person temp : people) {
            String name = temp.getName();
            System.out.println(name);
        }

        //Operatie initiala
        Stream<Person> stream = people.stream();
        //Operatii terminale
        List<Person> collect = stream.collect(toList());
        //Operatii intermediare
        //map si filter

        //vreau sa afisez doar varstele perosanelor cu varsta sub 18 ani
        //abordare plain java
        for (Person temp : people) {
            int varsta = temp.getAge();
            if (varsta < 18) { //filtrez <filter> dupa varsta<map>
                String name = temp.getName();
                System.out.println(name);
            }
        }

        //abordare streamuri
        people.stream()
                //map imi intoarce si trimite mai departe de pe obiectul primit (persoana) valoarea din getAge()
                .map(person -> person.getAge())
                //filter imi trimite mai departe doar intrarile care respecta conditita (varsta<18)
                .filter(age -> age < 18)
                //peek ma lasa sa am o operatiune intermediara unde am acces la date sysout
                .peek(age -> System.out.println(age))
                //collect imi intoarce valorile din stream care au ajung aici (mapate si filtrate) intr-o colectie noua
                .collect(toList());

        //rescris mai citet cum ar trebui sa arate ala de mai sus:
        Predicate<Integer> isUnderAged = age -> age < 18;
        List<Integer> collect1 = people.stream()
                .map(Person::getAge)
                .filter(isUnderAged)
                .peek(System.out::println)
                .collect(toList());

        //vreau sa stiu daca Ionel este in lista
        Optional<String> isIonelPresent = people.stream()
                .map(Person::getName)
                .filter(name -> name.equals("Ionel"))
                .findAny();
        isIonelPresent.ifPresent(string -> System.out.println("Este prezent"));

        //EXECMPLU pt ARRAY-uri:
//        String[] myArray = {"1", "2"};
//        Stream<String> streamDeArray = Stream.of(myArray);
    }
}
