package com.assignment.payslip.data;

public class InputData {
	
	String firstName;
	String lastName;
	String annualSalary; 
	String superRate;
	String startDate;
	
	public InputData(String firstName,String lastName,
			String annualSalary,String superRate,String startDate){
		
		this.firstName=firstName;
		this.lastName=lastName;
		this.annualSalary=annualSalary;
		this.superRate=superRate;
		this.startDate=startDate;
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
