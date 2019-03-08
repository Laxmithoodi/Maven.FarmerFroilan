package com.zipcodewilmington.froilansfarm.storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Storage<T> {
    List<T> items = new ArrayList<T>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

}
