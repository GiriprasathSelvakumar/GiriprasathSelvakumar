package com.automationlearnings.workspace;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice_GetMethods {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		
		// Pass the URL we will use get(URL)
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// Getting the URL
		
		String currentURL = driver.getCurrentUrl();
		
		System.out.println(currentURL);
		
		String title =driver.getTitle();
		
		// Getting the URL
		
		System.out.println(title);
		// Getting the Page Source
		
		String source =driver.getPageSource();
		
		System.out.println(source);

	}

}
