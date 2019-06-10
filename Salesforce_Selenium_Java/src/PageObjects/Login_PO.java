package PageObjects;

import org.openqa.selenium.WebDriver;

import Common_Features.Common_Features;

public class Login_PO {

	
	public void NavigateURL(WebDriver driver, String path, String sheet, int testNumber) {
		
		Common_Features common_Features = new Common_Features();
		String URL = common_Features.retrieveDataFromExcel(path, sheet, "URL", testNumber);
		driver.get(URL);
			
		
	}
	
}
