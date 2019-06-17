package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_QuickActions_ChangeName {
	private static WebElement element = null;

	// ====================WSM====================
	public static WebElement btnWSM_Login(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[2]/div[3]/a"));
		return element;
	}

	public static WebElement txtWSM_Email(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='user_email']"));
		return element;
	}

	public static WebElement txtWSM_Pass(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='user_password']"));
		return element;
	}

	public static WebElement btnWSM_OK(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='devise-login-form']/div[4]/button"));
		return element;
	}

	// ====================FGoal====================

	public static WebElement btnLoginViaWSM(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='m_login']/div/div/div[2]/form/div[4]/a"));
		return element;
	}

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

	public static WebElement ObjectiveName(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[@class='col-form-label mt-n1 float-left label-obj']"));
		return element;
	}

	public static WebElement DB_ObjectiveName(WebDriver driver, String objName) {
		element = driver.findElement(By.xpath("//a[contains(text(),'" + objName + "')]"));
		return element;
	}

	// ====================FGoal/ Objective detail====================

	public static WebElement icoQuickActions(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@id='objective-comment-toggle']"));
		return element;
	}

	public static WebElement itmUpdateObjectiveTitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Update Objective title')]"));
		return element;
	}

	public static WebElement popupUpdateObjectiveTitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='changeNameObjective']"));
		return element;
	}

	public static WebElement popupUpdateObjectiveTitle_lblTitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='changeNameObjective']/div/div/div/h4"));
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
		element = driver.findElement(By.xpath("//*[@id='changeNameObjective']/div/div/form/div[1]/span[3]/input"));
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

}
