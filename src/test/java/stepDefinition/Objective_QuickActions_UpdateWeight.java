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
	ResourceBundle properties_value= ResourceBundle.getBundle("dataObjective_QuickActions");
	private WebDriver driver;

	public Objective_QuickActions_UpdateWeight() {
		this.driver = Hooks.getDriver();
	}

	@When("^User clicks on Update weight option in Quick Actions menu$")
	public void user_clicks_on_Update_weight_option_in_Quick_Actions_menu() {
		moveToElement(driver, pageObj_Objective_QuickActions_UpdateWeight.itmUpdateWeight(driver));
		pageObj_Objective_QuickActions_UpdateWeight.itmUpdateWeight(driver).click();
	}

	@Then("^Update weight popup opens$")
	public void update_weight_popup_opens() {
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_lblTitle(driver));
		Assert.assertTrue(pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_lblTitle(driver).isDisplayed());
	}

	@Then("^Title of Update weight popup displays$")
	public void title_of_Update_weight_popup_displays() {
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_lblTitle(driver));
		String text = pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_lblTitle(driver).getText();
		assertEquals(properties_value.getString("popupUpdateWeight_lblTitle"), text);
	}

	@Then("^Weight label and asterisk symbol displays in Update weight popup$")
	public void weight_label_and_asterisk_symbol_displays_in_Update_weight_popup() {
		String text = pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_lblWeight(driver).getText();
		assertEquals(properties_value.getString("popupUpdateWeight_lblWeight"), text);
		String asterisk = pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_sybAsterisk(driver).getText();
		assertEquals(properties_value.getString("symAsterisk"), asterisk);
	}

	@Then("^Weight textbox displays in Update weight popup$")
	public void weight_textbox_displays_in_Update_weight_popup() {
		Assert.assertTrue(
				pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_txtWeight(driver).isDisplayed());
	}

	@Then("^Close button displays in Update weight popup$")
	public void close_button_displays_in_Update_weight_popup() {
		Assert.assertTrue(pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_btnClose(driver).isDisplayed());
	}

	@Then("^Update button displays in Update weight popup$")
	public void update_button_displays_in_Update_weight_popup() {
		Assert.assertTrue(
				pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_btnUpdate(driver).isDisplayed());
	}

	@Then("^The value in Weight textbox is equal to \"([^\"]*)\"$")
	public void the_value_in_Weight_textbox_is_equal_to(String objWeight) {
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_txtWeight(driver));
		String text = pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_txtWeight(driver)
				.getAttribute("value");
		assertEquals(objWeight, text);
	}

	@When("^User updates the data with value is \"([^\"]*)\" into Weight textbox$")
	public void user_updates_the_data_with_value_is_into_Weight_textbox(String valid_value) {
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_txtWeight(driver));
		pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_txtWeight(driver).clear();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='" + valid_value + "';",
				pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_txtWeight(driver));
	}

	@When("^User submits Update weight popup$")
	public void user_submits_Update_weight_popup() {
		pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_btnUpdate(driver).click();
	}

	@Then("^Update weight popup closes$")
	public void update_weight_popup_closes() {
			Assert.assertFalse(
					pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_lblTitle(driver).isDisplayed());
	}

	@Then("^Objective Weight in Objective section is equal to \"([^\"]*)\"$")
	public void objective_Weight_in_Objective_section_is_equal_to(String valid_value) {
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_UpdateWeight.txtObjectiveWeight(driver));
		String number = pageObj_Objective_QuickActions_UpdateWeight.txtObjectiveWeight(driver).getAttribute("value");
		assertEquals(valid_value, number);
	}
	
	@Then("^The invalid min or max value error message displays under Weight textbox$")
	public void the_invalid_min_or_max_value_error_message_displays_under_Weight_textbox() {
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_msgError(driver));
		String text = pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_msgError(driver).getText();
		assertEquals(properties_value.getString("popupUpdateWeight_msgError_MinMax"), text);
	}

	@Then("^The invalid integer value error message displays under Weight textbox$")
	public void the_invalid_integer_value_error_message_displays_under_Weight_textbox() {
		visibilityOf(driver, 2000, pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_msgError(driver));
		String text = pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_msgError(driver).getText();
		assertEquals(properties_value.getString("popupUpdateWeight_msgError_Digit"), text);
	}

	@When("^User clicks on Close button in Update weight popup$")
	public void user_clicks_on_Close_button_in_Update_weight_popup() {
		pageObj_Objective_QuickActions_UpdateWeight.popupUpdateWeight_btnClose(driver).click();
		sleepOfThread(3000);
	}
}
