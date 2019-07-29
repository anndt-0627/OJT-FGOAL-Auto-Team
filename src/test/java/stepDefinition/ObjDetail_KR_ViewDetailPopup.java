package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

//import static org.junit.Assert.*;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_ObjDetail_KR_QuickActionPopup;
import pageObject.pageObj_ObjDetail_KR_ViewDetailPopup;
import utility.Common;

public class ObjDetail_KR_ViewDetailPopup extends Common {
	ResourceBundle properties_value = ResourceBundle.getBundle("dataObjDetail_KR_QuickAction");
	private WebDriver driver;

	public ObjDetail_KR_ViewDetailPopup() {
		this.driver = Hooks.getDriver();
	}

	@When("^User navigates to Objective \"([^\"]*)\" has Key Result \"([^\"]*)\"$")
	public void user_navigates_to_Objective_has_Key_Result(String objName, String krName) {
		Objective_QuickActions_ChangeName Obj = new Objective_QuickActions_ChangeName();
		Obj.user_navigates_to_Objective(objName);

		Objective_QuickActions_LinkObjectives KeyResult = new Objective_QuickActions_LinkObjectives();
		KeyResult.checking_the_existence_or_creating_Key_Result_for_Objective(krName);
	}

	@When("^User opens View Detail popup of Key Result \"([^\"]*)\"$")
	public void user_opens_View_Detail_popup_of_Key_Result(String krName) {
		ObjDetail_KR_QuickActPopup popupViewDetail = new ObjDetail_KR_QuickActPopup();
		popupViewDetail.user_opens_Quick_Actions_popup_of_Key_Result(krName);
		popupViewDetail.user_opens_View_Detail_popup_of_Key_Result();
	}

	@Then("^The components of View Detail popup of Key Result \"([^\"]*)\" displays$")
	public void the_components_of_View_Detail_popup_of_Key_Result_displays(String krName) {
		// Popup title displays
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_QuickActionPopup.popupViewDetail_title(driver, krName));
		Assert.assertTrue(pageObj_ObjDetail_KR_QuickActionPopup.popupViewDetail_title(driver, krName).isDisplayed());

		// Progress bar displays
		// Assert.assertTrue(pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_progressbar(driver).isDisplayed());
		Assert.assertTrue(pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtProgress(driver).isDisplayed());

		// Weight textbox displays
		Assert.assertTrue(pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtWeight(driver).isDisplayed());

		// Config link displays
		Assert.assertTrue(pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_lnkConfig(driver).isDisplayed());

