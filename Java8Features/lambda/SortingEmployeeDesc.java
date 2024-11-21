package Java8Features.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingEmployeeDesc {
    public static void main(String[] args) {
        List<Employe> employeList=new ArrayList<>();
        employeList.add(new Employe(1,"ashish"));
        employeList.add(new Employe(2,"rohith"));
        employeList.add(new Employe(3,"abhay"));
        employeList.add(new Employe(4,"Sohail"));
        employeList.add(new Employe(5,"Umair"));

        Collections.sort(employeList,(a,b)->b.getEmployeeName().compareTo(a.getEmployeeName()));

        employeList.forEach(System.out::println);
    }
}
