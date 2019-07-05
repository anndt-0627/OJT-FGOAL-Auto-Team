package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_Objective_QuickActions_UpdateWeight {
	private static WebElement element = null;

	// ====================FGoal/ Objective detail====================

	public static WebElement itmUpdateWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Update weight')]"));
		return element;
	}

	public static WebElement popupUpdateWeight_lblTitle(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//div[@id='changeWeightObjective']//h4[@class='modal-title'][contains(text(),'Update weight')]"));
		return element;
	}

	public static WebElement popupUpdateWeight_lblWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='changeWeightObjective']//label[contains(text(),'Weight')]"));
		return element;
	}

	public static WebElement popupUpdateWeight_sybAsterisk(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//div[@id='changeWeightObjective']//span[@class='inputRequired'][contains(text(),'*')]"));
		return element;
	}

	public static WebElement popupUpdateWeight_txtWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='changeWeightObjective']//input[@name='weight']"));
		return element;
	}

	public static WebElement popupUpdateWeight_btnClose(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//div[@id='changeWeightObjective']//button[@class='btn btn-dark'][contains(text(),'Close')]"));
		return element;
	}

	public static WebElement popupUpdateWeight_btnUpdate(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//div[@id='changeWeightObjective']//button[@class='btn btn-info pull-left'][contains(text(),'Update')]"));
		return element;
	}

	public static WebElement txtObjectiveWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@class='form-control m-input objectiveWeight pdtl']"));
		return element;
	}

	public static WebElement popupUpdateWeight_msgError(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='weight-error']"));
		return element;
	}

}
