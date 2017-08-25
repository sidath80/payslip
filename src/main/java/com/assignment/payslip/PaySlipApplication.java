package com.assignment.payslip;

/**
 * The Application Class is the main class of the application
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2017-08-23
 */

class PaySlipApplication {

	public static void main(String[] args) {
		PaySlipManager.getInstance().generatePaySlipData();
	}
}
