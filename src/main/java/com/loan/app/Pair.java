package com.loan.app;

public class Pair<K,V> {
    private K key;
    private V value;

    public Pair(K key,V value){
        this.key = key;
        this.value = value;
    }

    public void printPair(){
        System.out.println(key +" -> "+value);
    }
}
