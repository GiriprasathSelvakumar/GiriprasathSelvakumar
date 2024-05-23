package com.master.bulkscripts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.master.basescripts.BaseTestScripts;
import com.master.testscripts.CarrierScript;

public class DataProviderCarrierScript extends BaseTestScripts{

	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static DataFormatter formatter= new DataFormatter();
	static String SheetName = "Sheet1";
	public static  String Res;
	public static Map<String,String> table = null;
	public static String ColName="Result";
	public static int col_num;
	public static String result;
	public static int DataSet;


	@Test(dataProvider ="ReadData")
	public static  void ReadV(String carriername , String carriershort  , String carriercode ,  String carrierdesc , String xpath, String AssertText) throws InterruptedException, Exception {

		System.out.println("CARRIERNAME:" +carriername);
		System.out.println("SHORTNAME:" +carriershort);
		System.out.println("DESCRIPTION:" +carrierdesc);
		System.out.println("CODE:" +carriercode);
		//System.out.println("CHECKING:" +table);
		CarrierScript k =new CarrierScript();

		Map<String, String> carrier = new HashMap<String, String>();
		carrier.put("carriername", carriername);
		carrier.put("carriershort", carriershort);
		carrier.put("carriercode", carriercode);
		carrier.put("carrierdesc", carrierdesc);
		k.CarrierCreate(carrier, xpath, AssertText);



	}

	@DataProvider
	public static Object[][] ReadData() throws InterruptedException, Exception
	{
		FileInputStream fileInputStream= new FileInputStream("D:\\AutomationScripts\\Master\\Data.xlsx"); 
		workbook = new XSSFWorkbook (fileInputStream); 
		worksheet=workbook.getSheet(SheetName);
		XSSFRow Row=worksheet.getRow(2);    
		int RowNum = worksheet.getPhysicalNumberOfRows();
		int ColNum= Row.getLastCellNum(); 

		Object[][] Data= new Object[RowNum][ColNum]; 

		for(int i=0; i<RowNum; i++) 
		{  
			XSSFRow row=worksheet.getRow(i);

			for (int j=0; j<ColNum; j++) 
			{
				if(row==null)
					Data[i][j]= "";
				else 
				{
					XSSFCell cell= row.getCell(j);
					if(cell==null)
						Data[i][j]= ""; 
					else
					{
						String carrier=formatter.formatCellValue(cell);
						Data[i][j]=carrier; 
					}
				}
			}
		}
	;
		return Data;
	}

}














