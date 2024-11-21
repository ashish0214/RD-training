package Java8Features.lambda;

import java.util.function.Function;
import java.util.function.Predicate;

public class Palindrome {
    public static void main(String[] args) {
        Predicate<String> predict = string -> {
            int maxsize = string.length() - 1;
            int start = 0;
            while (start < maxsize) {
                if (!(string.charAt(start)==string.charAt(maxsize))) {
                    return false;
                }
                start++;
                maxsize--;
            }
            return true;
        };
        if (predict.test("mom")) {
            System.out.println("palindrome");
        } else {
            System.out.println("not a palindrome");
        }
    }
}
