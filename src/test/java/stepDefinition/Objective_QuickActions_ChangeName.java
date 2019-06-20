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
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_ChangeName.btnAddNewObj(driver));
		moveToElement(driver, pageObj_Objective_QuickActions_ChangeName.btnAddNewObj(driver));
		pageObj_Objective_QuickActions_ChangeName.btnAddNewObj(driver).click();

		pageObj_Objective_QuickActions_ChangeName.txtName(driver).clear();
		pageObj_Objective_QuickActions_ChangeName.txtName(driver).sendKeys(objName);

		pageObj_Objective_QuickActions_ChangeName.txtWeight(driver).clear();
		pageObj_Objective_QuickActions_ChangeName.txtWeight(driver).sendKeys(objWeight);

		pageObj_Objective_QuickActions_ChangeName.btnAddObjective(driver).click();
	}

	@When("^User clicks on \"([^\"]*)\" item in My Objectives section$")
	public void user_clicks_on_item_in_My_Objectives_section(String objName) {
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_ChangeName.DB_ObjectiveName(driver, objName));
		moveToElement(driver, pageObj_Objective_QuickActions_ChangeName.DB_ObjectiveName(driver, objName));
		pageObj_Objective_QuickActions_ChangeName.DB_ObjectiveName(driver, objName).click();
	}

	@When("^User clicks on the Quick Actions icon in Objective section$")
	public void user_clicks_on_the_Quick_Actions_icon_in_Objective_section() {
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_ChangeName.icoQuickActions(driver));
		moveToElement(driver, pageObj_Objective_QuickActions_ChangeName.icoQuickActions(driver));
		pageObj_Objective_QuickActions_ChangeName.icoQuickActions(driver).click();
	}

	@When("^User clicks on Update Objective title option in Quick Actions menu$")
	public void user_clicks_on_Update_Objective_title_option_in_Quick_Actions_menu() {
		moveToElement(driver, pageObj_Objective_QuickActions_ChangeName.itmUpdateObjectiveTitle(driver));
		pageObj_Objective_QuickActions_ChangeName.itmUpdateObjectiveTitle(driver).click();
	}

	@Then("^Update Objective title popup opens$")
	public void update_Objective_title_popup_opens() {
		visibilityOf(driver, 2000,
				pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblTitle(driver));
		Assert.assertTrue(
				pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblTitle(driver).isDisplayed());
	}

	@Then("^Title of Update Objective title popup displays$")
	public void title_of_Update_Objective_title_popup_displays() {
		visibilityOf(driver, 2000,
				pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblTitle(driver));
		String text = pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblTitle(driver).getText();
		assertEquals(properties_value.getString("popupUpdateObjectiveTitle_lblTitle"), text);
	}

	@Then("^Name label and asterisk symbol displays in Update Objective title popup$")
	public void name_label_and_asterisk_symbol_displays_in_Update_Objective_title_popup() {
		String text = pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblName(driver).getText();
		assertEquals(properties_value.getString("popupUpdateObjectiveTitle_lblName"), text);
		String asterisk = pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_sybAsterisk(driver)
				.getText();
		assertEquals(properties_value.getString("symAsterisk"), asterisk);
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
	public void the_value_in_Name_textbox_is_equal_to(String objName) {
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver));
		String text = pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver)
				.getAttribute("value");
		assertEquals(objName, text);
	}

	@When("^User updates the data with value is \"([^\"]*)\" into Name textbox$")
	public void user_updates_the_data_with_value_is_into_Name_textbox(String valid_value) {
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver));
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

	@Then("^Success message displays$")
	public void success_message_displays() {
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_ChangeName.msgSuccess(driver));
		String text = pageObj_Objective_QuickActions_ChangeName.msgSuccess(driver).getText();
		assertEquals(properties_value.getString("msgSuccess"), text);
	}

	@Then("^Objective Name in Objective section is equal to \"([^\"]*)\"$")
	public void objective_Name_in_Objective_section_is_equal_to(String valid_value) {
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_ChangeName.lblObjectiveName(driver));
		String text = pageObj_Objective_QuickActions_ChangeName.lblObjectiveName(driver).getText();
		assertEquals(valid_value, text);
	}

	@Then("^The error_message displays$")
	public void the_error_message_displays() {
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_ChangeName.msgError(driver));
		String text = pageObj_Objective_QuickActions_ChangeName.msgError(driver).getText();
		assertEquals(properties_value.getString("msgError_UpdateObjectiveTitle"), text);
	}

	@When("^User clicks on Close button in Update Objective title popup$")
	public void user_clicks_on_Close_button_in_Update_Objective_title_popup() {
		pageObj_Objective_QuickActions_ChangeName.popupUpdateObjectiveTitle_btnClose(driver).click();
		sleepOfThread(3000);
	}

}
