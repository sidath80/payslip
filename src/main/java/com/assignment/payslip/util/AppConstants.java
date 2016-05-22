package com.assignment.payslip.util;

/**
 *  Application constants.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2016-05-23
 */


public final class AppConstants {

	private AppConstants() {
		// restrict instantiation
	}
	
	public static final String DEFAULT_COMMAND="CSV";
	public static final String SALARY_DATA_FILE_TYPE="salary.data.file.type";
	public static final String SALARY_DATA_FILE_PATH="salary.data.file.path";
	public static final String PAYSLIP_FILE_PATH="payslip.file.path";
	public static final String FINANCIAL_YEAR="financial.year";
	
	public static final String FIRST_NAME_VALIDATION_RULE="[a-zA-Z]*";
	public static final String LAST_NAME_VALIDATION_RULE="[a-zA-Z]*";
	public static final String SUPER_RATE_VALIDATION_RULE="^(0|[1-9]|[1-4][0-9]|50)[%]$";
	
	public static final String FINANCIAL_YEAR_2012_To_2013="FINANCIAL_YEAR_2012_To_2013";
	
}
