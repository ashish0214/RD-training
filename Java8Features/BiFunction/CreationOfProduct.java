package Java8Features.BiFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class CreationOfProduct {

    public static BiFunction generateProduct(){
        BiFunction<String, Integer, Product> createNewProduct = (name, price) -> {
            if (price > 1000) {
                return new Product(name, price, "electronics", "Premium");
            } else {
                return new Product(name, price, "toy", "Normal");
            }
        };
        return createNewProduct;
    }
    public static List<Product> addProduct(){
        BiFunction<String, Integer, Product> NewProduct=generateProduct();
        List<Product>listOfProducts=new ArrayList<>();
        listOfProducts.add(NewProduct.apply("phone",30000));
        listOfProducts.add(NewProduct.apply("bat",100));
        listOfProducts.add(NewProduct.apply("earphones",9000));
        listOfProducts.add(NewProduct.apply("Playsation",300));
        listOfProducts.forEach(System.out::println);
        return listOfProducts;
    }

}