		// Close button displays
		Assert.assertTrue(pageObj_ObjDetail_KR_QuickActionPopup.popupViewDetail_btnClose(driver).isDisplayed());
	}

	@When("^User performs to close View Detail popup$")
	public void user_performs_to_close_View_Detail_popup() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_QuickActionPopup.popupViewDetail_btnClose(driver));
		pageObj_ObjDetail_KR_QuickActionPopup.popupViewDetail_btnClose(driver).click();
		sleepOfThread(2000);
	}

	@Then("^View Detail popup of Key Result \"([^\"]*)\" closes$")
	public void view_Detail_popup_of_Key_Result_closes(String krName) {
		Assert.assertFalse(pageObj_ObjDetail_KR_QuickActionPopup.popupViewDetail_title(driver, krName).isDisplayed());
	}

	@When("^User enters \"([^\"]*)\" into Progress textbox$")
	public void user_enters_into_Progress_textbox(String data) {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtProgress(driver));
		pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtProgress(driver).clear();
		sleepOfThread(2000);
		pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtProgress(driver).sendKeys(data);

		// Click on another item to update
		pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_LinkObjectives(driver).click();
	}

	@Then("^The success update message of Key Result displays$")
	public void the_success_update_message_of_Key_Result_displays() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_msgToast(driver));
		String actual_msgError = pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_msgToast(driver).getText();
		String expected_msgError = properties_value.getString("KR_SUCCESS_UPDATE_MSG");
		assertEquals(expected_msgError, actual_msgError);
	}

	@When("^User clears data in Progress textbox$")
	public void user_clears_data_in_Progress_textbox() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtProgress(driver));
		pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtProgress(driver).clear();
	}

	@Then("^The request enter data message displays$")
	public void the_request_enter_data_message_displays() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_msgToast(driver));
		String actual_msgError = pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_msgToast(driver).getText();
		String expected_msgError = properties_value.getString("KR_EMPTY_PROGRESS_MSG");
		assertEquals(expected_msgError, actual_msgError);
	}

	@Then("^The progress of Key Result will be \"([^\"]*)\"$")
	public void the_progress_of_Key_Result_will_be(String updated_data) {
		String actual_progress = pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtProgress(driver)
				.getAttribute("value");
		assertEquals(updated_data, actual_progress);
	}

	@When("^User closes View Detais popup of Key Result$")
	public void user_closes_View_Detais_popup_of_Key_Result() {
		pageObj_ObjDetail_KR_QuickActionPopup.popupViewDetail_btnClose(driver).click();
		sleepOfThread(3000);
	}

	@Then("^The progress of Key Result \"([^\"]*)\" on Objective Details screen will be \"([^\"]*)\"$")
	public void the_progress_of_Key_Result_on_Objective_Details_screen_will_be(String krName, String data) {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_ViewDetailPopup.txtProgressKR(driver, krName));
		String actual_progress = pageObj_ObjDetail_KR_ViewDetailPopup.txtProgressKR(driver, krName)
				.getAttribute("value");
		assertEquals(data, actual_progress);
	}

	@When("^User enters \"([^\"]*)\" into Weight textbox$")
	public void user_enters_into_Weight_textbox(String data) {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtWeight(driver));
		pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtWeight(driver).clear();
		sleepOfThread(2000);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='" + data + "';",
				pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtWeight(driver));
		((JavascriptExecutor) driver).executeScript("$(arguments[0]).change(); return true;",
				pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtWeight(driver));
	}

	@Then("^The weight of Key Result will be \"([^\"]*)\"$")
	public void the_weight_of_Key_Result_will_be(String updated_data) {
		String actual_weight = pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtWeight(driver)
				.getAttribute("value");
		assertEquals(updated_data, actual_weight);
	}

	@Then("^The weight of Key Result \"([^\"]*)\" on Objective Details screen will be \"([^\"]*)\"$")
	public void the_weight_of_Key_Result_on_Objective_Details_screen_will_be(String krName, String data) {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_ViewDetailPopup.txtWeightKR(driver, krName));
		String actual_progress = pageObj_ObjDetail_KR_ViewDetailPopup.txtWeightKR(driver, krName).getAttribute("value");
		assertEquals(data, actual_progress);
	}

	@When("^User enters \"([^\"]*)\" into Description textarea and submits$")
	public void user_enters_into_Description_textarea_and_submits(String data) {
		user_enters_data_into_Description_textarea(data);
		pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_btnUpdate(driver).click();
	}

	@Then("^The success update message of Key Result Description displays$")
	public void the_success_update_message_of_Key_Result_Description_displays() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_msgToast(driver));
		String actual_msgError = pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_msgToast(driver).getText();
		String expected_msgError = properties_value.getString("KR_DESC_SUCCESS_UPDATE_MSG");
		assertEquals(expected_msgError, actual_msgError);
	}

	@When("^User enters data greater than maxlength into Description textarea$")
	public void user_enters_data_greater_than_maxlength_into_Description_textarea() {
		String data = properties_value.getString("DATA_GREATER_THAN_500");
		user_enters_data_into_Description_textarea(data);
	}

	@Then("^The number of characters of content in Description equal to maxlength$")
	public void the_number_of_characters_of_content_in_Description_equal_to_maxlength() {
		// Get the first 500 characters
		String data = properties_value.getString("DATA_GREATER_THAN_500");
		String expected_data = data.substring(0, Math.min(data.length(), 500));

		// Compare
		String actual_data = pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtDesc(driver).getAttribute("value");
		assertEquals(expected_data, actual_data);
	}

	@Then("^The description of Key Result \"([^\"]*)\" on Objective Details screen will be \"([^\"]*)\"$")
	public void the_description_of_Key_Result_on_Objective_Details_screen_will_be(String krName, String data) {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_ViewDetailPopup.lnkDescKR(driver, krName));
		pageObj_ObjDetail_KR_ViewDetailPopup.lnkDescKR(driver, krName).click();

		visibilityOf(driver, 20, pageObj_ObjDetail_KR_ViewDetailPopup.txtDescKR(driver, krName));
		String actual_progress = pageObj_ObjDetail_KR_ViewDetailPopup.txtDescKR(driver, krName).getAttribute("value");
		assertEquals(data, actual_progress);
	}

	public void user_enters_data_into_Description_textarea(String data) {
		// Click on Description link to open its textarea
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_lnkDesc(driver));
		pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_lnkDesc(driver).click();

		// Enter data into Description textarea
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtDesc(driver));
		pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtDesc(driver).click();
		pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtDesc(driver).clear();
		pageObj_ObjDetail_KR_ViewDetailPopup.popupViewDetail_txtDesc(driver).sendKeys(data);
	}
}