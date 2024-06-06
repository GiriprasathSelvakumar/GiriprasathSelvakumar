package com.automationlearnings.workspace;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFiledata {
	
	public static Properties prop;
	
	
	public static void fileread() {
		
		
		if(prop==null) {
	
		 prop = new Properties();
	 try {
		 FileInputStream fis = new FileInputStream("D:\\Giri_Automation\\Automation_Learnings\\Properties.properties");
		
			
			prop.load(fis);
			
	} catch (Exception e) {

	}

}
}
}