package Java8Features.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ReverseTreeSort {
    public static void main(String[] args) {
        Set<Integer> setOfNumbers=new TreeSet<>((a,b)->b.compareTo(a));
        setOfNumbers.add(25);
        setOfNumbers.add(34);
        setOfNumbers.add(89);
        setOfNumbers.add(98);
        setOfNumbers.add(23);
        setOfNumbers.forEach(System.out::println);
    }
}
