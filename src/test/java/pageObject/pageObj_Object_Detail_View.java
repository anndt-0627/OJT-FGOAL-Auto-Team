package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_Object_Detail_View {
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

	public static WebElement btDashboard(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
		return element;
	}

	public static WebElement linkObjectiveName(WebDriver driver, String objName) {
		element = driver.findElement(By.xpath("//a[contains(text(),'" + objName + "']"));
		return element;
	}

	// ====================FGoal/ Objective view detail====================

	public static WebElement lblObjectiveName(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[@class='col-form-label mt-n1 float-left label-obj']"));
		return element;
	}

	public static WebElement lblObjectiveQuater(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//span[@class='m-badge m-badge--outline-brand m-badge--wide p-2 f-15']"));
		return element;
	}

	public static WebElement actpercentObjectiveProgress(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='actual-top']"));
		return element;
	}

	public static WebElement sttObjectiveProgress(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='status_objective']"));
		return element;
	}

	public static WebElement actObjectProgress(WebDriver driver) {
		element = driver.findElement(By.xpath("//[@class ='form-control objectiveSliderInput m-w-100 text-right']"));
		return element;
	}

	public static WebElement lvObjectiveWeight(WebDriver driver, int ObjWeight) {
		element = driver
				.findElement(By.xpath("//[@class ='form-control m-input objectiveWeight pdtl','" + ObjWeight + "']"));
		return element;
	}
}
