package com.zaidathar.concept.java8.optional;

import java.util.Optional;

public class OptionalImpl {
    public static void main(String[] args) {
        String[] arr = new String[10];
        // String s = arr[5].toLowerCase(); // This will give null pointer exception

        Optional<String> checkNull = Optional.ofNullable(arr[5]);
        if(checkNull.isPresent()) {
            System.out.println(checkNull.get());
        }
        else{
            System.out.println("Word is not present in array");
        }

        arr[2] = "Zaid knows optional class";

        Optional<String> optional = Optional.of(arr[2]);

        if(optional.isPresent()){
            System.out.println("String found -> "+optional.get());
        }
        else{
            System.out.println("You will never be there , it will throw null pointer");

        }
    }
}
