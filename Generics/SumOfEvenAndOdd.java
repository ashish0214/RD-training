/*Write a Java program to create a generic method that takes a list
of numbers and returns the sum of all the even and odd numbers.*/

package Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class SumOfEvenAndOdd {
    public static <T extends Number> List<Integer> sum(List<T> list) {

        List<Integer> resultList = new ArrayList<>(2);

        int sumOfEvenElemenmts = 0, sumOfOddElemets = 0;
        for (T elements : list) {
            if (elements.intValue() % 2 == 0) {
                sumOfEvenElemenmts+=elements.intValue();
            } else {
                sumOfOddElemets+=elements.intValue();
            }
        }
        return resultList = Arrays.asList(sumOfEvenElemenmts, sumOfOddElemets);
    }
}
