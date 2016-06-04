package com.assignment.payslip.validation;

/**
 *  Payment start date validation rule implementation.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2016-05-23
 */

import com.assignment.payslip.data.InputData;

public class PaymentStartDateValidationRule implements ValidationRule {

	public void validate(InputData data) throws IllegalArgumentException {
		try {
			String input = data.getStartDate();
			if (input.length() <= 0) {
				throw new IllegalArgumentException("Payment start date should be an String value");
			}

		} catch (Exception e) {
			throw new IllegalArgumentException("Payment start date should be an String value");
		}
	}

}
