package com.assignment.payslip.validation;

import com.assignment.payslip.data.InputData;

public class PaymentStartDateValidationRule implements ValidationRule{
	
	public void validate(InputData data) throws IllegalArgumentException{
		try {
			String input = data.getStartDate();
			if(input.length()<=0){
				throw new IllegalArgumentException("Payment start date should be an String value");
			}
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Payment start date should be an String value");
		}
	}

}
