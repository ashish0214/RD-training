/*Write a generic method to count the number of elements in a collection
 that have a specific property (for example, odd integers, prime numbers,
palindromes).*/

//Specific property in this method is Prime number

package Generics;

import java.util.ArrayList;
import java.util.List;

public class CountItemsOfList<T> {
    public static <T extends Number> int CountElemnts(List<T> list) {
        int count = 0;
        for (T element : list) {
            if (isPrime(element.intValue())) {
                count++;
            }
        }
        return count;
    }


    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
