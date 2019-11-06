package com.sda.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;
import java.util.LinkedList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class DatabaseConnection {

    public static void main(String[] args) {

        // Cream o conexiune (nu uitam sa o inchidem)
        MongoClient client = new MongoClient();

        //ne conectam la baza de date - daca nu exista va fi creata automat de mongo
        MongoDatabase database = client.getDatabase("biblioteca_java");
        //din baza de date extragem colectia - daca nu exista va fi creata automat
        MongoCollection<Document> carti = database.getCollection("carti");

        //cream un document nou
        Document myFirstBook = new Document("autor", "Jules Verne")
                .append("titlu", "20.000 de leghe sub mari")
                .append("disponibil", true);

        //salvam documentul in db
        carti.insertOne(myFirstBook);

        //extragem documentele din db si il salvam pe primul
        Document first = carti.find().first();
        System.out.println(first);

        System.out.println("Structura unui document din JAVA: " + new Document());

        //update query
        carti.updateOne(
                eq("titlu", "20.000 de mii de leghe sub mari"),
                new Document("$set",
                        new Document("titlu", "20.000 de leghe sub mari")));

//        insertBatch(carti, 100);
        afiseazaContinut(carti);


        carti.deleteMany(new Document());
        System.out.println("Documente ramase " + carti.find().iterator().hasNext());

        //inchidem conexiunea
        client.close();
    }

    private static void afiseazaContinut(MongoCollection<Document> carti) {
        FindIterable<Document> documents = carti.find();
        MongoCursor<Document> iterator = documents.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void insertBatch(MongoCollection<Document> carti, int limit) {

//        for (int i = 0; i < 100; ++i) {
//            carti.insertOne(new Document("i", i));
//        }
        // SAU (mai optim)
        List<Document> documente = new LinkedList<>();
        for (int i = 0; i < 100; ++i) {
            documente.add(new Document("i", i));
        }
        carti.insertMany(documente);
    }
}
