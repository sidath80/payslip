package com.assignment.payslip.validation;

import com.assignment.payslip.data.InputData;
import com.assignment.payslip.util.AppConstants;

public class SupperRateValidationRule implements ValidationRule{
	
	public void validate(InputData data) throws IllegalArgumentException{
		try {
			String input = data.getSuperRate();
			if (!input.trim().matches(AppConstants.SUPER_RATE_VALIDATION_RULE.trim())) {
				throw new IllegalArgumentException("Supper Rate should be an integer value with $");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Supper Rate should be an integer value with $");
		}
	}

}
