package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Operation {

/*1.	How many male and female employees are there in the organization?
            2.	Print the name of all departments in the organization?
            3.	What is the average age of male and female employees?
            4.	Get the details of highest paid employee in the organization?
            5.	Get the names of all employees who have joined after 2015?
            6.	Count the number of employees in each department?
            7.	What is the average salary of each department?
            8.	Get the details of youngest male employee in the product development department?
            9.	Who has the most working experience in the organization?
            10.	How many male and female employees are there in the sales and marketing team?
            11.	What is the average salary of male and female employees?
            12.	List down the names of all employees in each department?
            13.	What is the average salary and total salary of the whole organization?
            14.	Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
15.	Who is the oldest employee in the organization? What is his age and which department he belongs to?

 */

    //Task1


    Map<String, Long> maleAndFemaleEmployeeCount(List<Employee> employeeList) {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

    }

    //Task2
    Map<String, List<Employee>> allDepartmentPresent(List<Employee> employeeList) {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    //Task3
    Map<String, Double> averageAgeofmaleAndFemale(List<Employee> employeeList) {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(employee -> employee.getAge())));
    }

    //Task4
    Employee HighestPaidEmploye(List<Employee> employeeList) {
        Optional<Employee> highestSalary = employeeList.stream().max((employee1, employee2) -> (int) employee1.getSalary() - (int) employee2.getSalary());
        return highestSalary.get();
    }

    //Task5
    List<String> employeeJoinedAfterCertainDate(List<Employee> employeeList) {
        return employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2015).map(employee -> employee.name).collect(Collectors.toList());
    }

    //Task6
    Map<String, Long> emplyeeInEachDepartment(List<Employee> employeeList) {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

    }

    //Task7
    Map<String, Double> averageSalaryOfEachDepartment(List<Employee> employeeList) {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    //Task8

    Optional<Employee> YoungestEmployeeInProdectDevelopmentTeam(List<Employee> employeeList) {
       return employeeList.stream().filter(employee -> employee.getGender().equalsIgnoreCase("Male")&&employee.getDepartment().equalsIgnoreCase("Product Development")).min((employee1,employee2)->employee1.getAge()-employee2.getAge());
    }

    //Task9

    Employee maximumWorkingExperience(List<Employee> employeeList) {
        Optional<Employee> maxExperiencedEmployee = employeeList.stream().max((employee1, employee2) -> employee2.getYearOfJoining() - employee1.getYearOfJoining());
        return maxExperiencedEmployee.get();
    }

    //Task10
    Map<String, Long> CountOfMaleAndFemaleInSalesAndMarketing(List<Employee> employeeList) {
        return employeeList.stream().filter(employee -> employee.getDepartment().equalsIgnoreCase("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

    }

    //Task11
    Map<String, Double> averageSalaryOfMaleAndFemale(List<Employee> employeeList) {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(emplyee -> emplyee.salary)));
    }

    //Task12
    Map<String, List<Employee>> employeeListInEachDepartment(List<Employee> employeeList) {
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
    }

    //Task13

    List<Double> averageAndTotalSalaryOfOrganization(List<Employee> employeeList) {
        Double totalSalary = employeeList.stream().collect(Collectors.summingDouble((employee1) -> employee1.getSalary()));
        Double averageSalary = employeeList.stream().collect(Collectors.averagingDouble((employee1) -> employee1.getSalary()));
        return Arrays.asList(totalSalary, averageSalary);
    }

    //Task14
    List<Employee> employeeAgeLessThan25(List<Employee> employeeList) {
        return employeeList.stream().filter(employee -> employee.getAge() <= 25).toList();
    }

    //Task15
    Employee getTheOldestEmployee(List<Employee> employeeList) {
        Optional<Employee> oldestEmployee = employeeList.stream().max((employee1, employee2) -> employee1.getAge() - employee2.getAge());
        return oldestEmployee.get();
    }

}
