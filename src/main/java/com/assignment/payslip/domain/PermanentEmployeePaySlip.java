package com.assignment.payslip.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.assignment.payslip.tax.TaxCalculation;

/**
 * Permanent employee salary slip details.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2017-08-23
 */

public class PermanentEmployeePaySlip extends EmployeeSalaryDetails {

	private int annualSalary;
	private int grossIncome;
	private int incomeTax;
	private int netIncome;
	private TaxCalculation taxCalculation;
	
	private final static BigDecimal noOfMonths=new BigDecimal(12);

	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}

	public void setTaxCalculation(TaxCalculation taxCalculation) {
		this.taxCalculation = taxCalculation;
	}

	@Override
	public String getPayPeriod() {
		return this.getPaymentStartDate();
	}

	@Override
	public int calculateGrossIncome() {

		//float gIncome = (float) this.annualSalary / 12;
		BigDecimal grossIncome=  new BigDecimal(this.annualSalary);
		grossIncome=grossIncome.divide(noOfMonths, BigDecimal.ROUND_HALF_UP);
		grossIncome = grossIncome.setScale(0, RoundingMode.HALF_UP);
		this.grossIncome = grossIncome.intValue();
		
		return this.grossIncome;
	}

	@Override
	public int calculateIncomeTax() {
		this.incomeTax = taxCalculation.getTaxAmount(this.annualSalary).intValue();
		return this.incomeTax;
	}

	@Override
	public int calculateNetIncome() {
		this.netIncome = (this.grossIncome - this.incomeTax);
		return this.netIncome;
	}

	@Override
	public int calculateSupper() {
		return Math.round(this.grossIncome * this.getSuperRate());
	}

}
