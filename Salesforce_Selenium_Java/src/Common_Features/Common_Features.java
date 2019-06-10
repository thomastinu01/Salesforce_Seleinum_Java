package Common_Features;

import java.io.File;
import java.util.Iterator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common_Features {
	
	public  WebDriver initializeTest(String browser) {
		
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver","Library/chromedriver.exe");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}
		
		return driver;
	}

	public static String retrieveDataFromExcel(String path, String sheet, String dataColumn, int testNumber) {

		String data = null;
		
		try {
			FileInputStream dataFile = new FileInputStream(new File(path)) ;
			HSSFWorkbook HSSFWorkbook = new HSSFWorkbook(dataFile);
			HSSFSheet HSSFSheet = HSSFWorkbook.getSheet(sheet);
			int dataShift = -1;
			Iterator<Cell> cellIterator = HSSFSheet.getRow(0).cellIterator();
			
			while(cellIterator.hasNext()){
				Cell cell = (Cell)cellIterator.next();
				
				if (cell.getStringCellValue().equals(dataColumn)) {
					dataShift = cell.getColumnIndex();
				}
			}
			
			data = HSSFSheet.getRow(testNumber).getCell(dataShift).getStringCellValue();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return data;
	}
	
	public void endTest(WebDriver driver) {
		driver.close();
	}
}
