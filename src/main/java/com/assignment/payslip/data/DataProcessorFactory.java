package com.assignment.payslip.data;

import java.util.Properties;
import com.assignment.payslip.util.AppConstants;

/**
 * The DataProcessorFactory class is create DataProcessors according to the
 * configuration.
 * 
 * 
 * @author Sidath Dassanayake
 * @version 0.0.1
 * @since 2016-05-23
 */

public class DataProcessorFactory {

	private static DataProcessorFactory dataProcessorFactory;

	private DataProcessorFactory() {

	}

	public static DataProcessorFactory getInstance() {

		if (dataProcessorFactory == null) {
			dataProcessorFactory = new DataProcessorFactory();
		}

		return dataProcessorFactory;
	}

	public DataProcessor getDataProcessor(Properties properties) {

		if (properties.getProperty(AppConstants.SALARY_DATA_FILE_TYPE).equalsIgnoreCase(AppConstants.DEFAULT_COMMAND)) {
			return new DefaultCsvDataProcessor(properties);
		}
		return new DefaultCsvDataProcessor(properties);

	}
}
