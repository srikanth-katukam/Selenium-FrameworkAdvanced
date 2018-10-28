package com.salesforce.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationDataProvider {

	Properties pro;
	//Constructor to load config.properties file
	public ConfigurationDataProvider()
	{
		File src =new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}	
	//Get the application URL from config.properties file
	public String applicationURL()
	{
		String url = pro.getProperty("url");
		return url;
	}
	//Get the browser Path from config.properties file
	public String chromePath()
	{
		String ChromePath = pro.getProperty("chromePath");
		return ChromePath;
	}
    public String firefoxPath()
    {
        String firefoxPath = pro.getProperty("firefoxpath");
        return firefoxPath;
    }
	//Get the browser Path from config.properties file
	public String iePath()
	{
		String IEPath = pro.getProperty("iePath");
		return IEPath;
	}
}
	
