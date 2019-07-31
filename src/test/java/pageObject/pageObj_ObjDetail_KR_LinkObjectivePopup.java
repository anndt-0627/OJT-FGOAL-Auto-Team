package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_ObjDetail_KR_LinkObjectivePopup {
	private static WebElement element = null;

	public static WebElement objDetail_LinkTo_KRName(WebDriver driver, String krName) {
		element = driver.findElement(By.xpath("//label[contains(text(),'" + krName + "')]"));
		return element;
	}

	public static WebElement popupQuickAct_itmLinkObj(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Link objectives into this key result')]"));
		return element;
	}

	public static WebElement popupLinkObj_title(WebDriver driver, String krName) {
		element = driver.findElement(
				By.xpath("//h5[contains(text(),'Select Objective to link with Key Result: " + krName + "')]"));
		return element;
	}

	public static WebElement popupLinkObj_icoClose(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='link_to_key_result_kr']//button[@class='close']"));
		return element;
	}

	public static WebElement popupLinkObj_lblGroup(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//div[@id='m_wizard_form_step_1_kr']//label[@class='col-lg-2 col-sm-12 pl-0 font-weight-bold'][contains(text(),'Group')]"));
		return element;
	}

	public static WebElement popupLinkObj_drdGroup(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//div[@id='m_wizard_form_step_1_kr']//div[@class='filter-option-inner']"));
		return element;
	}

	public static WebElement popupLinkObj_btnNext(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//div[@class='m-form__actions p-4']//a[@class='btn btn-warning m-btn m-btn--custom m-btn--icon']"));
		return element;
	}

	public static WebElement popupLinkObj_optGroup(WebDriver driver, String groupName) {
		element = driver.findElement(By
				.xpath("//div[@class='dropdown-menu show']//span[@class='m-badge m-badge--info m-badge--wide m-badge--rounded'][contains(text(),'"
						+ groupName + "')]"));
		return element;
	}

	public static WebElement popupLinkObj_lblNoObjective(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class='m-2 pl-4']"));
		return element;
	}

	public static WebElement popupLinkObj_tabChooseObjective(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class='nav-link m-tabs__link active show']"));
		return element;
	}

	public static WebElement popupLinkObj_tabAddNewObjective(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class='nav-link m-tabs__link']"));
		return element;
	}

	public static WebElement popupLinkObj_lstObjective(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='chooseObj']//div[@id='select_objective_cover']"));
		return element;
	}

	public static WebElement popupLinkObj_btnBack(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class='btn btn-secondary m-btn m-btn--custom m-btn--icon']"));
		return element;
	}

	public static WebElement popupLinkObj_btnSubmit(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@id='submit_link_to_key_result_kr']"));
		return element;
	}

	public static WebElement popupLinkObj_ckbObjevtive(WebDriver driver, String desObj) {
		element = driver.findElement(
				By.xpath("//div[@id='chooseObj']//span[@class='m-option__title'][contains(text(),'" + desObj + "')]"));
		return element;
	}

	public static WebElement popupLinkObj_txtObjectiveName(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='nameObj']"));
		return element;
	}

	// =====Link Objective successfully popup=====

	public static WebElement popupLinkObj_SuccessRing(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='swal2-success-ring']"));
		return element;
	}

	public static WebElement popupLinkObj_btnOK(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//button[@class='swal2-confirm btn btn-secondary m-btn m-btn--wide swal2-styled']"));
		return element;
	}

	// =====Link Objective failed popup=====
	public static WebElement popupLinkObj_FailedRing(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class='swal2-x-mark']"));
		return element;
	}

	public static WebElement popupLinkObj_RequestFailed_btnOK(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//button[@class='swal2-confirm btn btn-warning m-btn m-btn--wide swal2-styled']"));
		return element;
	}
}