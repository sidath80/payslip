package com.assignment.payslip.data;

/**
 * The InputData class is a POJO class which is hold input data.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2016-05-23
 */

public class InputData {

	private String firstName;
	private String lastName;
	private String annualSalary;
	private String superRate;
	private String startDate;

	public InputData(String firstName, String lastName, String annualSalary, String superRate, String startDate) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = annualSalary;
		this.superRate = superRate;
		this.startDate = startDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAnnualSalary() {
		return annualSalary;
	}

	public String getSuperRate() {
		return superRate;
	}

	public String getStartDate() {
		return startDate;
	}

}
