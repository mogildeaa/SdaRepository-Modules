package StackAndQueues;

public class AbleToApplyAnApplication {

    public static void main(String[] args) {

        //Make queue great again! Circular queue!
        Queues queues = new Queues();
        queues.enqueue(20);
        queues.enqueue(30);
        queues.enqueue(10);
        queues.enqueue(40);
        queues.enqueue(50);
        queues.enqueue(50);
        for (int i = 0; i < 4; i++) {
            System.out.println(queues.dequeue() + " ");
        }
//        useQueue();
    }

    private static void useQueue() {
        Queues queue = new Queues();
        queue.enqueue(10);
        queue.enqueue(30);
        queue.enqueue(20);
        System.out.println(queue.dequeue() + "");
        System.out.println(queue.dequeue() + "");
        System.out.println(queue.dequeue() + "");
    }

}
