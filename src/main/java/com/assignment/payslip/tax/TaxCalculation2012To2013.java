package com.assignment.payslip.tax;

/**
 *  TaxCalculation2012To2013 is the implementation of the tax for 2012 to 2013.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2016-05-23
 */


public class TaxCalculation2012To2013 implements TaxCalculation {
	

	public float getTaxAmount(int salary) {
		
		return (getBaseAmount(salary)+ getRatePerDollar(salary))/12;
	}
	
	private int getBaseAmount(int salary){
		
		if(salary <=37000){   
			return 0;
		}
		else if (salary <=80000){
			return 3572;
		}
		else if(salary <=180000){
			return 17547;
		}
		else{                  //  (salary >180000)
			return 54547;
		}
	}
	
	private float getRatePerDollar(int salary){
		
		if(salary<=18200){
			return 0.0f;
		}
		else if(salary <=37000){
			return (salary-18200)*0.19f;
		}
		else if (salary <=80000){
			return (salary-37000)*0.325f;
		}
		else if(salary <=180000){
			return (salary-80000)*0.37f;
		}
		else {                 //(salary > 180000)
			return (salary-180000)*0.45f;
		}
	}
	
}
