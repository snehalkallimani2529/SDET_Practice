package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author Deepak
 *
 */
public class PropertyFileUtility {
	
	/**
	 *    used to read the common data from properties file based  on key
	 * @param key
	 * @return
	 * @throws Throwable
	 */

	public String readDataFromPropertyFfile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.PROPERTIESPATH);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}

}
