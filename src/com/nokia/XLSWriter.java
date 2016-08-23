package com.nokia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSWriter {

	public static void writeTestCases(String path, List<FileData> fileList, int maxStep)
			throws IOException {
		if (fileList != null) {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet spreadsheet = workbook.createSheet("Testcaseinfo");
			int rowId = 0;
			for (FileData fileData : fileList) {
				if (fileData != null) {
					XSSFRow row = spreadsheet.createRow(rowId++);
					int cellId = 0;
					StringBuilder stepBuilder = new StringBuilder();
					StringBuilder expBuilder = new StringBuilder();
					
					Cell featureIDCell = row.createCell(cellId++);
					featureIDCell.setCellValue(fileData.getFeatureId());
					Cell titleCell = row.createCell(cellId++);
					titleCell.setCellValue(fileData.getTitle());
					Cell goalCell = row.createCell(cellId++);
					goalCell.setCellValue(fileData.getGoal());
					Cell purposeCell = row.createCell(cellId++);
					purposeCell.setCellValue(fileData.getPurpose());
					Cell prerequisiteCell = row.createCell(cellId++);
					prerequisiteCell.setCellValue(fileData.getPrerequisite());
					
					if(fileData.getTestCaseSteps()!=null)
					{	
						int x = 20;
						for (TestCaseStep step : fileData.getTestCaseSteps()) 
						{
							if (cellId < (maxStep * 2) - 2) {
								Cell stepCell = row.createCell(cellId++);
								stepCell.setCellValue(step.getStep());
								stepCell = row.createCell(cellId++);
								stepCell.setCellValue(step.getExpectedResult());
							} else {
								stepBuilder.append("\n" +(x)+"."+ step.getStep() + "\n");
								expBuilder.append("\n"  +(x++)+"."+ step.getExpectedResult() + "\n");
							}
						}

						if (stepBuilder != null && stepBuilder.length() > 0) {
							Cell stepCell = row.createCell(cellId++);
							stepCell.setCellValue(stepBuilder.toString());
							stepCell = row.createCell(cellId++);
							stepCell.setCellValue(expBuilder.toString());
						}
					}

				}
			}
			FileOutputStream out = new FileOutputStream(new File(path));
			workbook.write(out);
			if (workbook != null)
				workbook.close();
			if (out != null)
				out.close();
		}

	}

}
