package com.assignment.payslip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import com.assignment.payslip.data.DataProcessorFactory;
import com.assignment.payslip.data.InputData;
import com.assignment.payslip.domain.EmployeeSalaryDetails;
import com.assignment.payslip.domain.PermanentEmployeePaySlip;
import com.assignment.payslip.tax.TaxFactory;
import com.assignment.payslip.util.ApplicationProperties;
import com.assignment.payslip.validation.ValidationManager;

/**
 * The PaySlipManager class is generate pay slip information.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2016-05-23
 */

public class PaySlipManager {

	private Properties properties;
	private List<EmployeeSalaryDetails> salaries;
	private static PaySlipManager paySlipManager;

	private PaySlipManager() {
		properties = ApplicationProperties.getInstance().load();
		salaries = new ArrayList<EmployeeSalaryDetails>();
	}

	public static PaySlipManager getInstance() {

		if (paySlipManager == null) {
			paySlipManager = new PaySlipManager();
		}
		return paySlipManager;
	}

	public void generatePaySlipData() {

		List<InputData> dataList = read();
		List<Map<Integer, String>> errorList = validate(dataList);
		if (errorList.size() == 0) {
			for (InputData data : dataList) {
				addToEmployee(data);
				write(salaries);
			}
		}
		System.out.println("Pay slip information @ " + properties.getProperty("payslip.file.path"));
	}

	private List<Map<Integer, String>> validate(List<InputData> dataList) {
		return ValidationManager.getInstance().validate(dataList);
	}

	private List<InputData> read() {
		return DataProcessorFactory.getInstance().getDataProcessor(properties).read();
	}

	private void write(List<EmployeeSalaryDetails> salaries) {
		DataProcessorFactory.getInstance().getDataProcessor(properties).write(salaries);
	}

	private void addToEmployee(InputData data) {

		PermanentEmployeePaySlip permanentEmployeePaySlip = new PermanentEmployeePaySlip();
		permanentEmployeePaySlip.setTaxCalculation(TaxFactory.getInstance(properties).getTaxImplementation());
		permanentEmployeePaySlip.setFirstName(data.getFirstName());
		permanentEmployeePaySlip.setLastName(data.getLastName());
		permanentEmployeePaySlip.setAnnualSalary(Integer.parseInt(data.getAnnualSalary()));
		String supperRate = data.getSuperRate();
		supperRate = supperRate.replace("%", "");
		permanentEmployeePaySlip.setSuperRate(Integer.parseInt(supperRate) * .01f);
		permanentEmployeePaySlip.setPaymentStartDate(data.getStartDate());
		salaries.add(permanentEmployeePaySlip);
	}

}
