package Java8Features.FunctionalInterface.Predicate;

import java.util.List;
import java.util.function.Predicate;

public class SelectItemIfPriceLow extends NewProductAddition {
    public static void main(String[] args) {
        Predicate<Double> isPriceGreater= price->price<100;
        Predicate<String> isElectronics=category->category.equalsIgnoreCase("electronics");
        List<Product> itemList=addProduct();
        for(Product product:itemList){
            if(isPriceGreater.test(product.getPrice()) && isElectronics.test(product.getCategory())){
                System.out.println(product);
            }
        }
    }
}
