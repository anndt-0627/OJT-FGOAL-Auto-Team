package stepDefinition;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_Objective_QuickActions_UpdateWeight;
import utility.Common;

public class Objective_QuickActions_UpdateWeight extends Common {
	ResourceBundle properties_value = ResourceBundle.getBundle("dataObjective_QuickActions");
	private WebDriver driver;

	public Objective_QuickActions_UpdateWeight() {
		this.driver = Hooks.getDriver();
	}

	@When("^User performs to open Update weight popup$")
	public void user_performs_to_open_Update_weight_popup() {
		moveToElement(driver, pageObj_Objective_QuickActions_UpdateWeight.itmUpdateWeight(driver));
		pageObj_Objective_QuickActions_UpdateWeight.itmUpdateWeight(driver).click();
	}

	@Then("^Update weight popup opens$")
	public void update_weight_popup_opens() {
		// Title of Update weight popup displays
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_lblTitle(driver));
		String actual_lblTitle = pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_lblTitle(driver)
				.getText();
		String expected_lblTitle = properties_value.getString("OBJ_WEIGHT_TITLE");
		assertEquals(expected_lblTitle, actual_lblTitle);

		// Weight label and asterisk symbol displays
		String actual_lblWeight = pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_lblWeight(driver)
				.getText();
		String expected_lblWeight = properties_value.getString("OBJ_WEIGHT_WEIGHT");
		assertEquals(expected_lblWeight, actual_lblWeight);

		String actual_sybAsterisk = pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_sybAsterisk(driver)
				.getText();
		String expected_sybAsterisk = properties_value.getString("OBJ_ASTERISK");
		assertEquals(expected_sybAsterisk, actual_sybAsterisk);

		// Weight textbox displays
		Assert.assertTrue(
				pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_txtWeight(driver).isDisplayed());

		// Close button displays
		Assert.assertTrue(pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_btnClose(driver).isDisplayed());

		// Update button displays
		Assert.assertTrue(
				pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_btnUpdate(driver).isDisplayed());

	}

	@When("^User updates the data with value is \"([^\"]*)\" into Weight textbox$")
	public void user_updates_the_data_with_value_is_into_Weight_textbox(String valid_value) {
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_txtWeight(driver));
		pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_txtWeight(driver).clear();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='" + valid_value + "';",
				pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_txtWeight(driver));
	}

	@When("^User submits Update weight popup$")
	public void user_submits_Update_weight_popup() {
		pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_btnUpdate(driver).click();
		sleepOfThread(3000);
	}

	@Then("^Update weight popup closes$")
	public void update_weight_popup_closes() {
		Assert.assertFalse(
				pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_lblTitle(driver).isDisplayed());
	}

	@Then("^Objective Weight in Objective section is equal to \"([^\"]*)\"$")
	public void objective_Weight_in_Objective_section_is_equal_to(String expected_objWeight) {
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_UpdateWeight.txtObjectiveWeight(driver));
		String actual_txtObjectiveWeight = pageObj_Objective_QuickActions_UpdateWeight.txtObjectiveWeight(driver)
				.getAttribute("value");
		assertEquals(expected_objWeight, actual_txtObjectiveWeight);
	}

	@Then("^The invalid min or max value error message displays under Weight textbox$")
	public void the_invalid_min_or_max_value_error_message_displays_under_Weight_textbox() {
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_msgError(driver));
		String actual_msgError = pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_msgError(driver)
				.getText();
		String expected_msgError = properties_value.getString("OBJ_WEIGHT_MSG_ERROR_MINMAX");
		assertEquals(expected_msgError, actual_msgError);
	}

	@Then("^The invalid integer value error message displays under Weight textbox$")
	public void the_invalid_integer_value_error_message_displays_under_Weight_textbox() {
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_msgError(driver));
		String actual_msgError = pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_msgError(driver)
				.getText();
		String expected_msgError = properties_value.getString("OBJ_WEIGHT_MSG_ERROR_DIGIT");
		assertEquals(expected_msgError, actual_msgError);
	}

	@When("^User performs to close Update weight popup$")
	public void user_performs_to_close_Update_weight_popup() {
		pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_btnClose(driver).click();
		sleepOfThread(3000);
	}
}