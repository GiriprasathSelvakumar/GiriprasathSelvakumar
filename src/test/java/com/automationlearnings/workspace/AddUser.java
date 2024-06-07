package com.automationlearnings.workspace;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddUser extends Dashboard_Hrms{

	public static void main(String[] args) throws InterruptedException {
		Login();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebElement PIMBTN =	driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));

		PIMBTN.click();	


	}



}
