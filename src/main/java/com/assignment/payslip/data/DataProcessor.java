package com.assignment.payslip.data;

import java.util.List;
import com.assignment.payslip.domain.EmployeeSalaryDetails;

/**
 * The DataProcessor interface
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2017-08-23
 */

public interface DataProcessor {
	List<InputData> read();

	void write(List<EmployeeSalaryDetails> dataList);
}
