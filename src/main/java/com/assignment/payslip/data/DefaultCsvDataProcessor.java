package com.assignment.payslip.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import com.assignment.payslip.domain.EmployeeSalaryDetails;
import com.assignment.payslip.util.AppConstants;

/**
 * The DefaultCsvDataProcessor class is the implementation of the DataProcessor.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2016-05-23
 */

public class DefaultCsvDataProcessor implements DataProcessor {

	private static final String NEW_LINE_SEPARATOR = "\n";

	private Properties properties;

	DefaultCsvDataProcessor(Properties properties) {
		this.properties = properties;
	}

	public List<InputData> read() {

		FileReader csvFileReader = null;
		CSVParser csvFileParser = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT;
		List<InputData> dataList = new ArrayList<InputData>();

		try {
			File csvJobFile = new File(properties.getProperty(AppConstants.SALARY_DATA_FILE_PATH));
			csvFileReader = new FileReader(csvJobFile);
			csvFileParser = new CSVParser(csvFileReader, csvFileFormat);
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			for (CSVRecord record : csvRecords) {
				InputData inputData = new InputData(record.get(0), record.get(1), record.get(2), record.get(3),
						record.get(4));
				dataList.add(inputData);
			}
		} catch (FileNotFoundException fe) {
			System.out.println("There is no job file to start the application.");
			throw new RuntimeException("There is no job file to start the application.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				csvFileReader.close();
				csvFileParser.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
		}
		return dataList;
	}

	public void write(List<EmployeeSalaryDetails> dataList) {

		File csvJobFile = null;
		FileWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

		try {
			csvJobFile = new File(properties.getProperty(AppConstants.PAYSLIP_FILE_PATH));
			fileWriter = new FileWriter(csvJobFile);
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
			for (EmployeeSalaryDetails data : dataList) {
				List<String> row = new ArrayList<String>();
				row.add(data.getFirstName() + " " + data.getLastName());
				row.add(data.getPayPeriod());
				row.add(data.calculateGrossIncome() + "");
				row.add(data.calculateIncomeTax() + "");
				row.add(data.calculateNetIncome() + "");
				row.add(data.calculateSupper() + "");
				csvFilePrinter.printRecord(row);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
			
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
				csvFilePrinter.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
		}
	}

}
