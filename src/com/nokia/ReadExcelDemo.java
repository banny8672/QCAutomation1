package com.nokia;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.joda.time.LocalDateTime;

public class ReadExcelDemo {

	//private static Scanner sc;
	
	//public static final String INPUT_PATH = "D:/A360/ASHA";
	public static final String INPUT_PATH = "D:/A360/FC123_107002_Multiple_HPLMN_SUPPORT";

	public static final String OUTPUT_PATH = "D:\\test\\";
	public static final String OUTPUT_FILE_FORMAT = ".xlsx";
	
	public static void main(String[] args) throws IOException 
	{
		//sc = new Scanner(System.in);
		//System.out.println("Enter the path : ");
		//String parentDirectoryPath = s.nextLine();
		
		File file = new File(INPUT_PATH);
		String currentDateTime = (new LocalDateTime()).toString().replaceAll(":", "_");
		String outputFile = OUTPUT_PATH +"Workflow_"+ currentDateTime+OUTPUT_FILE_FORMAT;
		System.out.println(outputFile);
		
		Queue<File> folders = new LinkedList<>();
	
		List<FileData> fileDataList = new ArrayList<>();
		
		if (file.isDirectory()) {
			folders.offer(file);
			System.out.println("File Path "+file.getPath());
		}

		while (!folders.isEmpty()) {
			file = folders.poll();
			File[] files = file.listFiles();
			if (files != null) {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {
						folders.offer(files[i]);
					} else if (files[i].getName().startsWith("FC") && files[i].getName().endsWith(".ctl")) {
						System.out.println("Parent  ==> "+files[i].getParentFile().getName()+"  File ==> "+files[i].getName());

						FileData fileData = FileReader.readFile(files[i].getParentFile().getName(), files[i].getPath());
						if (fileData != null) {
							//System.out.println(fileData.toString());
							fileDataList.add(fileData);
						}
					}

				}
			}
		}

		if (fileDataList != null && fileDataList.size() > 0) {
			XLSWriter.writeTestCases(outputFile, fileDataList, 20);
		}
	}

}
