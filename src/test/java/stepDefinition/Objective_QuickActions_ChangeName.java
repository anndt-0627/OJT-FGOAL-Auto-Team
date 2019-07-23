package stepDefinition;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_Objective_QuickActions_ChangeName;
import utility.Common;

public class Objective_QuickActions_ChangeName extends Common {
	ResourceBundle properties_value = ResourceBundle.getBundle("dataObjective_QuickActions");
	private WebDriver driver;

	public Objective_QuickActions_ChangeName() {
		this.driver = Hooks.getDriver();
	}

	@When("^User navigates to Objective \"([^\"]*)\"$")
	public void user_navigates_to_Objective(String objName) {
		// If the Objective is existed then go to Objective details screen
		// If the Objective does not exist then creating this Objective
		try {
			Assert.assertTrue(
					pageObj_Objective_QuickActions_ChangeName.DB_ObjectiveName(driver, objName).isDisplayed());
			moveToElement(driver, pageObj_Objective_QuickActions_ChangeName.DB_ObjectiveName(driver, objName));
			pageObj_Objective_QuickActions_ChangeName.DB_ObjectiveName(driver, objName).click();
		} catch (NoSuchElementException e) {
			create_a_new_Objective(objName);
		}
	}

	@When("^User opens Quick Actions popup of Objective$")
	public void user_opens_Quick_Actions_popup_of_Objective() {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_QuickActions_ChangeName.icoQuickActions(driver));
		pageObj_Objective_QuickActions_ChangeName.icoQuickActions(driver).click();
	}

	@When("^User performs to open Update Objective title popup$")
	public void user_performs_to_open_Update_Objective_title_popup() {
		moveToElement(driver, pageObj_Objective_QuickActions_ChangeName.itmUpdateObjectiveTitle(driver));
		pageObj_Objective_QuickActions_ChangeName.itmUpdateObjectiveTitle(driver).click();
	}

	@Then("^Update Objective title popup opens$")
	public void update_Objective_title_popup_opens() {
		// Title of Update Objective title popup displays
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblTitle(driver));
		String actual_lblTitle = pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblTitle(driver)
				.getText();
		String expected_lblTitle = properties_value.getString("OBJ_NAME_TITLE");
		assertEquals(expected_lblTitle, actual_lblTitle);

		// Name label and asterisk symbol displays
		String actual_lblName = pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblName(driver)
				.getText();
		String expected_lblName = properties_value.getString("OBJ_NAME_NAME");
		assertEquals(expected_lblName, actual_lblName);

		String actual_sybAsterisk = pageObj_Objective_QuickActions_ChangeName
				.popupUpdateObjectiveTitle_sybAsterisk(driver).getText();
		String expected_sybAsterisk = properties_value.getString("OBJ_ASTERISK");
		assertEquals(expected_sybAsterisk, actual_sybAsterisk);

		// Name textbox displays
		Assert.assertTrue(
				pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver).isDisplayed());

		// Close button displays
		Assert.assertTrue(
				pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_btnClose(driver).isDisplayed());

		// Update button displays
		Assert.assertTrue(
				pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_btnUpdate(driver).isDisplayed());
	}

	@Then("^The value in Name textbox is equal to \"([^\"]*)\"$")
	public void the_value_in_Name_textbox_is_equal_to(String expected_objName) {
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver));
		String actual_txtName = pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver)
				.getAttribute("value");
		assertEquals(expected_objName, actual_txtName);
	}

	@When("^User updates the data with value is \"([^\"]*)\" into Name textbox$")
	public void user_updates_the_data_with_value_is_into_Name_textbox(String valid_value) {
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver));
		pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver).clear();
		pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver).sendKeys(valid_value);
	}

	@When("^User submits Update Objective title popup$")
	public void user_submits_Update_Objective_title_popup() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_btnUpdate(driver));
		pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_btnUpdate(driver).click();
	}

	@Then("^Update Objective title popup closes$")
	public void update_Objective_title_popup_closes() {
		Assert.assertFalse(
				pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblTitle(driver).isDisplayed());
	}

	@Then("^Success objective update message displays$")
	public void success_objective_update_message_displays() {
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_ChangeName.msgSuccess(driver));
		String text = pageObj_Objective_QuickActions_ChangeName.msgSuccess(driver).getText();
		assertEquals(properties_value.getString("OBJ_UPDATE_MSG_SUCCESS"), text);
	}

	@Then("^Objective Name in Objective section is equal to \"([^\"]*)\"$")
	public void objective_Name_in_Objective_section_is_equal_to(String valid_value) {
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_ChangeName.lblObjectiveName(driver));
		String actual_lblObjectiveName = pageObj_Objective_QuickActions_ChangeName.lblObjectiveName(driver).getText();
		assertEquals(valid_value, actual_lblObjectiveName);
	}

	@When("^User removes data in Name textbox$")
	public void user_removes_data_in_Name_textbox() {
		pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver).clear();
	}

	@Then("^The error message required data displays$")
	public void the_error_message_required_data_displays() {
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_msgError(driver));
		String actual_msgError = pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_msgError(driver)
				.getText();
		String expected_msgError = properties_value.getString("OBJ_UPDATE_MSG_ERROR_REQUIRED_NAME");
		assertEquals(expected_msgError, actual_msgError);
	}

	@Then("^The error message existed data displays$")
	public void the_error_message_existed_data_displays() {
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_ChangeName.msgError(driver));
		String actual_msgError = pageObj_Objective_QuickActions_ChangeName.msgError(driver).getText();
		String expected_msgError = properties_value.getString("OBJ_UPDATE_MSG_ERROR_EXISTED_NAME");
		assertEquals(expected_msgError, actual_msgError);
	}

	@When("^Checking the existence or creating Objective \"([^\"]*)\"$")
	public void checking_the_existence_or_creating_Objective(String existedObjName) {
		// If the Objective is existed then do nothing
		// If the Objective does not exist then creating this Objective and back to Dashboard screen
		try {
			Assert.assertTrue(
					pageObj_Objective_QuickActions_ChangeName.DB_ObjectiveName(driver, existedObjName).isDisplayed());
		} catch (NoSuchElementException e) {
			create_a_new_Objective(existedObjName);
			pageObj_Objective_QuickActions_ChangeName.menuDashboard(driver).click();
		}
	}

	@When("^User performs to close Update Objective title popup$")
	public void user_performs_to_close_Update_Objective_title_popup() {
		pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_btnClose(driver).click();
		sleepOfThread(3000);
	}

	public void create_a_new_Objective(String objName) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_QuickActions_ChangeName.btnAddNewObj(driver));
		moveToElement(driver, pageObj_Objective_QuickActions_ChangeName.btnAddNewObj(driver));
		pageObj_Objective_QuickActions_ChangeName.btnAddNewObj(driver).click();

		pageObj_Objective_QuickActions_ChangeName.txtName(driver).sendKeys(objName);

		pageObj_Objective_QuickActions_ChangeName.btnAddObjective(driver).click();
		sleepOfThread(3000);
	}
}