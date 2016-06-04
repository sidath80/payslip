package com.assignment.payslip.tax;

/**
 * TaxCalculation2012To2013 is the implementation of the tax for 2012 to 2013.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2016-05-23
 */

public class TaxCalculation2012To2013 implements TaxCalculation {
	
	private final static int noOfMonths=12;
	
	private final static int salaryMinValueForBase=37000;
	private final static int salaryAvgValueForBase=80000;
	private final static int salaryMaxValueForBase=180000;
	
	private final static int salaryStage1ForRate=18200;
	private final static int salaryStage2ForRate=37000;
	private final static int salaryStage3ForRate=80000;
	private final static int salaryStage4ForRate=180000;


	public float getTaxAmount(int salary) {

		return (getBaseAmount(salary) + getRatePerDollar(salary)) / noOfMonths;
	}

	private int getBaseAmount(int salary) {

		if (salary <= salaryMinValueForBase) {
			return 0;
		} else if (salary <= salaryAvgValueForBase) {
			return 3572;
		} else if (salary <= salaryMaxValueForBase) {
			return 17547;
		} else { // (salary >180000)
			return 54547;
		}
	}

	private float getRatePerDollar(int salary) {

		if (salary <= salaryStage1ForRate) {
			return 0.0f;
		} else if (salary <= salaryStage2ForRate) {
			return (salary - 18200) * 0.19f;
		} else if (salary <= salaryStage3ForRate) {
			return (salary - 37000) * 0.325f;
		} else if (salary <= salaryStage4ForRate) {
			return (salary - 80000) * 0.37f;
		} else { // (salary > 180000)
			return (salary - 180000) * 0.45f;
		}
	}

}
