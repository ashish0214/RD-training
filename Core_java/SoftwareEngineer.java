package task1;

public class SoftwareEngineer extends Employee {
	private String projectName;

	public SoftwareEngineer(int id, String name, double salary, Address address, String projectName) {
		super(id, name, salary, address);
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void printDetails() {
		super.printDetails();
		System.out.println("Project Name: " + projectName);
	}

}
