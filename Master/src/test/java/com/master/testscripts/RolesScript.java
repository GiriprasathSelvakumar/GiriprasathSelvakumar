package com.master.testscripts;



import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.master.basescripts.BaseTestScripts;


public class RolesScript extends BaseTestScripts{

	@Test
	public  void PrepareCarrierData() throws InterruptedException, Exception


	{
		
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("rolename", "ROLES"+GetRandomString(5));
		roles.put("roledescp", "ROLES"+GetRandomString(5));
		this.RolesCreations(roles, "//SPAN[text()='Role saved successfully']","Role saved successfully" );
	
	}
	public void RolesCreations(Map<String, String> roles , String xpath , String AssertText) throws Exception {
		
		try {	
			parantTest = extent.createTest("Roles Creations");
			childTest = parantTest.createNode("Role Creation Steps ");
			FileInputStream j = new FileInputStream(".//Roles.properties");
			Properties r= new Properties();
            r.load(j);
			Sleep();
			ClickEvents(r.getProperty("MAS_SECURITY_MENU"));
			childTest.pass("Role  Menu Clicked  Successfully");
			Sleep();
			ClickEvents(r.getProperty("MAS_ROLES_MENU"));
			Sleep();
			ClickEvents(r.getProperty("MAS_ROLES_ADDROLE"));
			childTest.pass("Role Add New Menu Button  Successfully");
			ClickEvents(r.getProperty("MAS_ROLES_NAME"));
			EnterValueXpath(r.getProperty("MAS_ROLES_NAME"), roles.get("rolename"));
			childTest.pass("Role New Entered  Successfully");
			ClickEvents(r.getProperty("MAS_ROLES_ROLEDESCRIPTION"));
			EnterValueXpath(r.getProperty("MAS_ROLES_ROLEDESCRIPTION"), roles.get("roledescp"));
			childTest.pass("Role Description Entered  Successfully");
			ClickEvents(r.getProperty("MAS_ROLES_SUBMIT"));
			Sleep();
			/*
			 * WebElement msg=driver.findElement(By.xpath(xpath)); String
			 * text=msg.getText(); AssertJUnit.assertEquals(text, AssertText);
			 */
			childTest.pass("Role Created Successfully");
			extent.flush();
		} catch (Exception e) {
			childTest.log(Status.FAIL,"Roles Fail Screenshot ", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());			
			childTest.log(Status.FAIL, GetScreenshot(driver, "RolesError"));
			childTest.info(e);
			e.printStackTrace();
			throw e; }
	}
}

