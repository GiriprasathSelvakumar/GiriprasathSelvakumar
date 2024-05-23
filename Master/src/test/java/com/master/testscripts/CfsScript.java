package com.master.testscripts;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.master.basescripts.BaseTestScripts;

public class CfsScript extends BaseTestScripts {

	@Test
	public static void Add() throws Exception {
		try {
		
	
		FileInputStream f = new FileInputStream(".//cfs.properties");
		Properties prop_newj = new Properties();
		prop_newj.load(f);
		parantTest = extent.createTest("CFS Creations");
		childTest = parantTest.createNode("CFS Creations Steps ");
		ClickEvents(prop_newj.getProperty("CFS"));	
		Thread.sleep(5000);
		childTest.pass("CFS Menu Clicked  Successfully");
		jsClick(prop_newj.getProperty("AddCFS"));
		Sleep();
		ClickEvents(prop_newj.getProperty("CFSName"));
		Sleep();
		String cfsname = "Ranchi"+GetRandomString(3);
		EnterValueXpath(prop_newj.getProperty("CFSName"), cfsname);
		childTest.pass("CFS Name Entered Successfully");
		Sleep();
		ClickEvents(prop_newj.getProperty("Csfport_Select"));
		Sleep();
		EnterValueXpath(prop_newj.getProperty("cfsSearchport"), prop_newj.getProperty("cfsportsearch"));
		Sleep();
		jsClick(prop_newj.getProperty("cfsCheckbox"));
		KeyPress();
		childTest.pass("Port Selected  Successfully");
		ClickEvents(prop_newj.getProperty("cfsSearchAddress"));
		EnterValueXpath(prop_newj.getProperty("cfsSearchAddress"), prop_newj.getProperty("cfsText"));
		Sleep();
		addressAdd();
		childTest.pass("Address Selected   Successfully");
		Sleep();
		scroll();
		ClickEvents(prop_newj.getProperty("Submit"));
		Sleep();
		childTest.pass("CFS Created Successfully");
//		ClickEvents(prop_new.getProperty("CFS"));
		childTest = parantTest.createNode("CFS Editing Steps ");
		jsClick(prop_newj.getProperty("Edit"));
		Sleep();
		cleartxt(prop_newj.getProperty("Clearname"));
		ClickEvents(prop_newj.getProperty("CFSName"));
		String cfsnameedited = cfsname+GetRandomString(3);
		EnterValueXpath(prop_newj.getProperty("CFSName"),cfsnameedited);
		Sleep();
		childTest.pass("CFS Name Edited  Successfully");
		ClickEvents(prop_newj.getProperty("cfs_drops"));
		Sleep();		
		EnterValueXpath(prop_newj.getProperty("cfsSearchport"), prop_newj.getProperty("portsearchedit"));
		Sleep();
		childTest.pass("CFS Port Edited  Successfully");
		jsClick(prop_newj.getProperty("cfsCheckbox"));
		KeyPress();
		childTest.pass("CFS Port Edited  Successfully");
		cleartxt(prop_newj.getProperty("cfsSearchAddress"));
		EnterValueXpath(prop_newj.getProperty("cfsSearchAddress"), prop_newj.getProperty("Text1"));
		editaddressAdd();
		childTest.pass("CFS Address Edited  Successfully");
		ClickEvents(prop_newj.getProperty("Submit"));
		Sleep();
		childTest.pass("CFS  Edited  Successfully");
		extent.flush();
	}
		catch (Exception e) { 
			childTest.log(Status.FAIL,"CFS-Edit Fail Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());			
			childTest.log(Status.FAIL, GetScreenshot(driver, "CFS Error"));
			childTest.info(e);
			extent.flush();
			e.printStackTrace();
			throw e; }
	}

}
