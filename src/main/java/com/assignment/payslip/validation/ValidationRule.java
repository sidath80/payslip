package com.assignment.payslip.validation;

import com.assignment.payslip.data.InputData;

/**
 * The ValidationRule is an interface.
 *
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2016-05-23
 */

interface ValidationRule {
	void validate(InputData data) throws IllegalArgumentException;
}
