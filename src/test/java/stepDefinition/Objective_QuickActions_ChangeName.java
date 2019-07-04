package stepDefinition;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
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

	@Given("^User navigates to Dashboard screen$")
	public void user_navigates_to_Dashboard_screen() {
		pageObj_Objective_QuickActions_ChangeName.menuDashboard(driver).click();
	}

	@When("^Create a new Objective with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void create_a_new_Objective_with_and(String objName, String objWeight) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_QuickActions_ChangeName.btnAddNewObj(driver));
		moveToElement(driver, pageObj_Objective_QuickActions_ChangeName.btnAddNewObj(driver));
		pageObj_Objective_QuickActions_ChangeName.btnAddNewObj(driver).click();

		pageObj_Objective_QuickActions_ChangeName.txtName(driver).sendKeys(objName);

		pageObj_Objective_QuickActions_ChangeName.txtWeight(driver).clear();
		pageObj_Objective_QuickActions_ChangeName.txtWeight(driver).sendKeys(objWeight);

		pageObj_Objective_QuickActions_ChangeName.btnAddObjective(driver).click();
	}

	@When("^User clicks on \"([^\"]*)\" item in My Objectives section$")
	public void user_clicks_on_item_in_My_Objectives_section(String objName) {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_QuickActions_ChangeName.DB_ObjectiveName(driver, objName));
		moveToElement(driver, pageObj_Objective_QuickActions_ChangeName.DB_ObjectiveName(driver, objName));
		pageObj_Objective_QuickActions_ChangeName.DB_ObjectiveName(driver, objName).click();
	}

	@When("^User clicks on the Quick Actions icon in Objective section$")
	public void user_clicks_on_the_Quick_Actions_icon_in_Objective_section() {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_QuickActions_ChangeName.icoQuickActions(driver));
		pageObj_Objective_QuickActions_ChangeName.icoQuickActions(driver).click();
	}

	@When("^User clicks on Update Objective title option in Quick Actions menu$")
	public void user_clicks_on_Update_Objective_title_option_in_Quick_Actions_menu() {
		moveToElement(driver, pageObj_Objective_QuickActions_ChangeName.itmUpdateObjectiveTitle(driver));
		pageObj_Objective_QuickActions_ChangeName.itmUpdateObjectiveTitle(driver).click();
	}

	@Then("^Update Objective title popup opens$")
	public void update_Objective_title_popup_opens() {
		visibilityOf(driver, 200, pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblTitle(driver));
		Assert.assertTrue(
				pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblTitle(driver).isDisplayed());
	}

	@Then("^Title of Update Objective title popup displays$")
	public void title_of_Update_Objective_title_popup_displays() {
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblTitle(driver));
		String actual_lblTitle = pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblTitle(driver)
				.getText();
		String expected_lblTitle = properties_value.getString("OBJ_NAME_lblTITLE");
		assertEquals(expected_lblTitle, actual_lblTitle);
	}

	@Then("^Name label and asterisk symbol displays in Update Objective title popup$")
	public void name_label_and_asterisk_symbol_displays_in_Update_Objective_title_popup() {
		String actual_lblName = pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblName(driver)
				.getText();
		String expected_lblName = properties_value.getString("OBJ_NAME_lblNAME");
		assertEquals(expected_lblName, actual_lblName);

		String actual_sybAsterisk = pageObj_Objective_QuickActions_ChangeName
				.popupUpdateObjectiveTitle_sybAsterisk(driver).getText();
		String expected_sybAsterisk = properties_value.getString("OBJ_sybASTERISK");
		assertEquals(expected_sybAsterisk, actual_sybAsterisk);
	}

	@Then("^Name textbox displays in Update Objective title popup$")
	public void name_textbox_displays_in_Update_Objective_title_popup() {
		Assert.assertTrue(
				pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver).isDisplayed());
	}

	@Then("^Close button displays in Update Objective title popup$")
	public void close_button_displays_in_Update_Objective_title_popup() {
		Assert.assertTrue(
				pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_btnClose(driver).isDisplayed());
	}

	@Then("^Update button displays in Update Objective title popup$")
	public void update_button_displays_in_Update_Objective_title_popup() {
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

	@Then("^The error message exist data displays$")
	public void the_error_message_exist_data_displays() {
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_ChangeName.msgError(driver));
		String actual_msgError = pageObj_Objective_QuickActions_ChangeName.msgError(driver).getText();
		String expected_msgError = properties_value.getString("OBJ_UPDATE_MSG_ERROR_EXISTED_NAME");
		assertEquals(expected_msgError, actual_msgError);
	}

	@When("^User clicks on Close button in Update Objective title popup$")
	public void user_clicks_on_Close_button_in_Update_Objective_title_popup() {
		pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_btnClose(driver).click();
		sleepOfThread(3000);
	}

}
