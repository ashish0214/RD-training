package Java8Features.BinaryandUnaryOperator;

import java.util.function.Consumer;

public class SquareOfANumber {
    public static Consumer<Integer> printSqareOfNumber(){
        Consumer<Integer> squareOfNumber=number-> System.out.println(number*number);
        return squareOfNumber;
    }

    public static void main(String[] args) {
        Consumer<Integer> squareNumber=printSqareOfNumber();
        squareNumber.accept(5);
    }
}
