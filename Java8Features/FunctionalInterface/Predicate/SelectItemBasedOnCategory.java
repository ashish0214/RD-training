package Java8Features.FunctionalInterface.Predicate;

import java.util.List;
import java.util.function.Predicate;

public class SelectItemBasedOnCategory extends NewProductAddition {

    public static void main(String[] args) {
        Predicate<String> isSameCategory = category -> category.equalsIgnoreCase("electronics");
        List<Product> itemList = addProduct();
        for (Product item : itemList) {
           if (isSameCategory.test(item.getCategory())){
                System.out.println(item);
            }
        }

    }
}
