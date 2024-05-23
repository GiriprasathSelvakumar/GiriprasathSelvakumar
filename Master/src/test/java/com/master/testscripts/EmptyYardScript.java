package com.master.testscripts;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.master.basescripts.BaseTestScripts;


public class EmptyYardScript extends BaseTestScripts {

	@Test
	public static void emptyYardCreate() throws Exception
	
	
	{try {
		parantTest = extent.createTest("Empty Yard Creations");
		childTest = parantTest.createNode("Empty Yard Creations Steps ");
		FileInputStream fin1 =new FileInputStream(".//Emptyyard.properties");
		Properties prop_newn = new Properties();
		prop_newn.load(fin1);
		Sleep();
		jsClick(prop_newn.getProperty("emptyYardMenu"));
		Sleep();
		childTest.pass("Empty Yard Menu Clicked Successfully");
		jsClick(prop_newn.getProperty("addYard"));
		Sleep();
		childTest.pass("Empty Yard Add new Clicked Successfully");
		String emptyYardName = prop_newn.getProperty("Yard")+ GetRandomString(4);
		EnterValueXpath(prop_newn.getProperty("yardName"),emptyYardName );
		Thread.sleep(3000);
		childTest.pass("Empty Yard Name Entered Successfully");
		ClickEvents(prop_newn.getProperty("port_select1"));
		Thread.sleep(3000);
		EnterValueXpath(prop_newn.getProperty("search1"),prop_newn.getProperty("portCode1"));
		Sleep();
		dynamicClick(prop_newn.getProperty("checkBox1"));
		KeyPress();
		childTest.pass("Empty Yard Port Selected Successfully");
		ClickEvents(prop_newn.getProperty("yardAddress1"));
		EnterValueXpath(prop_newn.getProperty("yardAddress1"), prop_newn.getProperty("Address1"));
		//Wait(2000);
		//enterValueInFied(prop_new.getProperty("yardAddress"), prop_new.getProperty("Address2"));
        addressAdd();
        Sleep();
    	childTest.pass("Empty Yard Address Selected Successfully");
        scroll();
        dynamicClick(prop_newn.getProperty("Submit"));
        childTest.pass("Empty Yard Created  Successfully");
        Thread.sleep(5000);
        String editYardName = "//p[text()='"+ emptyYardName +"']";
		Thread.sleep(5000);
		childTest = parantTest.createNode("Empty Yard Editing Steps ");
		jsClick(prop_newn.getProperty("emptyYardMenu"));
		jsClick(editYardName);
		Sleep();
		childTest.pass("Empty Yard Name edited  Successfully");
		enterValueInFied(prop_newn.getProperty("editSearchField"),prop_newn.getProperty("updateYardName"));
		//Wait(5000);
		dynamicClick(prop_newn.getProperty("submit"));
		childTest.pass("Empty Yard  edited  Successfully");
		Thread.sleep(10000);
		extent.flush();
	}
catch (Exception e) { 
	childTest.log(Status.FAIL,"Empty Yard Fail Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());			
	childTest.log(Status.FAIL, GetScreenshot(driver, "Empty Yard Error"));
	childTest.info(e);
	extent.flush();
	e.printStackTrace();
	throw e; }

}
}










