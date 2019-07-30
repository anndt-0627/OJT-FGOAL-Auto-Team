package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_Objective_QuickActions_LinkObjectives {
	private static WebElement element = null;

	public static WebElement itmLinkObjectives(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Link objectives')]"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_lblTitle(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//div[@id='link_to_key_result_Obj']//h5[@class='modal-title'][contains(text(),'Link to Key Result')]"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_icoClose(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='link_to_key_result_Obj']//button[@class='close']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_lblGroup(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//div[@id='m_wizard_form_step_1']//label[@class='col-lg-2 col-sm-12 pl-0 font-weight-bold'][contains(text(),'Group')]"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_ddlGroup(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='m_wizard_form_step_1']//div[@class='filter-option-inner']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_ddlGroup_mennu(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='dropdown-menu show']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_ddlGroup_txtSearch(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@placeholder='Search group name']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_btnNext_SelectGroup(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@id='nextToStep2']//span//span[contains(text(),'Next')]"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_msgError_SelectGroup(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class='text-danger']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_lblObjectives(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[contains(text(),'Objectives')]"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_msgNoObjectiveInGroup(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class='m-2 pl-4']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_lstObjective(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='m_wizard_form_step_2']//div[@id='select_objective_cover']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_btnBack_SelectObjective(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//a[@class='btn btn-secondary m-btn m-btn--custom m-btn--icon prevLinkObj']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_btnNext_SelectObjective(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@id='nextToStep2']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_msgError_SelectObjective(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[@id='select_objective-error']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_radioObjective(WebDriver driver, String objName) {
		element = driver.findElement(
				By.xpath("//div[@id='m_wizard_form_step_2']//span[@class='m-option__title'][contains(text(),'" + objName
						+ "')]"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_lblKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[contains(text(),'Key Result')]"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_ddlKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[contains(text(),'Select Key result from objective')]"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_ddlKeyResult_mennu(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='dropdown-menu show']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_msgError_SelectKeyRessult(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[@id='select_key_result_cover-error']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_btnSelectAll_SelectKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='actions-btn bs-select-all btn btn-light']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_btnDeselectAll_SelectKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='actions-btn bs-deselect-all btn btn-light']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_krName_SelectKeyResult(WebDriver driver, String krName) {
		element = driver.findElement(By.xpath("//span[contains(text(),'" + krName + "')]"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_ddlKeyResult_Selected(WebDriver driver, String krName) {
		element = driver.findElement(By.xpath("//div[contains(text(),'" + krName + "')]"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_ddlKeyResult_multiSelected(WebDriver driver, String krName1,
			String krName2) {
		element = driver.findElement(By.xpath("//div[contains(text(),'" + krName1 + ", " + krName2 + "')]"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_btnBack_SelectKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//a[@class='btn btn-secondary m-btn m-btn--custom m-btn--icon prevLinkObj']//span//span[contains(text(),'Back')]"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_btnSubmit_SelectKeyResult(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//a[@id='submit_link_to_key_result']//span//span[contains(text(),'Submit')]"));
		return element;
	}

	// ====================FGoal/ Objective detail====================

	public static WebElement menuMyGroups(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//a[@class='m-menu__link m-menu__toggle']//span[@class='m-menu__link-text'][contains(text(),'My Groups')]"));
		return element;
	}

	public static WebElement menuMyGroups_Group(WebDriver driver, String group) {
		element = driver.findElement(By.xpath("//span[@class='m-menu__link-text'][contains(text(),'" + group + "')]"));
		return element;
	}

	public static WebElement btnAddKeyResult(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@id='addNewKeyResult']"));
		return element;
	}

	public static WebElement KeyResultName(WebDriver driver, String krName) {
		element = driver.findElement(By.xpath("//a[contains(text(),'" + krName + "')]"));
		return element;
	}

	// ====================FGoal/ Objective detail/ popup Add new Key
	// Result====================

	public static WebElement popupAddKeyResult_txtName(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='newNameKeyResult']"));
		return element;
	}

	public static WebElement popupAddKeyResult_btnAdd(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@id='addNewKeyResultSubmitBtn']"));
		return element;
	}

	// ====================FGoal/ Objective detail/ Link to Key Result
	// successfully popup====================
	public static WebElement popupLinkToKeyResult_SuccessRing(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='swal2-success-ring']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_msgRequestSent(WebDriver driver) {
		element = driver.findElement(By.xpath("//h2[@id='swal2-title']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_msgWaitFor(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='swal2-content']"));
		return element;
	}

	public static WebElement popupLinkToKeyResult_btnOK(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//button[@class='swal2-confirm btn btn-secondary m-btn m-btn--wide swal2-styled']"));
		return element;
	}

}
