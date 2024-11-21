package Core_java;

public class JuniorEngineer extends Employee {

	private int assessmentScore;
	private String feedback;

	public JuniorEngineer(int id, String name, double salary, Address address) {
		super(id, name, salary, address);

	}

	public int getAssessmentScore() {
		return assessmentScore;
	}

	public void setAssessmentScore(int assessmentScore) {
		this.assessmentScore = assessmentScore;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}
