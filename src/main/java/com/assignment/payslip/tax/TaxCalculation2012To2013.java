package com.assignment.payslip.tax;

public class TaxCalculation2012To2013 implements TaxCaluculation{
	

	public float getTaxAmount(int salary) {
		
		float taxAmount=(getBaseAmount(salary)+getRatePerDollor(salary))/12;
		return taxAmount;
	}
	
	private int getBaseAmount(int salary){
		
		if(salary<=18200){
			return 0;
		}
		else if(salary <=37000){
			return 0;
		}
		else if (salary <=80000){
			return 3572;
		}
		else if(salary <=180000){
			return 17547;
		}
		else if(salary >180000){
			return 54547;
		}
		else{
			return 0;
		}
	}
	
	
	private float getRatePerDollor(int salary){
		
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
		else if(salary > 180000){
			return (salary-180000)*0.45f;
		}
		else{
			return 0.0f;
		}
	}
	
}
