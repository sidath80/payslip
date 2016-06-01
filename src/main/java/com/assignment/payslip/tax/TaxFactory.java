package com.assignment.payslip.tax;

import java.util.Properties;
import com.assignment.payslip.util.AppConstants;

/**
* The TaxFactory is a singleton class which is the factory of the different types Tax implementation.
*
* @author  Sidath Dassanayake
* @version 0.0.1
* @since   2016-05-08
*/

public class TaxFactory {
	
	private static TaxFactory taxFactory;
	private  Properties properties;
	
	private TaxFactory(Properties properties) {
		this.properties=properties;
	}

	public static TaxFactory getInstance(Properties properties) {

		if (taxFactory == null) {
			taxFactory = new TaxFactory(properties);
		}

		return taxFactory;
	}
	public TaxCalculation getTaxImplementation() {
		
		if(properties.getProperty(AppConstants.FINANCIAL_YEAR) != null && properties.getProperty(AppConstants.FINANCIAL_YEAR).
				equals(AppConstants.FINANCIAL_YEAR_2012_To_2013)){
			return new TaxCalculation2012To2013();
		}
		else
		{
			throw new RuntimeException("No Implementation is  found for this configuration");
		}
		
	}
}
