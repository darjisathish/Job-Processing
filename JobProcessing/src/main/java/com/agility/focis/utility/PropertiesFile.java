package com.agility.focis.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	public static String read(String attributeKey) {
  	  
  	  Properties prop=new  Properties();
		
		String filepath=System.getProperty("user.dir")+"\\config.properties";
		
		try {
			FileInputStream ip= new FileInputStream(filepath);
			
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop.getProperty(attributeKey);
    }


}
