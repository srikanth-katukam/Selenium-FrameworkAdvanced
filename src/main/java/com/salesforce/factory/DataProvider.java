package com.salesforce.factory;

import com.salesforce.dataprovider.ConfigurationDataProvider;
import com.salesforce.dataprovider.ExcelDataProvider;


public class DataProvider {
	
	public static ConfigurationDataProvider getConfig()
	{
		ConfigurationDataProvider config = new ConfigurationDataProvider();
		return config;
	}
	
	public static ExcelDataProvider getExcel()
	{
		ExcelDataProvider config = new ExcelDataProvider();
		return config;
	}
}
