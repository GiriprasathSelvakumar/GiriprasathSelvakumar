package com.master.basescripts;



import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Function;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestScripts  {

	public static WebDriver driver;
	public static Properties prop;
	public static Properties prop1;
	public static Actions action;

	public static ExtentTest parantTest;
	public static ExtentTest childTest;
	//public ExtentTest logger;
	public static ExtentHtmlReporter HtmlReport;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static FluentWait<WebDriver> fluentwait;
	public WebDriverWait wait;;
	public static String click;
	public static int columnSize=0;
	public static String[] Cell ;
	public static XSSFSheet Sheet1; 
	public static XSSFCell cell;





	public static void BrowserLaunch() throws IOException {

		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream fis = new FileInputStream(".//Config.properties");
				prop.load(fis);
				{	
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					driver.get(prop.getProperty("URL5"));
					driver.manage().window().maximize();
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}		

	}

	public static void ReadProps(String filepath) throws IOException {

		if (prop1 == null) {
			prop1 = new Properties();
			try {
				FileInputStream pis = new FileInputStream(filepath);
				prop1.load(pis);
			} catch (Exception e) {
				e.printStackTrace();

			}
		}		

	}

	public static void ClickEvents(String xpath) throws Exception {
		try {
			action = new Actions(driver);	
			WebElement element = fluentWait(xpath);
			element = driver.findElement(By.xpath(xpath));
			action.moveToElement(element).click().perform();

		} catch (Exception e) {
			System.out.println(e);
			childTest.log(Status.FAIL,"Carrier Fail Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());	
			childTest.log(Status.FAIL, GetScreenshot(driver, "clickevent")).addScreenCaptureFromPath(ScreenCapture());
			childTest.info(e);
			extent.flush();
		}	

	}

	public void ClickXpath(String xpath) throws InterruptedException {


		Thread.sleep(1000);
		click=xpath;
		WebElement element = fluentWait(xpath);
		element.click();
		childTest.log(Status.INFO, "Clicking on  "+xpath);


	}

	public void EnterXpath(String xpath, String value1,String locator) throws Exception {

		//Thread.sleep(2000);
		String value =new String(value1.trim());
		click=value;
		WebElement element = fluentWait(xpath);

		element.clear();

		element.sendKeys(value.trim());
		childTest.log(Status.INFO, "Entered :  "+value+" in the   "+locator+"  field: ");

	}
	public static void Sleep() throws IOException, Exception {
		try {
			Thread.sleep(2000);

		}catch (Exception e) {
			System.out.println(e);
			childTest.log(Status.FAIL,"Carrier Fail Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());	
			childTest.log(Status.FAIL, GetScreenshot(driver, "Sleepevent")).addScreenCaptureFromPath(ScreenCapture());
			childTest.info(e);
			extent.flush();
		}
	}

	public static void EnterValueXpath(String xpath,String value) throws Exception {
		try {
			action = new Actions(driver);	
			WebElement element = fluentWait(xpath);
			element = driver.findElement(By.xpath(xpath));
			element.clear();
			action.moveToElement(element).sendKeys(value).perform();

		}catch (Exception e) { e.printStackTrace();
		childTest.log(Status.FAIL,"Carrier Fail Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());	
		childTest.log(Status.FAIL, GetScreenshot(driver, "Entervalue")).addScreenCaptureFromPath(ScreenCapture());
		childTest.info(e);
		extent.flush();
		}
	}
	public static void enterValueInFied(String xpath1,String value) 
	{
		
		driver.findElement(By.xpath(xpath1)).sendKeys(value);
	
		
	}
	public static  String GetRandomString(int n) {

		String AlphaNumericString = "0123456789" +"ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}
	public static  String GetRandomNo(int n) {

		String AlphaNumericString = "0123456789" ;
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}


	public static void cleartxt(String xpath )
	{

		driver.findElement(By.xpath(xpath)).clear();

	}
	public static void KeyPress() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ESCAPE).build().perform();
		Thread.sleep(2000);
	}
	public static void radiobutton()
	{
		WebElement radio = driver.findElement(By.xpath("//input[@id='mistyLocation_no-input']"));
		radio.click();
		radio.isDisplayed();
		radio.isSelected();
	}
	public static void jsClick(String Value1)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return arguments[0].click();", driver.findElement(By.xpath(Value1)));
	}


	public static void addressAdd() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.SPACE).perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ENTER).perform();
	}
	public static void dynamicClick(String Value1)
	{
		new WebDriverWait(driver, Duration.ofSeconds(20))
        .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Value1)))).click();
		//driver.findElement(By.xpath(Value1)).click();
	}
	public static void dropdown() throws InterruptedException
	{

		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).perform();
	}




	public static void Wait() throws IOException, Exception {
		try {


			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}catch (Exception e) { e.printStackTrace();
		childTest.log(Status.FAIL,"Carrier Fail Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());	
		childTest.log(Status.FAIL, GetScreenshot(driver, "implicitwait")).addScreenCaptureFromPath(ScreenCapture());
		childTest.info(e);
		extent.flush();
		}

	}

	public static void ExtendReport() throws Exception {
		try {


			HtmlReport = new  ExtentHtmlReporter(".//MASTERS-AUTOMATIONS.html");
			extent = new ExtentReports(); extent.attachReporter(HtmlReport);

			extent.setSystemInfo("Browser", "Chrome");
			extent.setSystemInfo("Host Name",Runtime.getRuntime().exec("hostname").
					toString()); HtmlReport.config().setEncoding("utf-8");
					HtmlReport.config().setDocumentTitle("MASTERS AUTOMATIONS RESULTS");
					HtmlReport.config().setReportName("MASTERS AUTOMATIONS RESULTS"); 
		}catch (Exception e) { e.printStackTrace();
		childTest.log(Status.FAIL," Fail Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());	
		childTest.log(Status.FAIL, GetScreenshot(driver, "Report")).addScreenCaptureFromPath(ScreenCapture());
		childTest.info(e);
		extent.flush();
		}

	}


	public static  String ScreenCapture() throws Exception{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(System.getProperty("user.dir")+"/Screenshots/test" + System.currentTimeMillis() + ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		byte[] img=IOUtils.toByteArray(new FileInputStream(errflpath));
		return Base64.getEncoder().encodeToString(img);
	}

	public static  String GetScreenshot(WebDriver driver, String screenshotName) throws Exception
	{
		try {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + dateName + ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}	catch (Exception e) {
			e.printStackTrace();
			childTest.log(Status.FAIL, GetScreenshot(driver, "CarrierError"));
			//childTest.log(Status.FAIL,"Screenshot  :",MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture(driver)).build());
			childTest.info(e);
			extent.flush();
			driver.quit();
			throw e; } }


	public static  void FileUpload() throws IOException, Exception {


		Thread.sleep(2000);
		WebElement file = driver.findElement(By.id("file-upload"));
		Thread.sleep(2000);
		file.sendKeys("C:\\Users\\girip\\OneDrive\\Desktop\\sample.jpg");
		Thread.sleep(2000);

	}
	
	public static  void FileUpload1() throws IOException, Exception {


		Thread.sleep(2000);
		WebElement file = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
		Thread.sleep(2000);
		file.sendKeys("C:\\Users\\girip\\OneDrive\\Desktop\\sample.jpg");
		Thread.sleep(2000);

	}
	
	public static  void FileUpload2() throws IOException, Exception {
	ClickEvents("(//a)[@id='btn-file-upload']");
	Robot r = new Robot();
	
	StringSelection upload = new StringSelection("C:\\Users\\girip\\OneDrive\\Desktop\\sample.jpg");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(upload, null);
	
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_V);
	Thread.sleep(3000);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_V);
	Thread.sleep(3000);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(3000);
	}
	
	
	
	
	

	@SuppressWarnings("unchecked")
	public static WebElement fluentWait(final String xpath) {

		long TIMEUNIT = Long.parseLong(prop.getProperty("TIMECOUNT"));
		long POOLCOUNT = Long.parseLong(prop.getProperty("POOLINGTIME"));
		fluentwait = new FluentWait(driver).withTimeout(Duration.ofSeconds(TIMEUNIT))
				.pollingEvery(Duration.ofSeconds(POOLCOUNT)).ignoring(NoSuchElementException.class);
		return fluentwait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(xpath));
			}
		});
	}



	public   void ReadExcel (String xpath, int sheet,int i,  int column) throws IOException {


		File src=new File ("D:\\AutomationScripts\\Master\\Data.xlsx");
		FileInputStream fs = new FileInputStream(src);
		Workbook wb = new XSSFWorkbook(fs);
		Sheet sheet1 = wb.getSheetAt(sheet);
		WebElement element = fluentWait(xpath);

		{
			String location = sheet1.getRow(i).getCell(column).getStringCellValue();
			driver.findElement(By.xpath(xpath)).sendKeys(location);

		}


	}
	
	
	public static void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public static void LaunchBrowser() throws Exception {
		try {



		} catch (Exception e) {
			e.printStackTrace();			
		}
	}
	public static void editaddressAdd() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.SPACE).perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(3000);
	}





	@BeforeSuite
	public static void LoginProcess() throws Exception {
		try {
			BrowserLaunch(); 
			ExtendReport();
			parantTest = extent.createTest("Login Process");
			childTest = parantTest.createNode("Login Process");
			
			ClickEvents(prop.getProperty("MAS_USERNAME"));
			childTest.pass("Username Entered Successfully");
			EnterValueXpath(prop.getProperty("MAS_USERNAME"), prop.getProperty("usernames5"));
			ClickEvents(prop.getProperty("MAS_USER_NAME_NEXT"));
			EnterValueXpath(prop.getProperty("MAS_PASSWORD"),prop.getProperty("passwords5")); 
			childTest.pass("Password EnteredSuccessfully");
			ClickEvents(prop.getProperty("MAS_SIGNIN"));
			//Assert.assertEquals(driver.getCurrentUrl(), "https://mas.test.matchlog.net/#/");	
			childTest.pass("Logged In Successfully");
			extent.flush();
		} catch (Exception e) {

			childTest.log(Status.FAIL,"Login Fail Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());			
			childTest.log(Status.FAIL, GetScreenshot(driver, "LoginError"));
			childTest.info(e);
			extent.flush();
			e.printStackTrace();
			throw e; } 

	}
    @AfterSuite
	public void LogOut() throws Exception {
		try {
			parantTest = extent.createTest("Logout Process");
			childTest = parantTest.createNode("Logout Steps");
			Sleep();
			childTest.pass("Logout Button Clicked Successfully");
			ClickEvents(prop.getProperty("MAS_LOGOUT"));
		//	Assert.assertEquals(driver.getCurrentUrl(), "https://mas.test1.matchlog.net/#/auth/login");	
			childTest.pass("User Logged Out Clicked Successfully");
			extent.flush();
		} catch (Exception e) {
			e.printStackTrace();
			childTest.log(Status.FAIL,"Logout Fail Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenCapture()).build());			
			childTest.log(Status.FAIL, GetScreenshot(driver, "Logouterror"));
			childTest.info(e);
			extent.flush();
			driver.quit();
		}
	}









}








