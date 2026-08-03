package com.loan.app;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private List<T> data = new ArrayList<>();

    public void save(T object){
        data.add(object);
    }

    public List<T> getAll(){
        return data;
    }
}
