package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_Objective_QuickActions_ChangeName {
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

	public static WebElement icoQuickActions(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='col-1']//a[@id='objective-comment-toggle']"));
		return element;
	}

	public static WebElement itmUpdateObjectiveTitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Update Objective title')]"));
		return element;
	}

	public static WebElement popupUpdateObjectiveTitle_lblTitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//h4[contains(text(),'Update Objective title')]"));
		return element;
	}

	public static WebElement popupUpdateObjectiveTitle_lblName(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='changeNameObjective']//label[contains(text(),'Name')]"));
		return element;
	}

	public static WebElement popupUpdateObjectiveTitle_sybAsterisk(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//div[@id='changeNameObjective']//span[@class='inputRequired'][contains(text(),'*')]"));
		return element;
	}

	public static WebElement popupUpdateObjectiveTitle_txtName(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='changeNameObjective']//input[@name='name']"));
		return element;
	}

	public static WebElement popupUpdateObjectiveTitle_btnClose(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//div[@id='changeNameObjective']//button[@class='btn btn-dark'][contains(text(),'Close')]"));
		return element;
	}

	public static WebElement popupUpdateObjectiveTitle_btnUpdate(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//div[@id='changeNameObjective']//button[@class='btn btn-info pull-left'][contains(text(),'Update')]"));
		return element;
	}

	public static WebElement msgSuccess(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		return element;
	}

	public static WebElement lblObjectiveName(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[@class='col-form-label mt-n1 float-left label-obj']"));
		return element;
	}

	public static WebElement msgError(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
		return element;
	}
	
	public static WebElement popupUpdateObjectiveTitle_msgError(WebDriver driver) {
		element = driver.findElement(By.xpath("//span//label[@id='name-error']"));
		return element;
	}

}
