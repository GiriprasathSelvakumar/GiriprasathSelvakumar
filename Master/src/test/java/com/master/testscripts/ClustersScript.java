package com.master.testscripts;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.master.basescripts.BaseTestScripts;

public class ClustersScript extends BaseTestScripts {
	
	
	public static Properties prop_newl;
	
	@Test
	public void add() throws Exception {
		try {
		FileInputStream j = new FileInputStream(".//cluster.properties");
		Properties prop_newl = new Properties();
		prop_newl.load(j);
		parantTest = extent.createTest("Cluster Creations");
		childTest = parantTest.createNode("Cluster Creations Steps ");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop_newl.getProperty("ClickCluster"))).click();
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AddNewCluster"))));
		driver.findElement(By.xpath(prop_newl.getProperty("AddNewCluster"))).click();
		Thread.sleep(2000);
		childTest.pass("Cluster Name Entered Successfully");
		String clustername = "Cluster"+GetRandomString(3);
		driver.findElement(By.xpath(prop_newl.getProperty("clusterfield"))).sendKeys(clustername);
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ClusterSubmit"))));
		driver.findElement(By.xpath(prop_newl.getProperty("ClusterSubmit"))).click();
		childTest.pass("Cluster Created Successfully");
		Thread.sleep(5000);
		childTest = parantTest.createNode("Cluster Editing Steps ");

		driver.findElement(By.xpath(prop_newl.getProperty("ClickCluster"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop_newl.getProperty("clickonrecord"))).click();
		Thread.sleep(3000);
		String clusteredit = "Cluster"+GetRandomString(3);
		driver.findElement(By.id("clusterName")).clear();
		childTest.pass("Cluster Name Edited Successfully");
		driver.findElement(By.xpath(prop_newl.getProperty("editclustername"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop_newl.getProperty("editclustername"))).sendKeys(clusteredit);
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop_newl.getProperty("ClusterSubmit"))).click();
    	Thread.sleep(3000);
    	childTest.pass("Cluster Edit saved Successfully");
		driver.findElement(By.xpath(prop_newl.getProperty("ClickCluster"))).click();
		driver.findElement(By.xpath(prop_newl.getProperty("clickonrecord"))).click();
		driver.findElement(By.xpath(prop_newl.getProperty("clickonstatus"))).click();
		driver.findElement(By.xpath(prop_newl.getProperty("selectdisabled"))).click();
		childTest.pass("Cluster Disabled Successfully");
		driver.findElement(By.xpath(prop_newl.getProperty("clickconfirm"))).click();
		driver.findElement(By.xpath(prop_newl.getProperty("ClusterSubmit"))).click();    	
    	Thread.sleep(3000);
		driver.findElement(By.xpath(prop_newl.getProperty("ClickCluster"))).click();
		driver.findElement(By.xpath(prop_newl.getProperty("clickonrecord"))).click();
    	Thread.sleep(3000);
		driver.findElement(By.xpath(prop_newl.getProperty("clickonstatus"))).click();
    	Thread.sleep(2000);
    	childTest.pass("Cluster Active Successfully");
		driver.findElement(By.xpath(prop_newl.getProperty("selectactive"))).click();
		driver.findElement(By.xpath(prop_newl.getProperty("ClusterSubmit"))).click();
		childTest.pass("Cluster Edited Successfully");
    	Thread.sleep(5000);
		driver.findElement(By.xpath(prop_newl.getProperty("ClickCluster"))).click();
		Thread.sleep(2000);
		System.out.println (driver.findElement(By.xpath(prop_newl.getProperty("ClusterPageName"))).getText());
	extent.flush();
}	
catch (Exception e) { 
	childTest.log(Status.FAIL,"Cluster Fail Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());			
	childTest.log(Status.FAIL, GetScreenshot(driver, "Clustererror"));
	childTest.info(e);
	extent.flush();
	e.printStackTrace();
	throw e; }

}
}
































