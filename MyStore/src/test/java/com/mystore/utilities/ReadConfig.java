package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties properties;
	
	String path = "C:\\Users\\acer\\AutomationFramework\\MyStoreV1\\Configuration\\config.properties";
	
	public ReadConfig()
	{
		try
		{
			properties = new Properties();
		
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl()
	{
		String value = properties.getProperty("baseUrl");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file");
	}
	
	public String getBrowser()
	{
		String value = properties.getProperty("browser");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser not specified in config file");
	}
	
	public String getEmail()
	{
		String value = properties.getProperty("email");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("email not specified in config file");
	}
	
	public String getPassword()
	{
		String value = properties.getProperty("password");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("password not specified in config file");
	}
	
}
