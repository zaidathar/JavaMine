package com.zaidathar.problems.basic;

import java.util.*;

public class ListProblems {
    private static boolean checkDuplicateUsingMap(List<Integer> ls){
        Map<Integer , Integer> mp = new HashMap<>();
        for(Integer i : ls){
            Integer val = mp.get(i);
            mp.put(i,val != null ? val+1 : 1);
        }

        for(Map.Entry me : mp.entrySet()){
            if((Integer) me.getValue() > 1){
                return true;
            }
        }
        return false;
    }

    private static boolean checkDuplicateUsingSorting(List<Integer> ls){
        Collections.sort(ls);
        for(int i = 1 ; i < ls.size(); i++){
            if(ls.get(i) == ls.get(i-1)) return true;
        }
        return false;
    }

    private static boolean checkDuplicateUsingSet(List<Integer> ls){
        Set<Integer> set = new HashSet<>();
        set.addAll(ls);
        return !(ls.size() == set.size());
    }
    public static boolean isDuplicateExist(List<Integer> ls){
        return checkDuplicateUsingMap(ls);
        // return checkDuplicateUsingSorting(ls);
        // return checkDuplicateUsingSet(ls);
    }
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1,2,3,4,5,6,6,7,7,8,9); // return true for this list
        //List<Integer> ls = Arrays.asList(1,2,3,4,5,6,7,8,9); // return false for this list
        System.out.println("Is duplicate found "+isDuplicateExist(ls));
    }
}
