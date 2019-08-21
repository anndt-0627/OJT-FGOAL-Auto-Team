package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObj_ObjDetail_KR_Options {
	
	private static WebElement element = null;

	public static WebElement KR_QuickAction_btn_ChangeName(WebDriver driver, String krName) {
		element = driver.findElement(By.xpath("//a[contains(text(),'"+ krName + "')]/ancestor-or-self::div[@class='form-group m-form__group row parentComment m-auto']//span[contains(text(),'Update Key result title')]"));
		return element;
	}
	
	public static WebElement KR_Changename_txb_name(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@id='changeNameKeyResult']"));
		return element;
	}
	public static WebElement KR_Changename_btn_update(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//form[@id='updateNameKeyResult']//button[@class='btn btn-info pull-left'][contains(text(),'Update')]"));
		return element;
	}
	
	public static WebElement KR_Changename_btn_close(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//form[@id='updateNameKeyResult']//button[@class='btn btn-dark'][contains(text(),'Close')]"));
		return element;
	}
	public static WebElement KR_Changename_lb_error(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//label[@id='changeNameKeyResult-error']"));
		return element;
	}
	
	public static WebElement ObjDetail_KR_lb_message(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		return element;
	}
	public static WebElement ObjDetail_KR_record(WebDriver driver, String krName) {
		element = driver.findElement(By.xpath("//a[contains(text(),'"+ krName + "')]"));
		return element;
	}
	
	public static WebElement KR_QuickAction_btn_Changeweight(WebDriver driver, String krName) {
		element = driver.findElement(By.xpath("//a[contains(text(),'"+ krName + "')]/ancestor-or-self::div[@class='form-group m-form__group row parentComment m-auto']//span[contains(text(),'Update Key result title')]"));
		return element;
	}
	
	public static WebElement KR_QuickAction_Changeweight_popup(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='changeWeight']//div[@class='modal-header']"));
		return element;
	}
	public static WebElement KR_QuickAction_Changeweight_txb_weight(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='changeWeightKeyResult']"));
		return element;
	}
	public static WebElement KR_QuickAction_Changeweight_btn_close(WebDriver driver) {
		element = driver.findElement(By.xpath("//form[@id='updateWeightKeyResult']//button[@class='btn btn-dark'][contains(text(),'Close')]"));
		return element;
	}
	public static WebElement KR_QuickAction_Changeweight_btn_update(WebDriver driver) {
		element = driver.findElement(By.xpath("//form[@id='updateWeightKeyResult']//button[@class='btn btn-info pull-left'][contains(text(),'Update')]"));
		return element;
	}
	
	public static WebElement KR_QuickAction_Changeweight_lb_errormessage(WebDriver driver) {
		element = driver.findElement(By.xpath("//form[@id='updateWeightKeyResult']//div[@class='error input-group']"));
		return element;
	}
}
