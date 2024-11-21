package Java8Features.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByName {
    public static void main(String[] args) {
        List<Employe>list=new ArrayList<>();
        list.add(new Employe(1,"ashish"));
        list.add(new Employe(2,"rohith"));
        list.add(new Employe(3,"abhay"));
        list.add(new Employe(4,"Sohail"));
        list.add(new Employe(5,"Umair"));

        Collections.sort(list,(a,b)->a.getEmployeeName().compareTo(b.getEmployeeName()));

        list.forEach(System.out::println);
    }
}
