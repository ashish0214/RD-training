package Java8Features.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReverseOrderSorting {
    public static void main(String[] args) {
        List<Integer>list= Arrays.asList(2,345,43,43,4,34,23,44);
        Collections.sort(list,(a,b)->b.compareTo(a));
        list.forEach(System.out::println);
    }
}
