/*package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.testng.annotations.DataProvider;

import test.Login;

public class ReadXLSdata {
	
	Login log = new Login();
	//@DataProvider(name="")
	@DataProvider (name="login")
	public String[][] getData(String sheetname) throws EncryptedDocumentException, IOException {
		
		 //String excelSheetName = m.getName();
		 //System.out.println("M NAME IS PRINTING"+excelSheetName);
		File f = new File(System.getProperty("user.dir")+"\\src\\resources\\java\\org\\prohance\\test\\demoTest\\dataSheet.xls");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		//Sheet sheetName = wb.getNames("Team Manager");
		//List sheetNames = (List) wb.getNames(dataSheet.xls);
		Sheet sheetName = wb.getSheetName("Team Manager");
		//String sheetName = log.getSheetname("");
		System.out.println(sheetName);
		Sheet sheetName1 = wb.getSheet(sheetName);
		System.out.println("M NAME IS PRINTING"+sheetName);
		//System.out.println("sheet name" +sheetName);
		
		int totalRows = sheetName1.getLastRowNum();
		System.out.println("TOTAL NUMBER OF ROWS"+totalRows);
		Row rowcells = sheetName1.getRow(0);
		int totalColumn = rowcells.getLastCellNum();
		//System.out.println("Total number of column"+totalColumn);
		
		DataFormatter format = new DataFormatter();
		
		String testData[][] = new String[totalRows][totalColumn];
		for(int i=1;i<=totalRows;i++)
		{
			for(int j=0;j<totalColumn;j++)
			{
				testData[i-1][j]=format.formatCellValue(sheetName1.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		return testData;
	}

}*/
