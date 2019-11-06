package temaQueue;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args){
//        ex1Queue();

    }

    private static void ex1Queue() {
        LocalDate azi = LocalDate.now();
        LocalDate ieri = LocalDate.now().minusDays(1);
        Order myOrder = new Order(azi, 5, "pizza");
        Order myOrder2 = new Order(ieri, 2, "pasta");
        myOrder.toString();
        System.out.println(" ");
        myOrder2.toString();
    }
}
