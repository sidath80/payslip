package com.assignment.payslip.tax;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Properties;

import com.assignment.payslip.util.AppConstants;

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
		
	private  int salaryStage1=18200;
	private  int salaryStage2=37000;
	private  int salaryStage3=80000;
	private  int salaryStage4=180000;
	
	private  int taxBaseAmount0=0;
	private  int taxBaseAmount1=3572;
	private  int taxBaseAmount2=17547;
	private  int taxBaseAmount3=54547;
	
	private  BigDecimal  salaryStage2Rate= new BigDecimal(0);
	private  BigDecimal  salaryStage3Rate= new BigDecimal(0);
	private  BigDecimal  salaryStage4Rate= new BigDecimal(0);
	private  BigDecimal  salaryStage5Rate= new BigDecimal(0);
	
	public TaxCalculation2012To2013(Properties properties){
		
		 this.salaryStage1=Integer.parseInt(properties.getProperty(AppConstants.SAL_STG1));
		 this.salaryStage2=Integer.parseInt(properties.getProperty(AppConstants.SAL_STG2));
		 this.salaryStage3=Integer.parseInt(properties.getProperty(AppConstants.SAL_STG3));
		 this.salaryStage4=Integer.parseInt(properties.getProperty(AppConstants.SAL_STG4));
		 
		 this.taxBaseAmount0=Integer.parseInt(properties.getProperty(AppConstants.TAX_BASE_0));
		 this.taxBaseAmount1=Integer.parseInt(properties.getProperty(AppConstants.TAX_BASE_1));
		 this.taxBaseAmount2=Integer.parseInt(properties.getProperty(AppConstants.TAX_BASE_2));
		 this.taxBaseAmount3=Integer.parseInt(properties.getProperty(AppConstants.TAX_BASE_3));
		 
		 this.salaryStage2Rate=new BigDecimal(Float.parseFloat(properties.getProperty(AppConstants.SAL_STG2_RATE)));
		 this.salaryStage3Rate=new BigDecimal(Float.parseFloat(properties.getProperty(AppConstants.SAL_STG3_RATE)));
		 this.salaryStage4Rate=new BigDecimal(Float.parseFloat(properties.getProperty(AppConstants.SAL_STG4_RATE)));
		 this.salaryStage5Rate=new BigDecimal(Float.parseFloat(properties.getProperty(AppConstants.SAL_STG5_RATE)));
		 
	}

	public BigDecimal getTaxAmount(int salary) {

		BigDecimal baseSalary=  new BigDecimal(getTaxBaseAmount(salary));
		BigDecimal taxRate = getRatePerDollar(salary);
		BigDecimal taxAmount=baseSalary.add(taxRate);
		taxAmount=taxAmount.divide(noOfMonths, BigDecimal.ROUND_HALF_UP);
		taxAmount = taxAmount.setScale(0, RoundingMode.HALF_UP);
		return taxAmount;
		
	}

	private int getTaxBaseAmount(int salary) {

		if (salary <= salaryStage2) {
			return taxBaseAmount0;
		} else if (salary <= salaryStage3) {
			return taxBaseAmount1;
		} else if (salary <= salaryStage4) {
			return taxBaseAmount2;
		} else { // (salary >180000)
			return taxBaseAmount3;
		}
	}

	private BigDecimal getRatePerDollar(int salary) {
		
		BigDecimal rate=new BigDecimal(0);

		if (salary <= salaryStage1) {
			return rate;
		} else if (salary <= salaryStage2) {
			rate=new BigDecimal(salary - salaryStage1).multiply(salaryStage2Rate);
			return rate;
		} else if (salary <= salaryStage3) {
			rate=new BigDecimal(salary - salaryStage2).multiply(salaryStage3Rate);
			return rate;
		} else if (salary <= salaryStage4) {
			rate=new BigDecimal(salary - salaryStage3).multiply(salaryStage4Rate);
			return rate;
		} else { // (salary > 180000)
			rate=new BigDecimal(salary - salaryStage4).multiply(salaryStage5Rate);
			return rate;
		}
	}

}
