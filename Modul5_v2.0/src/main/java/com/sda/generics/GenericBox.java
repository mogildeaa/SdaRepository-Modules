package com.sda.generics;

public class GenericBox<T> {

    private T t;

    public GenericBox(T item) {
        this.t = item;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
