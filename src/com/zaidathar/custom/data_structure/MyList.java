package com.zaidathar.custom.data_structure;

public interface MyList<T> {
    void insert(T t);
    T get(int index);

    void remove(int index);
    void remove(T value) throws Exception;
    int size();
    boolean isEmpty();
}
