package com.assignment.payslip.util;

import java.math.BigDecimal;

/**
 *  Application constants.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2017-08-23
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
	
	
	public  static final String SAL_STG1="salaryStage1";
	public  static final String SAL_STG2="salaryStage2";
	public  static final String SAL_STG3="salaryStage3";
	public  static final String SAL_STG4="salaryStage4";
	
	public  static final String TAX_BASE_0="taxBaseAmount0";
	public  static final String TAX_BASE_1="taxBaseAmount1";
	public  static final String TAX_BASE_2="taxBaseAmount2";
	public  static final String TAX_BASE_3="taxBaseAmount3";
	
	public  static final String  SAL_STG1_RATE="salaryStage1Rate";
	public  static final String  SAL_STG2_RATE="salaryStage2Rate";
	public  static final String  SAL_STG3_RATE="salaryStage3Rate";
	public  static final String  SAL_STG4_RATE="salaryStage4Rate";
	
}
