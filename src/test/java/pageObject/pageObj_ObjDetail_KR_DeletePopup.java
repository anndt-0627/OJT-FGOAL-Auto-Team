package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_ObjDetail_KR_DeletePopup {
	private static WebElement element = null;

	public static WebElement popupDeleteKR_lblTitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//h4[contains(text(),'Delete key result')]"));
		return element;
	}

	public static WebElement popupDeleteKR_msgConfirm(WebDriver driver, String krName) {
		element = driver
				.findElement(By.xpath("//h5[contains(text(),'Are you sure you want to delete " + krName + "?')]"));
		return element;
	}

	public static WebElement popupDeleteKR_btnClose(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//form[@id='deleteKeyResult']//button[@class='btn btn-dark'][contains(text(),'Close')]"));
		return element;
	}

	public static WebElement popupDeleteKR_btnDelete(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//form[@id='deleteKeyResult']//button[@class='btn btn-danger pull-left prevent-multiClick'][contains(text(),'Delete')]"));
		return element;
	}
	
	public static WebElement krName(WebDriver driver, String krName) {
		element = driver
				.findElement(By.xpath("//a[contains(text(),'" + krName + "')]"));
		return element;
	}
}