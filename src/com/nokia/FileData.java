package com.nokia;

import java.util.List;

public class FileData {
	
	private String featureId;
	private String title;
	private String goal;
	private String purpose;
	private String prerequisite;
	private List<TestCaseStep> testCaseSteps;
	
	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

	public List<TestCaseStep> getTestCaseSteps() {
		return testCaseSteps;
	}

	public void setTestCaseSteps(List<TestCaseStep> testCaseSteps) {
		this.testCaseSteps = testCaseSteps;
	}

	@Override
	public String toString() {
		return "FileData [featureId=" + featureId + ", title=" + title + ", goal=" + goal + ", purpose=" + purpose
				+ ", prerequisite=" + prerequisite + ", testCaseSteps=" + testCaseSteps + "]";
	}

}
