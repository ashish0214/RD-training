package Java8Features.BinaryandUnaryOperator;

import java.util.function.Supplier;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        Supplier<Integer> randomNumer = () -> {
            int randomenumber = (int) (Math.random() * 5000);
            return randomenumber;
        };
        System.out.println(randomNumer.get());
    }
}
