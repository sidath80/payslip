package com.assignment.payslip.tax;

import java.math.BigDecimal;

public interface TaxCalculation {
	
	BigDecimal getTaxAmount(int salary);
}
