package StackAndQueues;

public class Application {

    public static void main(String[] args){
        Stack myStack = new Stack();
        myStack.push(10);
        myStack.push(30);
        myStack.push(20);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }

}
