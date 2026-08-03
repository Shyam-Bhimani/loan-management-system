package com.loan.app;

public class NumberBox<T extends Number> {
    private T value;
    public NumberBox(T value){
        this.value=value;
    }

    public void print(){
        System.out.println(value);
    }
}
