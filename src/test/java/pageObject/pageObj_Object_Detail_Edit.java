package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_Object_Detail_Edit {
	private static WebElement element = null;

	public static WebElement menuDashboard(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
		return element;
	}

	// ====================FGoal/ Objective detail edit====================

	public static WebElement ObjectiveName(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[@class='col-form-label mt-n1 float-left label-obj']"));
		return element;
	}

	
	public static WebElement ObjectiveStatus(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//span[@class='m-badge m-badge--wide m--font-boldest p-3 ml-5' and @id='status_objective']"));
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

	public static WebElement ObjectiveConfigure(WebDriver driver) {
		element = driver.findElement(By.xpath("//i[@class='fa fa-cog']"));
		return element;
	}

	public static WebElement ObjectiveUpdateManual(WebDriver driver) {
		element = driver.findElement(By.xpath("//p[@class='Update progress manually:']"));
		return element;
	}

	public static WebElement ObjectiveActualValue(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='actualValue']"));
		return element;
	}

	public static WebElement ObjectivePercent(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//input[@class='class='form-control objectiveSliderInput m-w-100 text-right']"));
		return element;
	}

	public static WebElement ObjectiveButtonUpdate(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//button[@class='btn btn-info pull-left btn-setMethod' and @id='btn-methodCalActualObj']"));
		return element;
	}
	
	public static WebElement ObjectiveButtonUpdateWeight(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//button[@class='btn btn-info pull-left']"));
		return element;
	}
	
	public static WebElement sttObjectiveProgress(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='status_objective']"));
		return element;
	}
}
