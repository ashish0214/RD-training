package Java8Features.lambda;
import java.util.Set;
import java.util.TreeSet;

public class SortTreeAlphabetically {
    public static void main(String[] args) {
        Set<Employe> employeeSet=new TreeSet<>((a,b)->a.getEmployeeName().compareTo(b.getEmployeeName()));
        employeeSet.add(new Employe(1,"ashish"));
        employeeSet.add(new Employe(2,"rohith"));
        employeeSet.add(new Employe(3,"abhay"));
        employeeSet.add(new Employe(4,"Sohail"));
        employeeSet.add(new Employe(5,"Umair"));
        employeeSet.forEach(System.out::println);
    }
}
