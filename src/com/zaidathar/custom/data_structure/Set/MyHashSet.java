package com.zaidathar.custom.data_structure.Set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyHashSet<T> implements MySet<T>{
    private int DEFAULT_SIZE = 10;

    private HashMap<T, String> map;

    public MyHashSet(){
        this.map = new HashMap<>(DEFAULT_SIZE);

    }

    public MyHashSet(int capacity){
        this.map = new HashMap<>(capacity);
    }

    @Override
    public T add(T t) {
        map.put(t,"");
        return t;
    }


    @Override
    public int size() {
        return map.size();
    }


    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public void remove(T t) {
        map.remove(t);
    }


    @Override
    public boolean exist(T t) {
        return map.containsKey(t);
    }

    @Override
    public boolean equal(Object o) {
        if(this == o)
            return true;
        if(!(o instanceof MySet))
            return false;
        MySet<?> target = (MySet<?>) o;

        if(size() != target.size())
            return false;

        return containsAll((MySet<? extends T>) target);

    }

    public boolean containsAll(MySet<? extends T> obj){
        for(T t : obj){
            if(!this.exist(t))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        int h = 0;
        for (T t : this){
            if(t != null)
                h+= t.hashCode();
        }
        return h;
    }


}
