package com.master.testscripts;


import org.openqa.selenium.By;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.master.basescripts.BaseTestScripts;



public class CarrierScript extends BaseTestScripts {

	@Test
	public  void PrepareCarrierData() throws InterruptedException, Exception

	{
		
		Map<String, String> carrier = new HashMap<String, String>();
		carrier.put("carriername", "CARRIER"+GetRandomString(5));
		carrier.put("carriershort", "CARRIER"+GetRandomString(5));
		carrier.put("carriercode", "CARRIER"+GetRandomString(3));
		carrier.put("carrierdesc", "CARRIER"+GetRandomString(5));
		this.CarrierCreate(carrier, "//SPAN[text()='Carrier saved successfully']","Carrier saved successfully" );
	
	}

	public void CarrierCreate(Map<String, String> carrier , String xpath , String AssertText)throws Exception, InterruptedException {
		{
			try {
				

				parantTest = extent.createTest("Carrier Creations");
		       childTest = parantTest.createNode("Carrier Creations Steps ");
		       FileInputStream f = new FileInputStream(".//Carrier.properties");
				Properties c= new Properties();
                c.load(f);
				Thread.sleep(2000);
				ClickEvents(c.getProperty("MAS_CARRIERS_CLICK"));	
				childTest.pass("Carrier Menu Clicked  Successfully");
				Thread.sleep(3000);
				ClickEvents(c.getProperty("MAS_CARRIERS_ADDNEW"));
				childTest.pass("Carrier Add New Button Clicked  Successfully");
				ClickEvents(c.getProperty("MAS_CARRIERS_CARRIERNAME"));
				EnterValueXpath(c.getProperty("MAS_CARRIERS_CARRIERNAME"), carrier.get("carriername"));
				childTest.pass("Carrier Name Entered Successfully");
				ClickEvents(c.getProperty("MAS_CARRIERS_CARRIERSHORTNAME"));	
				EnterValueXpath(c.getProperty("MAS_CARRIERS_CARRIERSHORTNAME"),carrier.get("carriershort"));
				childTest.pass("Carrier Short Name Entered Successfully");
				ClickEvents(c.getProperty("MAS_CARRIERS_CARRIERCODE"));
				EnterValueXpath(c.getProperty("MAS_CARRIERS_CARRIERCODE"),carrier.get("carriercode"));
				childTest.pass("Carrier Code Entered Successfully");
				ClickEvents(c.getProperty("MAS_CARRIERS_TRIANGULATION"));
				ClickEvents(c.getProperty("MAS_CARRIERS_DESCRIPTION"));
				EnterValueXpath(c.getProperty("MAS_CARRIERS_DESCRIPTION"),carrier.get("carrierdesc"));
				childTest.pass("Carrier Description Entered Successfully");	
				Sleep();
				FileUpload();
				Sleep();
				ClickEvents(c.getProperty("MAS_CARRIERS_SUBMITBTN"));
				childTest.pass("Carrier Saved Successfully");	
				Sleep();
				childTest = parantTest.createNode("Carrier Editing Steps ");
				ClickEvents(c.getProperty("FILTER"));
				ClickEvents(c.getProperty("SEARCH_FIELD"));
				EnterValueXpath(c.getProperty("SEARCH_FIELD"),carrier.get("carriername") );
				Thread.sleep(5000);
				childTest.pass("Carrier filter applied successfully ");
				ClickEvents(c.getProperty("FILTER_SUBMIT"));
				Thread.sleep(5000);
				ClickEvents(c.getProperty("CARRIER_LISTING"));
				Sleep();
				childTest.pass("Carrier View page landed Sucessfully  ");
				ClickEvents(c.getProperty("MAS_CARRIERS_CARRIERSHORTNAME"));
				driver.findElement(By.xpath("//*[@id=\"carrier-short-name\"]")).clear();
				ClickEvents(c.getProperty("MAS_CARRIERS_CARRIERSHORTNAME"));
				EnterValueXpath(c.getProperty("MAS_CARRIERS_CARRIERSHORTNAME"),carrier.get("carriername"));
				childTest.pass("Carrier Shortname Edited  Sucessfully  ");
				Sleep();
				ClickEvents(c.getProperty("MAS_CARRIERS_SUBMITBTN"));
				childTest.pass("Carrier Edit saved successfully");
				extent.flush();
			} catch (Exception e) { 
				childTest.log(Status.FAIL,"Carrier Fail Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());			
				childTest.log(Status.FAIL, GetScreenshot(driver, "CarrierError"));
				childTest.info(e);
				e.printStackTrace();
				throw e; }

		}


	}


	

}












