package com.assignment.payslip.domain;

public abstract class  EmployeeSalaryDetails extends Employee{
	
	private float superRate;
	private String paymentStartDate;
	
	public float getSuperRate() {
		return superRate;
	}
	public void setSuperRate(float superRate) {
		this.superRate = superRate;
	}
	public String getPaymentStartDate() {
		return paymentStartDate;
	}
	public void setPaymentStartDate(String paymentStartDate) {
		this.paymentStartDate = paymentStartDate;
	}
	
	public abstract String getPayPeriod();
	
	public abstract int calculateGrossIncome();
	
	public abstract int calculateIncomeTax();
	
	public abstract int calculateNetIncome();
	
	public abstract int calculateSupper();

}
