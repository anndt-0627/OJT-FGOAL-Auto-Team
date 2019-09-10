package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_Objective_Key_Result_View {
	private static WebElement element = null;
	
	public static WebElement linkNewKeyResult(WebDriver driver, String Keyresult_Name) {
		element = driver.findElement(By.xpath("//*[@id='main-content'][contains(text(),'" + Keyresult_Name + "')]"));
		return element;
	}
	
	public static WebElement popupKeyResultDetail(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']"));
		return element;
	}

	public static WebElement popupheaderKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//h4[@modal-title']"));
		return element;
	}

	public static WebElement txtWeightKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@class='form-control m-input keyResultWeightInputDetail']"));
		return element;
	}

	public static WebElement txttargetKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class='input-group-text targetunit'][@title='%']"));
		return element;
	}

	public static WebElement popupbttClose(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='btn btn-dark pull-left']"));
		return element;
	}

}
