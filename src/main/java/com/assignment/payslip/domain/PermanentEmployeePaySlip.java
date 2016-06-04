package com.assignment.payslip.domain;

import com.assignment.payslip.tax.TaxCalculation;

/**
 * Permanent employee salary slip details.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2016-05-23
 */

public class PermanentEmployeePaySlip extends EmployeeSalaryDetails {

	private int annualSalary;
	private int grossIncome;
	private int incomeTax;
	private int netIncome;
	private TaxCalculation taxCalculation;

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

		float gIncome = (float) this.annualSalary / 12;
		this.grossIncome = Math.round(gIncome);
		return this.grossIncome;
	}

	@Override
	public int calculateIncomeTax() {
		this.incomeTax = Math.round(taxCalculation.getTaxAmount(this.annualSalary));
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
