package Java8Features.FunctionalInterface.Predicate;

import java.util.List;
import java.util.function.Predicate;

public class SelectItemBasedOnPrice extends NewProductAddition{


    public static void main(String[] args) {
        Predicate<Double> isGreater=price->price>1000;
        List<Product> itemList=addProduct();
        for(Product item:itemList){
            if(isGreater.test(item.getPrice())){
                System.out.println(item);
            };
        }

    }
}
