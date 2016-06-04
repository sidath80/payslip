package com.assignment.payslip.validation;

import com.assignment.payslip.data.InputData;

/**
 * Annual salary validation rule implementation.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2016-05-23
 */

public class AnnualSalaryValidationRule implements ValidationRule {

	public void validate(InputData data) throws IllegalArgumentException {
		try {
			int salary = Integer.parseInt(data.getAnnualSalary());
			if (salary <= 0) {
				throw new IllegalArgumentException("Annual Salary should be an positive integer value");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Annual Salary should be an integer value");
		}
	}

}
