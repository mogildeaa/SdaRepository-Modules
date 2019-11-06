package com.sda.Exceptions;

import java.net.ConnectException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        System.out.println("Deschid conexiune la baza de date");
        //citit dintr-o baza de date
        int numarClienti = 10;

        //citit din raport economic din aplicatia Y
        int profitNetObtinut = 1000;

        System.out.println("Calculez profit per client");
        try {
            if (numarClienti == 0) {
                throw new SQLException("No clients");
            }

            if (profitNetObtinut == 0) {
                throw new ConnectException("Missing connection");
            }
            int profitPerClient = profitNetObtinut / numarClienti;
            System.out.println("Profitul este: " + profitPerClient);
//            System.out.println("Inchid conexiune la baza de date")
//            Daca las asta de mai sus si se executa acelasi lucru si in finally o sa-mi apara o eroare!
        } catch (SQLException sqlE){
            System.out.println("Ceva nu a mers in cinexiunea la db");
            System.out.println("Inchid conexiunea");
        } catch (ConnectException cE) {
            System.out.println("Ceva nu a mers la conexiunea cu raportul");
            System.out.println("Inchid conexiune cu raport");
        } catch (Exception e) {
            System.out.println("Ceva a mers foarte prost:");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Inchid baza de date (db)");
        }
//conteaza ordinea catch urilor

        System.out.println("Inchei executie");
    }
}
