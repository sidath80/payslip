package com.assignment.payslip.validation;

import com.assignment.payslip.data.InputData;
import com.assignment.payslip.util.AppConstants;

public class LastNameValidationRule implements ValidationRule{
	
	public void validate(InputData data) throws IllegalArgumentException{
		try {
			String input = data.getLastName();
			if (!input.trim().matches(AppConstants.LAST_NAME_VALIDATION_RULE)) {
				throw new IllegalArgumentException("Last name should be contain alphabetic only");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Last name should be contain alphabetic only");
		}
	}

}
