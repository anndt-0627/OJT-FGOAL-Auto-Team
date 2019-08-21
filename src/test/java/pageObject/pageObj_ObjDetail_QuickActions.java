package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_ObjDetail_QuickActions {
	private static WebElement element = null;

	// =====Left Menu=====

	public static WebElement menuDashboard(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
		return element;
	}

	public static WebElement menuMyGroups(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//a[@class='m-menu__link m-menu__toggle']//span[@class='m-menu__link-text'][contains(text(),'My Groups')]"));
		return element;
	}

	public static WebElement menuMyGroups_Group(WebDriver driver, String group) {
		element = driver.findElement(By.xpath("//span[@class='m-menu__link-text'][contains(text(),'" + group + "')]"));
		return element;
	}

	// =====Dashboard=====

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

	// =====Objective detail=====

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

	public static WebElement itmUpdateWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Update weight')]"));
		return element;
	}

	public static WebElement itmDelete(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Delete')]"));
		return element;
	}

	public static WebElement itmLinkObjectives(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Link objectives')]"));
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

	// =====Popup Update Objective Title=====

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

	// =====Popup Update Weight=====
	
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

	// =====Popup Delete Objective=====
	
	public static WebElement popupDeleteObjective_lblTitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//h4[contains(text(),'Delete objective')]"));
		return element;
	}

	public static WebElement popupDeleteObjective_msgConfirm(WebDriver driver, String objName) {
		element = driver
				.findElement(By.xpath("//h5[contains(text(),'Are you sure you want to delete " + objName + " ?')]"));
		return element;
	}

	public static WebElement popupDeleteObjective_btnClose(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//div[@class='modal fade show']//button[@class='btn btn-dark'][contains(text(),'Close')]"));
		return element;
	}

	public static WebElement popupDeleteObjective_btnDelete(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//div[@class='modal fade show']//button[@class='btn btn-danger pull-left prevent-multiClick'][contains(text(),'Delete')]"));
		return element;
	}

	// =====Popup Link To Key Result=====

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

	// =====Popup Add new Key Result=====

	public static WebElement popupAddKeyResult_txtName(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='newNameKeyResult']"));
		return element;
	}

	public static WebElement popupAddKeyResult_btnAdd(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@id='addNewKeyResultSubmitBtn']"));
		return element;
	}
	
	public static WebElement popupAddKeyResult_txtWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='newWeightKeyResult']"));
		return element;
	}
	
	public static WebElement popupAddKeyResult_txtTarget(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='newTargettKeyResult']"));
		return element;
	}

	// =====Popup Link to Key Result successfully=====

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