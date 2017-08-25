package com.assignment.payslip.validation;

import com.assignment.payslip.data.InputData;
import com.assignment.payslip.util.AppConstants;

/**
 * First name validation rule implementation.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2017-08-23
 */

public class FirstNameValidationRule implements ValidationRule {

	public void validate(InputData data) throws IllegalArgumentException {
		try {
			String input = data.getFirstName();
			if (!input.trim().matches(AppConstants.FIRST_NAME_VALIDATION_RULE)) {
				throw new IllegalArgumentException("First name should be contain alphabetic only");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("First name should be contain alphabetic only");
		}
	}

}
