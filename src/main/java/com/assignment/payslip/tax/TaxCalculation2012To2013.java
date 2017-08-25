package com.assignment.payslip.tax;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * TaxCalculation2012To2013 is the implementation of the tax for 2012 to 2013.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2017-08-23
 */

public class TaxCalculation2012To2013 implements TaxCalculation {
	
	private final static BigDecimal noOfMonths=new BigDecimal(12);
	
	private final static int salaryMinValueForBase=37000;
	private final static int salaryAvgValueForBase=80000;
	private final static int salaryMaxValueForBase=180000;
	
	private final static int salaryStage1ForRate=18200;
	private final static int salaryStage2ForRate=37000;
	private final static BigDecimal  salaryStage2Rate= new BigDecimal(0.19);
	private final static int salaryStage3ForRate=80000;
	private final static BigDecimal  salaryStage3Rate= new BigDecimal(0.325);
	private final static int salaryStage4ForRate=180000;
	private final static BigDecimal  salaryStage4Rate= new BigDecimal(0.37);
	private final static BigDecimal  salaryStage5Rate= new BigDecimal(0.45);

	public BigDecimal getTaxAmount(int salary) {

		BigDecimal baseSalary=  new BigDecimal(getBaseAmount(salary));
		BigDecimal taxRate = getRatePerDollar(salary);
		BigDecimal taxAmount=baseSalary.add(taxRate);
		taxAmount=taxAmount.divide(noOfMonths, BigDecimal.ROUND_HALF_UP);
		taxAmount = taxAmount.setScale(0, RoundingMode.HALF_UP);
		return taxAmount;
		
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

	private BigDecimal getRatePerDollar(int salary) {
		
		BigDecimal rate=new BigDecimal(0);

		if (salary <= salaryStage1ForRate) {
			return rate;
		} else if (salary <= salaryStage2ForRate) {
			rate=new BigDecimal(salary - 18200).multiply(salaryStage2Rate);
			return rate;
		} else if (salary <= salaryStage3ForRate) {
			rate=new BigDecimal(salary - 37000).multiply(salaryStage3Rate);
			return rate;
		} else if (salary <= salaryStage4ForRate) {
			rate=new BigDecimal(salary - 80000).multiply(salaryStage4Rate);
			return rate;
		} else { // (salary > 180000)
			rate=new BigDecimal(salary - 180000).multiply(salaryStage5Rate);
			return rate;
		}
	}

}
