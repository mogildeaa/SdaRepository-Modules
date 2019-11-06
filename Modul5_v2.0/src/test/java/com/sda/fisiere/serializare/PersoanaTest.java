package com.sda.fisiere.serializare;


import com.sda.fisiere.IFileManipulator;
import com.sda.fisiere.ModernFileManipulator;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;


public class PersoanaTest {

    private Persoana person = new Persoana("Gheorge", 18);
    private IFileManipulator modern = new ModernFileManipulator();

    @Test
    public void testSerializare() {
        String pathAddress = PersoanaTest.class
                .getClassLoader()
                .getResource("person.txt")
                .getPath()
                .replaceFirst("/", "");
//            //path interfata
//            //paths classa care are metode in ea
//            Path path = Paths.get(pathAddress);
//            // file e classa din java IO;
//            //files e classa din java NIO (noua)
//            List<Persoana> writableContent = new ArrayList<>();
//            writableContent.add(person)
//            Files.write(path, person);

        File file = new File(pathAddress);

        writeObjectToFile(file);

        //declaram un obiect de tip Persoana care va contine obiectul citit din fisier
        Persoana readPerson = readPersonFromFile(file);
        //verificam ca am reusit sa citim ceva
        assertNotNull(readPerson);

        System.out.println(readPerson.getNume());
        System.out.println(readPerson.getVarsta());
    }

    private Persoana readPersonFromFile(File file) {
        //varianta legacy, din acelasi motiv ca si in metoda de write
        Persoana readPerson = null;
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream =
                     new ObjectInputStream(fileInputStream)) {
            //citim din fisier un obiect, pe care il castam la Persoana
            readPerson = (Persoana) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return readPerson;
    }

    //legacy
    private void writeObjectToFile(File file) {
        //folosim metode si clase legacy - java.io
        //deoarece avem neovie de acest ObjectOutputStream care face parte din java.IO si nu din java.NIO
        try {
            FileOutputStream fileOutputStream =
                    new FileOutputStream(file);
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(fileOutputStream);
            //aici se scrie in fisier obiectul
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}