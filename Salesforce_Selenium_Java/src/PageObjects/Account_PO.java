package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Common_Features.Salesforce_Actions;

public class Account_PO {
	

	
	public void EnterDetailsforAccount(WebDriver driver, String filePath, String sheet, int testNumber) {
		
		Salesforce_Actions Salesforce_Actions = new Salesforce_Actions();
		Salesforce_Actions.enterTextBoxValue(driver, filePath, sheet, testNumber, "Phone");
		Salesforce_Actions.enterTextBoxValueAndRandom(driver, filePath, sheet, testNumber, "Account Name");
		
	}

}
