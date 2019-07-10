package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_ObjectDetails_View {
	private static WebElement element = null;

	public static WebElement menuDashboard(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
		return element;
	}

	public static WebElement btnAddNewObj(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='btn-createObj']"));
		return element;
	}

	public static WebElement txtName(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='name']"));
		return element;
	}

	public static WebElement txtWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='weight']"));
		return element;
	}

	public static WebElement btnAddObjective(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='btn btn-info pull-right prevent-multiClick']"));
		return element;
	}

	public static WebElement DB_ObjectiveName(WebDriver driver, String objName) {
		element = driver.findElement(By.xpath("//a[contains(text(),'" + objName + "')]"));
		return element;
	}

	// ====================FGoal/ Objective detail====================

	public static WebElement ObjectiveName(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[@class='col-form-label mt-n1 float-left label-obj']"));
		return element;
	}
	
	public static WebElement ObjectiveQuater(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class='m-badge m-badge--outline-brand m-badge--wide p-2 f-15']"));
		return element;
	}
	
	public static WebElement ObjectiveStatus(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class='m-badge m-badge--wide m--font-boldest p-3 ml-5' and @id='status_objective']"));
		return element;
	}
	
	public static WebElement ObjectiveCurentProgress(WebDriver driver) {
		element = driver.findElement(By.xpath("//b[@id='actual-top']"));
		return element;
	}
	
	public static WebElement ObjectiveWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@class='form-control m-input objectiveWeight pdtl']"));
		return element;
	}
}