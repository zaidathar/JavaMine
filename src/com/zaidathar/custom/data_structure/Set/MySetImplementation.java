package com.zaidathar.custom.data_structure.Set;

public class MySetImplementation {
    public static void main(String[] args) {
        MySet<Integer> mySet = new MyHashSet<>();
        mySet.add(1);
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);

        for(Integer i : mySet){
            System.out.print(i+" ");
        }
        System.out.println();

    }
}
