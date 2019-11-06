package temaQueue;

import java.time.LocalDate;

public class Order {
    private LocalDate date;
    private int quantity;
    private String item;

    public Order(LocalDate date, int quantity, String item){
        this.date = date;
        this.quantity = quantity;
        this.item = item;
    }

    public String toString(){
        System.out.print(date + " - " + quantity + " - " + item);
        return null;
    }

//    private class OrderQueue(){
//        Order myOrder;
//        void enqueue(Order myOrder)(
//
//        }
//    }
}
