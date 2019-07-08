package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_Objective_QuickActions_Delete {
	private static WebElement element = null;

	// ====================FGoal/ Objective detail====================

	public static WebElement itmDelete(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Delete')]"));
		return element;
	}

	public static WebElement popupDeleteObjective_lblTitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//h4[contains(text(),'Delete objective')]"));
		return element;
	}

	public static WebElement popupDeleteObjective_msgConfirm(WebDriver driver, String objName) {
		element = driver
				.findElement(By.xpath("//h5[contains(text(),'Are you sure you want to delete " + objName + " ?')]"));
		return element;
	}

	public static WebElement popupDeleteObjective_btnClose(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//div[@class='modal fade show']//button[@class='btn btn-dark'][contains(text(),'Close')]"));
		return element;
	}

	public static WebElement popupDeleteObjective_btnDelete(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//div[@class='modal fade show']//button[@class='btn btn-danger pull-left prevent-multiClick'][contains(text(),'Delete')]"));
		return element;
	}

}
