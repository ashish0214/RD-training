package Java8Features.FunctionalInterface.Predicate;

import java.util.ArrayList;
import java.util.List;

public class NewProductAddition {
    public static List<Product> addProduct() {
        List<Product> productList=new ArrayList<>();
        productList.add(new Product("Bat",5000,"Toys",'A'));
        productList.add(new Product("Car",20000.6,"Transportation",'A'));
        productList.add(new Product("pendrive",50,"electronics",'A'));
        productList.add(new Product("choclate",80,"food",'B'));
        productList.add(new Product("gun",5600,"safety",'C'));
        productList.add(new Product("table",500,"Study",'B'));
        productList.add(new Product("phone",50000,"electronics",'A'));
        productList.add(new Product("laptop",100000,"electronics",'A'));
return productList;

    }
}
