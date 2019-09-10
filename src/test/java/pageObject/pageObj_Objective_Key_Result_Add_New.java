package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_Objective_Key_Result_Add_New {

	private static WebElement element = null;

	// ====================FGoal/ Objective view detail====================

	public static WebElement btnAddNewObj(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='btn-createObj']"));
		return element;
	}

	public static WebElement txtName(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='groups']/div[1]/div[1]/input"));
		return element;
	}

	public static WebElement txtWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='groups']/div[1]/div[2]/input"));
		return element;
	}

	public static WebElement btnAddObjective(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='groups']/div[2]/button[2]"));
		return element;
	}

	public static WebElement btDashboard(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
		return element;
	}

	public static WebElement linkObjectiveName(WebDriver driver, String ObjectiveName) {
		element = driver.findElement(By.xpath("//a[contains(text(),'" + ObjectiveName + "']"));
		return element;
	}

	public static WebElement lblObjectiveName(WebDriver driver, String ObjectiveName) {
		element = driver.findElement(By.xpath("//label[@class='col-form-label mt-n1 float-left label-obj']"+ ObjectiveName + "']"));
		return element;
	}
	
	public static WebElement bttAddNewKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@id='addNewKeyResult']"));
		return element;
	}

	public static WebElement popupAddNewKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='modal-dialog']"));
		return element;
	}

	public static WebElement popupheaderAddNewKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='modal-header']"));
		return element;
	}

	public static WebElement txtNameKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='newNameKeyResult']"));
		return element;
	}

	public static WebElement txtWeightKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='newWeightKeyResult']"));
		return element;
	}

	public static WebElement txttargetKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='newTargettKeyResult']"));
		return element;
	}

	public static WebElement dropdownUnitKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@id='select2-select_picker_unit-containerv'][@title='%']"));
		return element;
	}

	public static WebElement popupbttAddNewKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@id='addNewKeyResultSubmitBtn']"));
		return element;
	}

	public static WebElement msgErrorName(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[@id='newNameKeyResult-error']"));
		return element;
	}
	
	public static WebElement msgErrorTarget(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[@id='newNameKeyResult-error']"));
		return element;
	}
	
	public static WebElement linkNewKeyResult(WebDriver driver, String NewKeyResult) {
		element = driver.findElement(By.xpath("//*[@id=\"main-content\"][contains(text(),'" + NewKeyResult + "')]"));
		return element;
	}
}
