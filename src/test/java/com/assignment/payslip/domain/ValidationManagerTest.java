package com.assignment.payslip.domain;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import com.assignment.payslip.data.InputData;
import com.assignment.payslip.validation.ValidationManager;

public class ValidationManagerTest {
	
	// All data will pass all the validation rules
	@Test
	public void dataValidationErrorsShouldBeZero() {

		InputData data1 = new InputData("fname", "lname", "10000", "8%", "01 March – 31 March");
		InputData data2 = new InputData("abcdef", "xcbgdf", "900000", "5%", "01 March – 31 March");
		InputData data3 = new InputData("fname", "jkjkjkk", "555555", "45%", "01 March – 31 March");
		List<InputData> dataList = new ArrayList<InputData>();
		dataList.add(data1);
		dataList.add(data2);
		dataList.add(data3);

		List<Map<Integer, String>> errorList=ValidationManager.getinstance().validate(dataList);
		assertEquals(errorList.size(), 0);

	}

	// First name should not contains spaces,numbers and special characters
	@Test
	public void dataValidationErrorsWithFirstName() {

		InputData data1 = new InputData("fname cc", "lname", "10000", "8%", "01 March – 31 March");
		InputData data2 = new InputData("1212eeee", "xcbgdf", "900000", "5%", "01 March – 31 March");
		InputData data3 = new InputData("qwqw$$$", "jkjkjkk", "555555", "45%", "01 March – 31 March");
		List<InputData> dataList = new ArrayList<InputData>();
		dataList.add(data1);
		dataList.add(data2);
		dataList.add(data3);

		List<Map<Integer, String>> errorList=ValidationManager.getinstance().validate(dataList);
		assertEquals(errorList.size(), 3);

	}

	// Last name should not contains spaces,numbers and special characters
	@Test
	public void dataValidationErrorsWithLastName() {

		InputData data1 = new InputData("fnamecc", "l name", "10000", "8%", "01 March – 31 March");
		InputData data2 = new InputData("abcdef", "2323df", "900000", "5%", "01 March – 31 March");
		InputData data3 = new InputData("fname", "jkjk$$$", "555555", "45%", "01 March – 31 March");
		List<InputData> dataList = new ArrayList<InputData>();
		dataList.add(data1);
		dataList.add(data2);
		dataList.add(data3);
		
		List<Map<Integer, String>> errorList=ValidationManager.getinstance().validate(dataList);
		assertEquals(errorList.size(), 3);

	}

	// Salary should contains only numbers
	@Test
	public void dataValidationErrorsWithSalary() {

		InputData data1 = new InputData("fnamecc", "lname", "cvcvc", "8%", "01 March – 31 March");
		InputData data2 = new InputData("abcdef", "vbvvbv", "9000.00", "5%", "01 March – 31 March");
		InputData data3 = new InputData("fname", "xcxcxccx", "$$$", "45%", "01 March – 31 March");
		List<InputData> dataList = new ArrayList<InputData>();
		dataList.add(data1);
		dataList.add(data2);
		dataList.add(data3);
		
		List<Map<Integer, String>> errorList=ValidationManager.getinstance().validate(dataList);
		assertEquals(errorList.size(), 3);

	}
	
	// super rate(0% - 50% inclusive)
	@Test
	public void dataValidationErrorsWithSuper() {

		InputData data1 = new InputData("fnamecc", "lname", "100000", ".8%", "01 March – 31 March");
		InputData data2 = new InputData("abcdef", "vbvvbv", "50000", "g%", "01 March – 31 March");
		InputData data3 = new InputData("fname", "xcxcxccx", "30000", "80%", "01 March – 31 March");
		List<InputData> dataList = new ArrayList<InputData>();
		dataList.add(data1);
		dataList.add(data2);
		dataList.add(data3);
		
		List<Map<Integer, String>> errorList=ValidationManager.getinstance().validate(dataList);
		assertEquals(errorList.size(), 3);

	}

}
