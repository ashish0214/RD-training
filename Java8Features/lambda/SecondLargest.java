package Java8Features.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class SecondLargest {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(23,4,5,56,32,45,55,99);
        Function<List<Integer>,Integer> secondLargestElement= arrayList->{
            Collections.sort(arrayList);
            return arrayList.get(arrayList.size() - 2);

        };

        System.out.println("Second largest element is "+secondLargestElement.apply(list));
    }
}
