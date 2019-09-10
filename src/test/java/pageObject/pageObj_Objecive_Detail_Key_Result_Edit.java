package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_Objecive_Detail_Key_Result_Edit {
private static WebElement element = null;
	
	public static WebElement linkKeyResult(WebDriver driver, String Keyresult_Name) {
		element = driver.findElement(By.xpath("//*[@id='main-content'][contains(text(),'" + Keyresult_Name + "')]"));
		return element;
	}
	
	public static WebElement txtWeightKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@class='form-control m-input keyResultWeightInput pdtl']"));
		return element;
	}
}
