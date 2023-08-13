package com.zaidathar.custom.data_structure;
import java.util.Arrays;


public class MyArrayList<T> implements MyList<T>{

    private final Integer DEFAULT_SIZE = 6; // Default size of array
    private final Double THRESHOLD = 0.75d; // To resize array
    private int cur_ind = 0; // initial index will be zero
    private T[] array ;

    public MyArrayList(){
        this.array = (T[])new Object[DEFAULT_SIZE];
    }

    public MyArrayList(int size){
        this.array = (T[]) new Object[size];
    }

    // I have to accept only element which strictly belongs to array's type
    @Override
    public void insert(T t) {
        if(cur_ind >= THRESHOLD * array.length){
            resize();
        }

        this.array[cur_ind] = t;
        cur_ind++;
    }

    @Override
    public T get(int index) {
        if(index >= cur_ind){
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        return this.array[index];
    }

    @Override
    public void remove(int index) {
        if(index >= cur_ind){
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        removeValueAtIndex(index);
    }


    @Override
    public void remove(T t) {
        int index = -1;
        for(int i = 0; i < cur_ind ;i++){
            if(array[i] == t){
                index = i;
                break;
            }
        }
        if(index == -1)
            throw new IndexOutOfBoundsException(t+" doesn't exist in "+array.getClass());
        removeValueAtIndex(index);
    }

    private void removeValueAtIndex(int index){
        if(index < 0 | index >= cur_ind)
            throw new IndexOutOfBoundsException(index+" is out of bound! size of list is "+cur_ind);
        for(int i =index ; i<cur_ind-1;i++){
            array[i] = array[i+1];
        }
        cur_ind--;
    }

    @Override
    public int size(){
        return cur_ind;
    }

    @Override
    public boolean isEmpty() {
        return cur_ind == 0 ;
    }

    public void print(){
        for(int i=0;i<cur_ind;i++){
            if( i < cur_ind - 1)
                System.out.print(array[i]+", ");
            else
                System.out.println(array[i]);
        }
    }

    private void resize(){
        int newCapacity = array.length*2;
        array = Arrays.copyOf(array, newCapacity);
    }
}
