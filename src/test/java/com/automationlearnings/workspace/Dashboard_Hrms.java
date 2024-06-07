package com.automationlearnings.workspace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v123.page.model.NavigatedWithinDocument;

public class Dashboard_Hrms extends Login_Hrms {



	public static void main(String[] args) throws InterruptedException {

		Login();
		Thread.sleep(2000);

		WebElement Search =driver.findElement(By.xpath("//input[@placeholder='Search']"));

		Search.click();
		Boolean enable=	Search.isEnabled();
		System.out.println(enable);
		
		Boolean disabled =	Search.isDisplayed();
		System.out.println(disabled);
		
		driver.navigate().back();









	}

}
