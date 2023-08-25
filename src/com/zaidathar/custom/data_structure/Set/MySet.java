package com.zaidathar.custom.data_structure.Set;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public interface MySet<T> extends Iterable<T>{
    T add(T t);
    int size();
    boolean isEmpty();

    void remove(T t);
    boolean exist(T t);

    boolean equal(Object o);

    int hashCode();

    default Iterator<T> iterator() {
        return this.iterator();
    }



    default Spliterator<T> spliterator() {
        return this.spliterator();
    }

}
