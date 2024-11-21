package Java8Features.BiFunction;

import java.util.Map;
import java.util.function.BiFunction;

public class CalculatevalueOfCart {

    public static double Calculate(Map<Product, Integer> cart) {
        double totalValue = 0;
        for (Map.Entry<Product, Integer> cartElement : cart.entrySet()) {
            Product product = cartElement.getKey();
            Integer quantity = cartElement.getValue();
            totalValue +=


        }
    }

    private double getPriceCalculator() {
        final BiFunction<Product, Integer, Double> priceCalculator = (product, quantity) -> {
            Double price = product.getPrice();

            return price * quantity;
        };
    }

}
