package Common_Features;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Salesforce_Actions {

	String apps_xPath = "//div[@class='slds-icon-waffle']";
	String searchApp_TextBox_xPath = "//input[@class='slds-input input']";
	String new_Button_xPath = "//div[@title='New'][contains(text(),'New')]";
	String save_Button_xPath = "//button[@title='Save']";

	public void open_Object(WebDriver driver, String filePath, String sheet, int testNumber) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.findElement(By.xpath(apps_xPath)).click();
		String object = Common_Features.retrieveDataFromExcel(filePath, sheet, "ObjectName", testNumber);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchApp_TextBox_xPath)));
		driver.findElement(By.xpath(searchApp_TextBox_xPath)).sendKeys(object);
		driver.findElement(By.xpath("//a[@title='" + object+ "']//span[@class='label slds-truncate slds-text-link']")).click();	
		
	}
	
	public void click_New_Button(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(new_Button_xPath)));
		driver.findElement(By.xpath(new_Button_xPath)).click();
	}
	
	public void enterTextBoxValue(WebDriver driver, String filePath, String sheet, int testNumber, String SFField) {
		
		String textToEnter = Common_Features.retrieveDataFromExcel(filePath, sheet, SFField, testNumber);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+SFField+"']/parent::*/parent::*//input[contains(@type,'text') or contains(@type,'tel')]"))).sendKeys(textToEnter);
		
	}
	
	public void enterTextBoxValueAndRandom(WebDriver driver, String filePath, String sheet, int testNumber, String SFField) {
		
		Random Random = new Random();
		int RandomNumber = Random.nextInt(999999);
		String textToEnter = Common_Features.retrieveDataFromExcel(filePath, sheet, SFField, testNumber);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+SFField+"']/parent::*/parent::*//input[contains(@type,'text') or contains(@type,'tel')]"))).sendKeys(textToEnter+RandomNumber);
		
	}
	
	public void click_Save_Button(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(save_Button_xPath))).click();
		new WebDriverWait(driver, 30).until(
		          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
}
