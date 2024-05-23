package com.master.testscripts;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.master.basescripts.BaseTestScripts;

public class ChargesScript extends BaseTestScripts {
	Properties prop_new = new Properties();
	@Test
	public static void AddCharges() throws Exception
	{
		try{
			
			FileInputStream f = new FileInputStream(".//ChargesAdd.properties");
			Properties prop_newc = new Properties();
			prop_newc.load(f);
			parantTest = extent.createTest("Charges Creations");
			childTest = parantTest.createNode("Charges Creations Steps ");
			Thread.sleep(2000);
			ClickEvents(prop_newc.getProperty("Charges"));
			Thread.sleep(2000);
			ClickEvents(prop_newc.getProperty("AddCharges"));;
			String Charges ="Overhaul"+GetRandomString(3);
			Sleep();
			EnterValueXpath(prop_newc.getProperty("ChargeName"), Charges);
			Sleep();
			childTest.pass("Charges Name Entered Successfully");
			ClickEvents(prop_newc.getProperty("ChargeType"));
			Sleep();
			childTest.pass("Charges type Entered Successfully");
			ClickEvents(prop_newc.getProperty("Checkbox"));
			KeyPress();
			Thread.sleep(2000);
			radiobutton();
			childTest.pass("Checkboxes Selected Successfully");
			EnterValueXpath(prop_newc.getProperty("ChargeSequence"), GetRandomNo(2));
			childTest.pass("Charges Sequence Selected Successfully");
			EnterValueXpath(prop_newc.getProperty("ChargeDesc"), prop_newc.getProperty("Desc"));
			childTest.pass("Charges Description Entered Successfully");
			ClickEvents(prop_newc.getProperty("Submit"));
			childTest.pass("Charges Created  Successfully");
			Sleep();
			childTest = parantTest.createNode("Charges Editing Steps ");
			ClickEvents(prop_newc.getProperty("Charges"));
			Thread.sleep(2000);
			ClickEvents(prop_newc.getProperty("Edit"));
			Thread.sleep(2000);
			childTest.pass("Charges Name Edited  Successfully");
			cleartxt(prop_newc.getProperty("ChargeName"));
			ClickEvents(prop_newc.getProperty("ChargeName"));
			String Charges1 ="Overhaul"+GetRandomString(2);
			EnterValueXpath(prop_newc.getProperty("ChargeName"), Charges1);
			ClickEvents(prop_newc.getProperty("Submit"));
			childTest.pass("Charges  Edited  Successfully");
			extent.flush();
		}
		catch (Exception e) { 
			childTest.log(Status.FAIL,"Charges Fail Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());			
			childTest.log(Status.FAIL, GetScreenshot(driver, "Chargeserror"));
			childTest.info(e);
			extent.flush();
			e.printStackTrace();
			throw e; }

	}





}



