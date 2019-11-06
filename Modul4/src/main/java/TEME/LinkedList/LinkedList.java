package TEME.LinkedList;

import java.sql.SQLOutput;

public class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {

    }

    public void add(int data) {

        Node myNode = new Node(data);

        if (tail == null) {
            head = myNode;
            tail = myNode;
        } else {
            tail.nextNode = myNode;
            tail = myNode;
        }
    }

    public Node delete(int data) {
        //gasesc nodu de delete
        //iau pointerul de la nodul din urma si il asignez catre nextNode

        Node myNode = find(data);
        if (myNode == null) {
            System.out.println("LL does not have a node with " + data + " as a value.");
        } else {
            if (myNode.getData() == head.getData()) {
                head.nextNode = head;
            }

            if (myNode.getData() == tail.getData()) {


            }
        }
        return null;
    }

    public Node find(int data) {

        int count = 1;
        // 1: Daca LL are head egal cu valoarea
        // 2: Daca LL are tail egal cu valoarea
        // 3: Celelalte cazuri
        if (head == null) {
            System.out.println("The LL is empty");
            return null;
        }
        if (data == head.getData()) {
            System.out.println("The value is the head of the LL: " + data + ".");
            return head;
        }

        Node urmatorulNode = head;
        while (urmatorulNode.nextNode != null) {
            urmatorulNode = urmatorulNode.nextNode;
            count++;
            if (urmatorulNode.getData() == tail.getData()) {
                System.out.println("The value is the tail of the LL: " + urmatorulNode.getData() + ".");
            }

            if (urmatorulNode.getData() == data) {
                System.out.println("The value was found in the " + count + " node: " + data);
                return urmatorulNode;
            }
        }
        return null;
    }

    public void print() {

        if (tail == null) {
            System.out.println("There is no element in the linked list");
        }

        if (head != tail) {

            System.out.println(head.getData());
            System.out.println(tail.getData());
        }

        if (head == tail) {
            System.out.println("It's just a single element in the LL: " + tail.getData());
        }
    }
}
