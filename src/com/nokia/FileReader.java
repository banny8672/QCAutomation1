package com.nokia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;


public class FileReader {
	public static FileData readFile(String featureId, String path) throws IOException {


		final String str =  new String(Files.readAllBytes(Paths.get(path)));
		//final String str = FileUtils.readFileToString(new File(path));

		String titleData = StringUtils.substringBetween(str, "<Title>", "</Title>");
		String goalData = StringUtils.substringBetween(str, "<Goal>", "</Goal>");
		String purposeData = StringUtils.substringBetween(str, "<Purpose>", "</Purpose>");
		String prerequisiteData = StringUtils.substringBetween(str, "<Pre-Requisite>", "</Pre-Requisite>");

		FileInputStream fi = new FileInputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fi));
		String line;
		List<TestCaseStep> steps = null;
		TestCaseStep step = null;

		FileData fileData = new FileData();
		
		fileData.setFeatureId(featureId);
		fileData.setTitle(titleData);
		fileData.setGoal(goalData);
		fileData.setPurpose(purposeData);
		fileData.setPrerequisite(prerequisiteData);
		
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
			}
		}

		if (br != null)
			br.close();
		fileData.setTestCaseSteps(steps);
		return fileData;
	}
}
