package CalssesAndObject.Task2;

public class Employee {
    private String name;
    private int salary;
    private int year_Of_joining;
    private String address;

    Employee(String name, int salary, int year_Of_joining, String address) {
        this.name = name;
        this.salary = salary;
        this.year_Of_joining = year_Of_joining;
        this.address = address;
    }

    @Override
    public String toString() {
        return name+"  "+salary+"  "+year_Of_joining+"  "+address;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Robert", 8000000, 1994, "64C-WallsStreat");
        Employee e2 = new Employee("Sam", 7000000, 2000, "68D-WallsStreat");
        Employee e3 = new Employee("John", 5000000, 1999, "26B-WallsStreat");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

    }
}
