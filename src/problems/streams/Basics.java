package problems.streams;

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
    public static void main(String[] args) {
        List<Integer> intergerList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println("Duplicate found in list "+checkDuplicateUsingHashSet(intergerList));
    }
}
