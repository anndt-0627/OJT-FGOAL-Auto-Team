package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_QuickActions_UpdateWeight {
	private static WebElement element = null;

	// ====================FGoal/ Objective detail====================

	public static WebElement itmUpdateWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Update weight')]"));
		return element;
	}

	public static WebElement popupUpdateWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='changeWeightObjective']"));
		return element;
	}

	public static WebElement popupUpdateWeight_lblTitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='changeWeightObjective']/div/div/div/h4"));
		return element;
	}

	public static WebElement popupUpdateWeight_lblWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='changeWeightObjective']/div/div/form/div[1]/span[1]/label"));
		return element;
	}

	public static WebElement popupUpdateWeight_sybAsterisk(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='changeWeightObjective']/div/div/form/div[1]/span[2]"));
		return element;
	}

	public static WebElement popupUpdateWeight_txtWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='changeWeightObjective']/div/div/form/div[1]/div[1]/input"));
		return element;
	}

	public static WebElement popupUpdateWeight_btnClose(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='changeWeightObjective']/div/div/form/div[2]/button[1]"));
		return element;
	}

	public static WebElement popupUpdateWeight_btnUpdate(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='changeWeightObjective']/div/div/form/div[2]/button[2]"));
		return element;
	}

	public static WebElement txtObjectiveWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='changeWeightObjective']//input[@name='weight']"));
		return element;
	}

	public static WebElement msgError(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
		return element;
	}

	public static WebElement popupUpdateWeight_msgError(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='weight-error']"));
		return element;
	}

}
