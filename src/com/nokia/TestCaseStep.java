package com.nokia;

public class TestCaseStep {

	private String step;
	private String expectedResult;

	public TestCaseStep() {
		// TODO Auto-generated constructor stub
	}

	public TestCaseStep(String step, String expectedResult) {
		super();
		this.step = step;
		this.expectedResult = expectedResult;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}

	@Override
	public String toString() {
		return "TestCaseStep [step=" + step + ", expectedResult=" + expectedResult + "]";
	}

	

	

	

}
