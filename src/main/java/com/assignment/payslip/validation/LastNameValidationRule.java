package com.assignment.payslip.validation;

import com.assignment.payslip.data.InputData;
import com.assignment.payslip.util.AppConstants;

/**
 * Last Name validation rule implementation.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2017-08-23
 */

public class LastNameValidationRule implements ValidationRule {

	public void validate(InputData data) throws IllegalArgumentException {
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
