package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Common_Features.Common_Features;
import PageObjects.Login_PO;

public class Create_Account {
	
	@Parameters({"testNumber","browser"})
	@Test
	public void createAccount_MandatoryFields(int testNumber, String browser) {
		
		
		String filePath = "TestData/Accounts.xls";
		String sheet = "CreateAccount";
		
		Common_Features common_Features = new Common_Features();
		WebDriver driver = common_Features.initializeTest(browser);
		
		Login_PO Login_PO = new Login_PO();
		Login_PO.NavigateURL(driver, filePath, sheet, testNumber);
		Login_PO.Salesforce_Login(driver, filePath, sheet, testNumber);
		
		
		common_Features.endTest(driver);
	}

}
