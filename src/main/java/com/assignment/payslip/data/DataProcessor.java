package com.assignment.payslip.data;

import java.util.List;

import com.assignment.payslip.domain.EmployeeSalaryDetails;

public interface DataProcessor {
	public List<InputData> read();
	public void write(List<EmployeeSalaryDetails> dataList);
}
