package com.master.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.master.basescripts.BaseTestScripts;

public class PartnerScript extends BaseTestScripts {

	public static String partnername;

	
@Test
	public void PartnerCreate() throws Exception {

		try {
		
			ReadProps(".//Partner.properties");
			Sleep();
			parantTest = extent.createTest("Partner Creations");
			childTest = parantTest.createNode("Partner Creations Steps ");
			ClickEvents(prop1.getProperty("partnermenu"));
			Sleep();
			childTest.pass("Partner Menu Clicked  Successfully");
			Sleep();
			ClickEvents(prop1.getProperty("MAS_PARTNER_ADDNEW"));
			childTest.pass("Partner Addnew Clicked  Successfully");
			ClickEvents(prop1.getProperty("MAS_PARTNERNAME"));
			partnername = "PARTNER" + GetRandomString(5);
			EnterValueXpath(prop1.getProperty("MAS_PARTNERNAME"), partnername);
			childTest.pass("Partner Name Entered  Successfully");
			ClickEvents(prop1.getProperty("MAS_VENDOR"));
			ClickEvents(prop1.getProperty("MAS_CUSTOMER"));
			childTest.pass("Relationship selected Successfully");
			ClickEvents(prop1.getProperty("PARTNER_TYPE"));
			ClickEvents(prop1.getProperty("BOOKINGPARTY"));
			ClickEvents(prop1.getProperty("TRANSPORTER"));
			ClickEvents(prop1.getProperty("PARTNER_TYPE"));
			childTest.pass("Partner Type Selected Successfully");
			ClickEvents(prop1.getProperty("PAN"));
			EnterValueXpath(prop1.getProperty("PAN"), "BTPRG" + GetRandomNo(4) + "H");
			childTest.pass("PAN Number Entered Successfully");
			Sleep();
			ClickEvents(prop1.getProperty("MAPSELECT"));
			EnterValueXpath(prop1.getProperty("MAPSELECT"), "palani");
			addressAdd();
			childTest.pass("Location selected Successfully");
			Sleep();
			ClickEvents(prop1.getProperty("PARTNER_SUBMIT"));
			childTest.pass("Partner Created Successfully");
			Sleep();
			Sleep();
			childTest = parantTest.createNode("Partner Editing Steps ");
			Sleep();
			ClickEvents(prop1.getProperty("PARTNER_FILTER"));
			ClickEvents(prop1.getProperty("PARTNER_FILTER"));
			ClickEvents(prop1.getProperty("PARTNER_INPUT"));
			EnterValueXpath(prop1.getProperty("PARTNER_INPUT"), partnername);
			Sleep();
			ClickEvents(prop1.getProperty("PARTNER_SEARCHFILTER"));
			Sleep();
			ClickXpath(prop1.getProperty("PARTNER_EDIT_CLICK"));
			Sleep();
			ClickEvents(prop1.getProperty("PARTNER_EDIT_NAME"));
			Sleep();
			driver.findElement(By.xpath("//*[@id=\"partner-name\"]")).clear();
			ClickEvents(prop1.getProperty("PARTNER_EDIT_NAME"));
			EnterValueXpath(prop1.getProperty("MAS_PARTNERNAME"), "PARTNER" + GetRandomNo(4));
			childTest.pass("Partner Name Edited  Successfully");
			ClickEvents(prop1.getProperty("PARTNER_EDIT_DROPDWNTYPE"));
			ClickEvents(prop1.getProperty("PARTNER_EDIT_TYPE"));
			ClickEvents(prop1.getProperty("PARTNER_EDIT_DROPDWNTYPE"));
			ClickEvents(prop1.getProperty("PARTNER_EDIT_SUBMIT"));
			childTest.pass("Partner Details Edited  Successfully");
			ClickEvents(prop1.getProperty("PARTNER_REG_MENU"));
			ClickEvents(prop1.getProperty("PARTNER_REG_PANEDIT"));
			Sleep();
			EnterValueXpath(prop1.getProperty("PARTNER_REG_PANNO"), "ATPRG" + GetRandomNo(4) + "H");
			Sleep();
			ClickEvents(prop1.getProperty("PARTNER_REG_PANNO_TICK"));
			Sleep();
			childTest.pass("Registration Edited  Successfully");
			ClickEvents(prop1.getProperty("PARTNER_LOCATION"));
			ClickEvents(prop1.getProperty("PARTNER_ADDNEW"));
			String location = "PALANI-" + GetRandomString(3);
			EnterValueXpath(prop1.getProperty("PARTNER_LOCATION_NAME"), location);
			ClickEvents(prop1.getProperty("PARTNER_LOCATION_SUBMIT"));
			Sleep();
			childTest.pass("Partner Location Added  Successfully");
			ClickEvents(prop1.getProperty("PARTNER_ADDRESS"));
			ClickEvents(prop1.getProperty("ADDRESS_ADDNEW"));
			ClickEvents(prop1.getProperty("ADDRESS_LOCDROPDOWN"));
			Sleep();
			dropdown();
			Sleep();
			ClickEvents(prop1.getProperty("ADDRESS_CHECBOX1"));
			Sleep();
			ClickEvents(prop1.getProperty("MAPSELECT"));
			EnterValueXpath(prop1.getProperty("MAPSELECT"), "Mathanapuram");
			addressAdd();
			Sleep();
			ClickEvents(prop1.getProperty("ADDRESS_SUBMIT"));
			Sleep();
			childTest.pass("Partner Address Added for the created Location Successfully");
			ClickEvents(prop1.getProperty("PREFERENCE"));
			Sleep();
			ClickEvents(prop1.getProperty("EXPORT_TYPE1"));
			Sleep();
			ClickEvents(prop1.getProperty("Ports"));
			Sleep();
			EnterValueXpath(prop1.getProperty("Searchport"), prop1.getProperty("portsearch"));
			Sleep();
			jsClick(prop1.getProperty("Checkbox"));
			KeyPress();
			Sleep();
			ClickEvents(prop1.getProperty("Submit"));
			childTest.pass("Partner Preference Edited Successfully");
			extent.flush();
		}
		catch (Exception e) { 
			childTest.log(Status.FAIL,"Partner-Edit Fail Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());			
			childTest.log(Status.FAIL, GetScreenshot(driver, "PartnerError"));
			childTest.info(e);
			extent.flush();
			e.printStackTrace();
			throw e; }
	}
}
