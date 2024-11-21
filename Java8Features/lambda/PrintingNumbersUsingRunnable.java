package Java8Features.lambda;

public class PrintingNumbersUsingRunnable {
    public static void main(String[] args) {
        Runnable thread = () -> {
            for (int i = 0; i <= 10; i++) {
                System.out.println(i);
            }
        };
        thread.run();
    }
}
