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
import com.assignment.payslip.util.AppicationProperties;
import com.assignment.payslip.validation.ValidationManager;

/**
 * The PaySlipManager class is validate,read and write employee data
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
		properties = AppicationProperties.getinstance().load();
		salaries=new ArrayList<EmployeeSalaryDetails>();
	}

	public static PaySlipManager getinstance() {

		if (paySlipManager == null) {
			paySlipManager = new PaySlipManager();
		}
		return paySlipManager;
	}

	public void generatePaySlipData(){
		
		List<InputData> dataList=read();
		List<Map<Integer, String>> errorList=validate(dataList);
		if(errorList.size()==0){
			for (InputData data : dataList) {
				addToEmployee(data);
				write(salaries);
			}
		}
	}
	
	private List<Map<Integer, String>> validate(List<InputData> dataList){
		return ValidationManager.getinstance().validate(dataList);
	}
	
	private List<InputData> read(){
	    return DataProcessorFactory.getinstance().getDataProcessor(properties).read();	    
	}
	
	private void write(List<EmployeeSalaryDetails> salaries) {
		 DataProcessorFactory.getinstance().getDataProcessor(properties).write(salaries);
	}
	
	private void addToEmployee(InputData data) {
		
		PermanentEmployeePaySlip permanantEmployeePaySlip =
			new PermanentEmployeePaySlip();
		permanantEmployeePaySlip.setTaxCaluculation(TaxFactory.getInstance(properties).
			getTaxImplementation());
		permanantEmployeePaySlip.setFirstName(data.getFirstName());
		permanantEmployeePaySlip.setLastName(data.getLastName());
		permanantEmployeePaySlip.setAnnualSalary(Integer.parseInt(data.getAnnualSalary()));
		String supperRate=data.getSuperRate();
		supperRate=supperRate.replace("%","");
		permanantEmployeePaySlip.setSuperRate(Integer.parseInt(supperRate)*.01f);
		permanantEmployeePaySlip.setPaymentStartDate(data.getStartDate());
		salaries.add(permanantEmployeePaySlip);
	}
	
}
