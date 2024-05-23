package com.master.testscripts;



import java.io.FileInputStream;
import java.util.Properties;


import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.master.basescripts.BaseTestScripts;

public class VehicleScript extends BaseTestScripts {

		
		@Test
		public static void VehicleCreate() throws Exception{
			try {
		
			FileInputStream fin1 =new FileInputStream(".//Vehicle.properties");
    		Properties prop_newk = new Properties();
    		prop_newk.load(fin1);
    		parantTest = extent.createTest("Vehicle  Creations");
    		childTest = parantTest.createNode("Vehicle Creations Steps ");
			Thread.sleep(5000);
			dynamicClick(prop_newk.getProperty("Vehicle_Menu"));
			childTest.pass("Vehicle Menu Clicked Successfully");
			Thread.sleep(5000);
			dynamicClick(prop_newk.getProperty("AddNew"));
			//Wait(3000);
			childTest.pass("Vehicle Button Clicked Successfully");
			String vehicleAddName = prop_newk.getProperty("VhNo")+ GetRandomNo(4);
            enterValueInFied(prop_newk.getProperty("Vehicle_No"),vehicleAddName);
			//Wait(2000);
        	childTest.pass("Vehicle Number Entered Successfully");
            dynamicClick(prop_newk.getProperty("Search"));
            Thread.sleep(3000);
            dynamicClick(prop_newk.getProperty("Transporter_Name_Field"));
			//Wait(2000);
			enterValueInFied(prop_newk.getProperty("Search_Name"), prop_newk.getProperty("Transname"));
			Thread.sleep(3000);
			childTest.pass("Transporter Name Selected Successfully");
			dynamicClick(prop_newk.getProperty("Select"));
			//Wait(2000);
			KeyPress();
			dynamicClick(prop_newk.getProperty("Submit"));
			Thread.sleep(2000);
			childTest.pass("Vehicle Created Successfully");
			Thread.sleep(5000);
			childTest = parantTest.createNode("Vehicle Editing Steps ");
			String vehicleEditName = "//p[text()= ' "+vehicleAddName+ " ']";
			//BaseScript.driver.manage().window().maximize();
			//Wait(3000);
			jsClick(prop_newk.getProperty("Vehicle_Menu"));
			Sleep();
			childTest.pass("Vehicle No clicked Successfully");
			dynamicClick(vehicleEditName);
			Thread.sleep(5000);
			dynamicClick(prop_newk.getProperty("Edit_Transporter"));
			Sleep();
			childTest.pass("Transporter Name Edited Successfully");
			enterValueInFied(prop_newk.getProperty("Search_Name"), prop_newk.getProperty("Transname1"));
			Sleep();
			dynamicClick(prop_newk.getProperty("Edit_Select"));
			Sleep();
			KeyPress();
			Sleep();
			childTest.pass("Transporter Name Edited Successfully");
			dynamicClick(prop_newk.getProperty("Edit_Sub"));
			Thread.sleep(15000);
			childTest.pass("Vehicle Edited Successfully");
			extent.flush();
		}	
catch (Exception e) { 
	childTest.log(Status.FAIL,"vehicle Fail Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());			
	childTest.log(Status.FAIL, GetScreenshot(driver, "vehicleError"));
	childTest.info(e);
	e.printStackTrace();
	throw e; }

}


}