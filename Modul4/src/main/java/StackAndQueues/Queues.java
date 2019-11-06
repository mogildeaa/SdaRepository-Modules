package StackAndQueues;

public class Queues {
    public static final int MAX_SIZE = 4;
    private int[] queue = new int[MAX_SIZE];
    private int head = 0;
    private int tail = -1;

    void enqueue(int val) {
        //Evitarea suprascrierii head-ului.
        //Daca tail nu este primul element si indexul HEAD este egal cu tail + 1
        if ((head == ((tail + 1) % MAX_SIZE)) && (tail != -1)) {
            return;
        }

        // Incrementam circular indexul
        if (tail == MAX_SIZE - 1) {
            tail = 0;
        } else {
            tail++;
        }
        //Sau ce am scris la if se mai poate scrie si sub forma:
        //tail = (tail + 1) % MAX_SIZE;
        queue[tail] = val;
    }

    int dequeue() {
        //TODO: Fix to avoid indexing on not set values
        if (head > tail) {
            //  System.out.println("Ur are next");
        }
        int val = queue[head];
        // Incrementam circular indexul
        head = (head + 1) % MAX_SIZE;
        return val;
    }
}
