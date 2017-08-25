package com.assignment.payslip.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.assignment.payslip.data.InputData;

public class ValidationManager {

	private static ValidationManager validationManager;

	private ValidationManager() {

	}

	public static ValidationManager getInstance() {

		if (validationManager == null) {
			validationManager = new ValidationManager();
		}

		return validationManager;
	}

	public List<Map<Integer, String>> validate(List<InputData> dataList) {

		List<ValidationRule> rules = getValidationRules();
		List<Map<Integer, String>> errorList = new ArrayList<Map<Integer, String>>();
		Integer recordCount = 1;
		for (InputData data : dataList) {
			for (ValidationRule rule : rules) {
				try {
					rule.validate(data);
				} catch (IllegalArgumentException e) {
					Map<Integer, String> errorMap = new HashMap<Integer, String>();
					errorMap.put(recordCount, e.getMessage());
					errorList.add(errorMap);
				}
			}
			recordCount = recordCount + 1;
		}
		printErrorMessages(errorList);
		return errorList;
	}

	private List<ValidationRule> getValidationRules() {
		List<ValidationRule> rules = new ArrayList<ValidationRule>();
		rules.add(new FirstNameValidationRule());
		rules.add(new LastNameValidationRule());
		rules.add(new AnnualSalaryValidationRule());
		rules.add(new SupperRateValidationRule());
		rules.add(new PaymentStartDateValidationRule());
		return rules;
	}

	private void printErrorMessages(List<Map<Integer, String>> errorList) {

		for (Map<Integer, String> errorMap : errorList) {
			for (Map.Entry<Integer, String> entry : errorMap.entrySet()) {
				System.out.println("Validation result found in Row no " + entry.getKey() + " : " + entry.getValue());
			}
		}
	}

}
