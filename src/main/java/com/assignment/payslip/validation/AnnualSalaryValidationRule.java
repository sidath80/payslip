package com.assignment.payslip.validation;

import com.assignment.payslip.data.InputData;

public class AnnualSalaryValidationRule  implements ValidationRule{
	
	public void validate(InputData data) throws IllegalArgumentException{
		try {
			int salary=Integer.parseInt(data.getAnnualSalary());
			if(salary <=0){
				throw new IllegalArgumentException("Anual Salary should be an positive integer value");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Anual Salary should be an integer value");
		}
	}

}
