package com.assignment.payslip.domain;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;

import com.assignment.payslip.PaySlipManager;
import com.assignment.payslip.data.InputData;


public class PaySlipManagerIntegrationTest {
	
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	private void createDataFile(List<InputData> dataList) {
		File csvJobFile = null;
		FileWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

		try {
			csvJobFile = new File("src/main/resources/salarydata.csv");
			fileWriter = new FileWriter(csvJobFile);
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
			for (InputData data : dataList) {
				List<String> row = new ArrayList<String>();
				row.add(data.getFirstName());
				row.add(data.getLastName());
				row.add(data.getAnnualSalary());
				row.add(data.getSuperRate());
				row.add(data.getStartDate());
				csvFilePrinter.printRecord(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
				csvFilePrinter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void intergrationTest() {
		
		System.out.println("---------------Test Start------------------");
		
		InputData data1 = new InputData("fname", "lname", "10000", "8%", "01 March – 31 March");
		InputData data2 = new InputData("abcdef", "xcbgdf", "900000", "5%", "01 March – 31 March");
		InputData data3 = new InputData("fname", "jkjkjkk", "555555", "45%", "01 March – 31 March");
		List<InputData> dataList = new ArrayList<InputData>();
		dataList.add(data1);
		dataList.add(data2);
		dataList.add(data3);
		createDataFile(dataList);
		PaySlipManager.getInstance().generatePaySlipData();
		try {
			File file = new File("src/main/resources/paySlip.csv");
			assertTrue("This will succeed.", true);
		}
		catch(Exception e){
			assertFalse("This will fail!", false);
		}
		System.out.println("---------------End-------------------------");
	}


}
