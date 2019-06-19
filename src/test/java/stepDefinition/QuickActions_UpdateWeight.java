package stepDefinition;

import static org.testng.AssertJUnit.assertEquals;

import java.util.ResourceBundle;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_QuickActions_UpdateWeight;

public class QuickActions_UpdateWeight {
	ResourceBundle properties_value;
	private WebDriver driver;

	public QuickActions_UpdateWeight() {
		this.driver = Hooks.getDriver();
	}

	@When("^User clicks on Update weight option in Quick Actions menu$")
	public void user_clicks_on_Update_weight_option_in_Quick_Actions_menu() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", pageObj_QuickActions_UpdateWeight.itmUpdateWeight(driver));
	}

	@Then("^Update weight popup opens$")
	public void update_weight_popup_opens() throws InterruptedException {
		Thread.sleep(2000);
		String text = pageObj_QuickActions_UpdateWeight.popupUpdateWeight(driver).getAttribute("style");
		assertEquals("padding-right: 17px; display: block;", text);
	}

	@Then("^Title of Update weight popup displays$")
	public void title_of_Update_weight_popup_displays() throws InterruptedException {
		Thread.sleep(2000);
		String text = pageObj_QuickActions_UpdateWeight.popupUpdateWeight_lblTitle(driver).getText();
		assertEquals("Update weight", text);
	}

	@Then("^Weight label and asterisk symbol displays in Update weight popup$")
	public void weight_label_and_asterisk_symbol_displays_in_Update_weight_popup() {
		String text = pageObj_QuickActions_UpdateWeight.popupUpdateWeight_lblWeight(driver).getText();
		assertEquals("Weight", text);
		String asterisk = pageObj_QuickActions_UpdateWeight.popupUpdateWeight_sybAsterisk(driver).getText();
		assertEquals("*", asterisk);
	}

	@Then("^Weight textbox displays in Update weight popup$")
	public void weight_textbox_displays_in_Update_weight_popup() {
		pageObj_QuickActions_UpdateWeight.popupUpdateWeight_txtWeight(driver).isDisplayed();
	}

	@Then("^Close button displays in Update weight popup$")
	public void close_button_displays_in_Update_weight_popup() {
		pageObj_QuickActions_UpdateWeight.popupUpdateWeight_btnClose(driver).isDisplayed();
	}

	@Then("^Update button displays in Update weight popup$")
	public void update_button_displays_in_Update_weight_popup() {
		pageObj_QuickActions_UpdateWeight.popupUpdateWeight_btnUpdate(driver).isDisplayed();
	}

	@Then("^The value in Weight textbox is equal to \"([^\"]*)\"$")
	public void the_value_in_Weight_textbox_is_equal_to(String objWeight) throws InterruptedException {
		Thread.sleep(2000);
		String text = pageObj_QuickActions_UpdateWeight.popupUpdateWeight_txtWeight(driver).getAttribute("value");
		assertEquals(objWeight, text);
	}

	@When("^User updates the data with value is \"([^\"]*)\" into Weight textbox$")
	public void user_updates_the_data_with_value_is_into_Weight_textbox(String valid_value)
			throws InterruptedException {
		Thread.sleep(2000);
		pageObj_QuickActions_UpdateWeight.popupUpdateWeight_txtWeight(driver).clear();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='" + valid_value + "';",
				pageObj_QuickActions_UpdateWeight.popupUpdateWeight_txtWeight(driver));
	}

	@When("^User submits Update weight popup$")
	public void user_submits_Update_weight_popup() throws InterruptedException {
		pageObj_QuickActions_UpdateWeight.popupUpdateWeight_btnUpdate(driver).click();
		Thread.sleep(2000);
	}

	@Then("^Update weight popup closes$")
	public void update_weight_popup_closes() throws InterruptedException {
		Thread.sleep(2000);
		String text = pageObj_QuickActions_UpdateWeight.popupUpdateWeight(driver).getAttribute("aria-hidden");
		assertEquals("true", text);
	}

	@Then("^Objective Weight in Objective section is equal to \"([^\"]*)\"$")
	public void objective_Weight_in_Objective_section_is_equal_to(String valid_value) throws InterruptedException {
		Thread.sleep(2000);
		String number = pageObj_QuickActions_UpdateWeight.txtObjectiveWeight(driver).getAttribute("value");
		assertEquals(valid_value, number);
	}

	@Then("^The \"([^\"]*)\" displays under Weight textbox$")
	public void the_displays_under_Weight_textbox(String error_message) throws InterruptedException {
		Thread.sleep(2000);
		String text = pageObj_QuickActions_UpdateWeight.popupUpdateWeight_msgError(driver).getText();
		assertEquals(error_message, text);
	}

	@When("^User clicks on Close button in Update weight popup$")
	public void user_clicks_on_Close_button_in_Update_weight_popup() {
		pageObj_QuickActions_UpdateWeight.popupUpdateWeight_btnClose(driver).click();
	}
}
