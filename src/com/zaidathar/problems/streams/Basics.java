package com.zaidathar.problems.streams;

import java.util.*;
import java.util.stream.Collectors;

public class Basics {

    public static boolean checkDuplicateUsingFrequency(List<Integer> l){
        Set<Integer> res = l.stream()
                .filter(i -> Collections.frequency(l,i) > 1)
                .collect(Collectors.toSet());

        return res.size() > 0;
    }

    public static boolean checkDuplicateUsingHashSet(List<Integer> ls){
        Set<Integer> set = new HashSet<>();
        return ls.stream().anyMatch( a -> !set.add(a));
    }

    public static <E> E findFirstUsingOptional(Collection<E> collection) throws Exception {
         Optional<E> firstValue = collection.stream().findFirst();
         if(firstValue.isPresent())
             return firstValue.get();
         else
             throw new Exception("Null value found ");
    }


    public static <E> E findFirst2(Collection<E> collection) throws Exception{
        return collection.stream().reduce((first,second) -> first).orElse(null);
    }
    public static void main(String[] args) {
        List<Integer> intergerList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println("Duplicate found in list "+checkDuplicateUsingHashSet(intergerList));
        List<Integer> nullList = null;
        try{
            System.out.println("First element in list is "+findFirst2(intergerList));
            System.out.println("First element in null list is "+findFirst2(nullList));
        }
        catch (Exception e){
            System.out.println("Exception caught : "+e.getMessage());
        }

    }


}
