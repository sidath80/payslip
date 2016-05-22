package com.assignment.payslip.data;

import java.util.Properties;
import com.assignment.payslip.util.AppConstants;

/**
* The FileProcessorFactory is a singleton class which is the factory of the different types File Processors.
*
* @author  Sidath Dassanayake
* @version 0.0.1
* @since   2016-05-08
*/

public class DataProcessorFactory {
	
	private static DataProcessorFactory dataProcessorFactory;
	
	private DataProcessorFactory(){
		
	}
	
	public static DataProcessorFactory getinstance() {

		if (dataProcessorFactory == null) {
			dataProcessorFactory = new DataProcessorFactory();
		}

		return dataProcessorFactory;
	}
	public DataProcessor getDataProcessor(Properties properties) {
	
	      if(properties.getProperty(AppConstants.SALARY_DATA_FILE_TYPE).equalsIgnoreCase(AppConstants.DEFAULT_COMMAND)){
	         return new DefaultCsvDataProcessor(properties);
	      }
	      return new DefaultCsvDataProcessor(properties);
		
	}
}
