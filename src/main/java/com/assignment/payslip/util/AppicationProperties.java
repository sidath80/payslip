package com.assignment.payslip.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

/**
* The AppicationProperties is a utility class.
* This will load  all properties from the application.properties file.
*
* @author  Sidath Dassanayake
* @version 0.0.1
* @since   2016-05-23
*/


public class AppicationProperties {
	
	private static AppicationProperties appicationProperties;

	private AppicationProperties() {

	}

	public static AppicationProperties getinstance() {

		if (appicationProperties == null) {
			appicationProperties = new AppicationProperties();
		}

		return appicationProperties;
	}
	
	public Properties load(){
		
		Properties prop = new Properties();
		InputStream input = null;
		try {
			File propertyFile = new File(this.getClass().getResource("/application.properties").toURI());
			input = new FileInputStream(propertyFile);
			prop.load(input);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
}
