package Java8Features.BinaryandUnaryOperator;

import java.util.function.Predicate;

public class CheckPrimeNumberOrNot {
    public static Predicate<Integer> checkNumberisPrimeOrNot() {
        Predicate<Integer> isPrime = number -> {
            for (int startnumber = 2; startnumber < number / 2; startnumber++) {
                if (number % startnumber == 0) {
                    return false;
                }
            }
            return true;
        };
        return isPrime;
    }

    public static void main(String[] args) {
        Predicate<Integer> ValidateNumberPrimeOrNot = checkNumberisPrimeOrNot();
        if (ValidateNumberPrimeOrNot.test(11)) {
            System.out.println("It is prime Number");
        } else {
            System.out.println("Its not a Prime Number");
        }
    }
}
