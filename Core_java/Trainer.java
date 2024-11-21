package Core_java;

import java.util.Arrays;

public class Trainer extends Employee {

	private String[] skills;
	private String[] certification;

	public void printDetails() {
		super.printDetails();
		System.out.println("Skills: " + Arrays.toString(skills));
		System.out.println("Certifications: " + Arrays.toString(certification));
	}

	public String[] getSkills() {
		return skills;
	}

	public Trainer(int id, String name, double salary, Address address, String[] skills, String[] certification) {
		super(id, name, salary, address);
		this.skills = skills;
		this.certification = certification;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public String[] getCertification() {
		return certification;
	}

	public void setCertification(String[] certification) {
		this.certification = certification;
	}

}
