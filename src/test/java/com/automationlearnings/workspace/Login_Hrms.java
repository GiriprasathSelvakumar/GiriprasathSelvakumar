package com.automationlearnings.workspace;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Hrms {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		Login();
		
	}
		public static void Login() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);

		WebElement Username =driver.findElement(By.xpath("//input[@placeholder='Username']"));

		Username.click();
		Username.sendKeys("Admin");
		
		Thread.sleep(2000);
		WebElement Password =driver.findElement(By.xpath("//input[@placeholder='Password']"));
		Password.click();
		Password.sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();



		}


	}

	

