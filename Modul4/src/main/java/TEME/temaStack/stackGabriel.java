package TEME.temaStack;

import java.util.Scanner;

public class stackGabriel {
    public static void main(String[] args){
//        iCanDoIt();
//        ex2Impossible();
//        ex3ReverseConsola();

//        StringStack cuvant = new StringStack(1);
//        cuvant.reverse("atiatab");
    }

    private static void ex3ReverseConsola(){
        StringStack myMethod = new StringStack(10);
        Scanner s = new Scanner(System.in);
        String myString = s.nextLine();
        myMethod.method(myString);
    }

    private static void ex2Impossible(){
        StringStack myMethod = new StringStack(10);
        myMethod.method("done. it's until impossible seems always It");
    }

    private static void iCanDoIt(){
        StringStack myStack = new StringStack(10);
        myStack.push("it!");
        myStack.push("do");
        myStack.push("can");
        myStack.push("I");
        System.out.print(myStack.pop() + " ");
        System.out.print(myStack.pop() + " ");
        System.out.print(myStack.pop() + " ");
        System.out.print(myStack.pop() + " ");
    }
}
