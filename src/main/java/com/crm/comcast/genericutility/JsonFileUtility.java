package com.crm.comcast.genericutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * 
 * @author Deepak
 *
 */
public class JsonFileUtility {
	
	
	
	/**
	 *    used to read the common data from JSON file based  on key
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromJSonFile(String key) throws Throwable {
		
		/*step 1 : get the java object of the JSon PhysicalFile*/
		FileReader javaFileObj = new FileReader(IPathConstant.JSONPATH);
	    System.out.println(javaFileObj);
	    
	    /*step 2 : convert all the json data in to actual java Data type & return Object class var*/
	     JSONParser jpar = new JSONParser();
	      Object obj = jpar.parse(javaFileObj);   // upCasting
	      
	    /*step 3 : in order to read data in the form of "Key:value" pair , better practice to convert data in to hastMap*/  
	        HashMap jobj = (HashMap)obj;          // down-casting
	        String value = jobj.get(key).toString();
	        
	        
        return value;
	}
	

}
