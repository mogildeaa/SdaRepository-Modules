package com.sda.generics;

public class Box<Object> {

    private Object object;

    public Box(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
