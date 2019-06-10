package PageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.beust.testng.*;

import Common_Features.Common_Features;



public class Login_PO {
	
	
	String username_Label_xPath = "//label[contains(text(),\"Username\")]";
	String username_xPath = "//input[@id='username']";
	String password_xPath = "//input[@id='password']";
	String login_button_xPath = "//input[@type='submit'][@id='Login']";
	String home_tab_xPath = "//span[@class='slds-truncate'][contains(text(),'Home')]";

	
	public void NavigateURL(WebDriver driver, String path, String sheet, int testNumber) {
		

			Common_Features common_Features = new Common_Features();
			String URL = common_Features.retrieveDataFromExcel(path, sheet, "URL", testNumber);
			driver.get(URL);
			
			List<WebElement> username_exists = driver.findElements(By.xpath(username_Label_xPath));
			
			Assert.assertEquals(username_exists.isEmpty(), false);
		
	}
	

	
	public void Salesforce_Login(WebDriver driver, String filePath, String sheet, int testNumber) {
		
		String userName = Common_Features.retrieveDataFromExcel(filePath, sheet, "UserName", testNumber);
		String password = Common_Features.retrieveDataFromExcel(filePath, sheet, "Password", testNumber);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(username_xPath))));
		driver.findElement(By.xpath(username_xPath)).sendKeys(userName);
		driver.findElement(By.xpath(password_xPath)).sendKeys(password);
		driver.findElement(By.xpath(login_button_xPath)).click();
		
		
	}
	
	
	
}
