package Stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Operation employeeOperation = new Operation();
        EmployeeAddition employeeAddition = new EmployeeAddition();
        List<Employee> employeList = employeeAddition.addEmployee();

        //Task1

        Map<String, Long> maleAndFemaleCount = employeeOperation.maleAndFemaleEmployeeCount(employeList);
        for (Map.Entry<String, Long> gender : maleAndFemaleCount.entrySet()) {
            System.out.println(gender.getKey() + "--->" + gender.getValue());
        }


        //Task2

        Map<String, List<Employee>> listOfDepartment = employeeOperation.allDepartmentPresent(employeList);
        System.out.println("List of Department:");
        for (Map.Entry<String, List<Employee>> departmentList : listOfDepartment.entrySet()) {
            System.out.println(departmentList.getKey());
        }

        //Task3
        Map<String ,Double> averageAgeMaleAndFemale=employeeOperation.averageAgeofmaleAndFemale(employeList);
        System.out.println("Average age of Male and female");
        for (Map.Entry<String, Double> ageOfEmployee: averageAgeMaleAndFemale.entrySet()) {
            System.out.println(ageOfEmployee.getKey()+"-->"+ageOfEmployee.getValue());
        }

        //Task4

        Employee highPaidEmployee = employeeOperation.HighestPaidEmploye(employeList);
        System.out.println("Highest paid employe: " + highPaidEmployee);

        //Task5
        List<String> listOfEmployeeJoinedAfter2015 = employeeOperation.employeeJoinedAfterCertainDate(employeList);
        System.out.println("Names Of the employee joined after 2015 :" + listOfEmployeeJoinedAfter2015);

        //Task6

        Map<String, Long> departmentandNumberOfEmployeePresent = employeeOperation.emplyeeInEachDepartment(employeList);
        System.out.println("List of department and department size: ");
        departmentandNumberOfEmployeePresent.forEach((department, numberOfEmployee) -> System.out.println(department + "-->" + numberOfEmployee));

        //Task7

        Map<String, Double> averageSalaryOfEachDepartment = employeeOperation.averageSalaryOfEachDepartment(employeList);
        System.out.println("List of department and there averager Salary :");
        for (Map.Entry<String, Double> listElements : averageSalaryOfEachDepartment.entrySet()) {
            System.out.println(listElements.getKey() + "-->" + listElements.getValue());
        }

        //Task8

        Optional<Employee> youngestEmployee=employeeOperation.YoungestEmployeeInProdectDevelopmentTeam(employeList);
        System.out.println("The Youngest Employee Working in Product Development is "+ youngestEmployee.get().getName());

        //Task9
        Employee maxExperenceEmployee = employeeOperation.maximumWorkingExperience(employeList);
        System.out.println("The maximum experienced employee in the company is " + maxExperenceEmployee.getName());

        //Task10
        Map<String, Long> maleandFemaleEmplyeeInSaleAndMarketing = employeeOperation.CountOfMaleAndFemaleInSalesAndMarketing(employeList);
        System.out.println("Male and Female count in Sales and Marketing Department :");
        for (Map.Entry<String, Long> listElements : maleandFemaleEmplyeeInSaleAndMarketing.entrySet()) {
            System.out.println(listElements.getKey() + "-->" + listElements.getValue());
        }

        //Task11

        Map<String, Double> averageSalaryOfManAndFemale = employeeOperation.averageSalaryOfMaleAndFemale(employeList);
        System.out.println("The average salary of Man And Women");
        for (Map.Entry<String, Double> employee : averageSalaryOfManAndFemale.entrySet()) {
            System.out.println(employee.getKey() + "-->" + employee.getValue());
        }

        //Task12
        Map<String, List<Employee>> employeeNameInEachDepartment = employeeOperation.employeeListInEachDepartment(employeList);
        System.out.println("The employees in each department are:");
        for (Map.Entry<String, List<Employee>> employee : employeeNameInEachDepartment.entrySet()) {
            System.out.println("The Employees in " + employee.getKey() + "are :");
            for (Employee employeeName : employee.getValue()) {
                System.out.println(employeeName.getName());
            }

        }

        //Task13

        List<Double>totalAndAverageSalary=employeeOperation.averageAndTotalSalaryOfOrganization(employeList);
        System.out.println("the Total Salary of Organization is :"+totalAndAverageSalary.get(0));
        System.out.println("the Average Salary of Organization is :"+totalAndAverageSalary.get(1));

        //Task14
        List<Employee> employeeAgeLessthan25=employeeOperation.employeeAgeLessThan25(employeList);
        System.out.println("Employee Age Less than 25:");
        employeeAgeLessthan25.forEach(employee -> System.out.println(employee.getName()));


        //Task15
        Employee eldestEmplyee=employeeOperation.getTheOldestEmployee(employeList);
        System.out.print("The oldest employee name is :"+eldestEmplyee.getName());
        System.out.print(" and age is :"+eldestEmplyee.getAge());
        System.out.println(" and department is :"+eldestEmplyee.getDepartment());
    }
}


