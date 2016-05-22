package com.assignment.payslip;

/**
 * The Application Class will take a file type(CSV or other supported file
 * formats) from the command line. The Default will be CSV.
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2016-05-08
 */

public class PaySlipApplication {

	public static void main(String[] args) {
		PaySlipManager.getinstance().generatePaySlipData();
	}
}
