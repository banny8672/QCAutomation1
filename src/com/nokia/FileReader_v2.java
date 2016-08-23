package com.nokia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class FileReader_v2 {
	public static FileData readFile(String path) throws IOException {

		FileInputStream fi = new FileInputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fi));
		String line;
		List<TestCaseStep> steps = null;
		TestCaseStep step = null;

		boolean isTitleData = false;
		String titleData = "";
		boolean isGoalData = false;
		String goalData = "";
		boolean isPurposeData = false;
		String purposeData = "";
		boolean isPrerequisiteData = false;
		String prerequisiteData = "";
		

		FileData fileData = new FileData();
		while ((line = br.readLine()) != null) {
			line = line.trim();
			String temp = line;
			line = line.toLowerCase();
			if (line.startsWith("print(\"") && !line.contains("------") && !line.contains("handling")
					&& line.contains(":")) {
				temp = temp.substring(temp.indexOf(":") + 1).trim();
				temp = temp.substring(0, temp.length() - 3).trim();
				if (line.contains("exp")) {
					if (step != null) {
						step.setExpectedResult(temp);
						if (steps == null) {
							steps = new ArrayList<>();
						}
						steps.add(step);
						step = null;
					}
				} else if (line.contains("step")) {
					step = new TestCaseStep();
					step.setStep(temp);
				}
			}else if (line.contains("<title>") || isTitleData) {
				isTitleData = true;
				if (!line.contains("<title>") && !line.contains("</title>"))
					titleData += temp;
				if(line.contains("</title>")) {
					isTitleData = false;
					fileData.setTitle(titleData);
				}

			}else if(line.contains("<goal>") || isGoalData){
				isGoalData = true;
				if(!line.contains("<goal>") && !line.contains("</goal>"))
					goalData += temp;
				if(line.contains("</goal>")){
					isGoalData = false;
					fileData.setGoal(goalData);
				}
			}else if(line.contains("<purpose>") || isPurposeData){
				isPurposeData = true;
				if(!line.contains("<purpose>") && !line.contains("</purpose>"))
					purposeData = temp+"\n";
				if(line.contains("</purpose>")){
					isPurposeData = false;
					fileData.setPurpose(purposeData);
				}
			}else if(line.contains("<pre-requisite>") || isPrerequisiteData){
				isPrerequisiteData = true;
				if(!line.contains("<pre-requisite>") && !line.contains("</pre-requisite>"))
					prerequisiteData = temp+"\n";
				if(line.contains("</pre-requisite>")){
					isPrerequisiteData = false;
					fileData.setPrerequisite(prerequisiteData);
				}
			}
		}
		
		if (br != null)
			br.close();
		fileData.setTestCaseSteps(steps);
		return fileData;
	}
}
