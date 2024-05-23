package com.master.bulkscripts;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.master.basescripts.BaseTestScripts;
import com.master.testscripts.CarrierScript;
import com.master.testscripts.RolesScript;

public class DataProviderRolesScript extends BaseTestScripts{

	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static DataFormatter formatter= new DataFormatter();
	static String SheetName = "Sheet2";
	public static  String Res;
	public static Map<String,String> table = null;
	public static String ColName="Result";
	public static int col_num;
	public static String result;
	public static int DataSet;

	
	

	@Test(dataProvider ="ReadVariant")
	public static  void ReadV(String rolename , String roledescp  , String xpath, String AssertText) throws InterruptedException, Exception {

		System.out.println("CARRIERNAME:" +rolename);
		System.out.println("SHORTNAME:" +roledescp);
		RolesScript k =new RolesScript();
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("rolename", rolename);
		roles.put("roledescp", roledescp);
		k.RolesCreations(roles, xpath, AssertText);
	


	}
			
	
	@DataProvider
	public static Object[][] ReadVariant() throws InterruptedException, Exception
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















