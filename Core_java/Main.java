package Core_java;

public class Main {
	public static void main(String[] args) {
		Address address1 = new Address(10, "Madhapur", "Hyderabad", "Telangana", "India");

		Employee employee1 = new Employee(1, "Ashish", 50000.0, address1);
		Employee employee2 = new JuniorEngineer(2, "Umer", 60000.0, address1);
		Employee employee3 = new SoftwareEngineer(3, "Sohail", 70000.0, address1, "Project XYZ");
		Employee employee4 = new Trainer(4, "Abhay", 80000.0, address1, new String[] { "Java", "Python" },
				new String[] { "Java Certification" });

		System.out.println("Employee 1 Details:");
		employee1.printDetails();
		System.out.println();

		System.out.println("Employee 2 Details:");
		employee2.printDetails();
		System.out.println();

		System.out.println("Employee 3 Details:");
		employee3.printDetails();
		System.out.println();

		System.out.println("Employee 4 Details:");
		employee4.printDetails();
		System.out.println();

		Course course = new Course(101, "Java Programming", 30);

		System.out.println("Course Details:");
		System.out.println("Course ID: " + course.getId());
		System.out.println("Course Name: " + course.getName());
		System.out.println("Course Duration: " + course.getDuration() + " hours");
	}
}
