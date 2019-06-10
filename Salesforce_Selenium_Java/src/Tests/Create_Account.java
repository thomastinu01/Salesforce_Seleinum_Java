package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Common_Features.Common_Features;
import Common_Features.Salesforce_Actions;
import PageObjects.Account_PO;
import PageObjects.Login_PO;

public class Create_Account {
	
	@Parameters({"testNumber","browser"})
	@Test
	public void createAccount_MandatoryFields(int testNumber, String browser) {
		
		
		String filePath = "TestData/Accounts.xls";
		String sheet = "CreateAccount";
		
		Common_Features common_Features = new Common_Features();
		WebDriver driver = common_Features.initializeTest(browser);
		
		//Login to Salesforce
		Login_PO Login_PO = new Login_PO();
		Login_PO.NavigateURL(driver, filePath, sheet, testNumber);
		Login_PO.Salesforce_Login(driver, filePath, sheet, testNumber);
		
		//Open Account object
		Salesforce_Actions Salesforce_Actions = new Salesforce_Actions();
		Salesforce_Actions.open_Object(driver, filePath, sheet, testNumber);
		
		
		//Create new account
		Salesforce_Actions.click_New_Button(driver);
		
		Account_PO Account_PO = new Account_PO();
		Account_PO.EnterDetailsforAccount(driver, filePath, sheet, testNumber);
		
		Salesforce_Actions.click_Save_Button(driver);
		
		common_Features.endTest(driver);
	}

}
