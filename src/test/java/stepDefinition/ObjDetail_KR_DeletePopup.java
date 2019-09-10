package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_ObjDetail_KR_DeletePopup;
import utility.Common;

public class ObjDetail_KR_DeletePopup extends Common {
	ResourceBundle properties_value = ResourceBundle.getBundle("dataObjDetail_KR_QuickAction");
	private WebDriver driver;

	public ObjDetail_KR_DeletePopup() {
		this.driver = Hooks.getDriver();
	}

	@When("^User opens Delete key result popup of Key Result \"([^\"]*)\"$")
	public void user_opens_Delete_key_result_popup_of_Key_Result(String krName) {
		ObjDetail_KR_QuickActPopup popupViewDetail = new ObjDetail_KR_QuickActPopup();
		popupViewDetail.user_opens_Quick_Actions_popup_of_Key_Result(krName);
		popupViewDetail.user_opens_Delete_popup_of_Key_Result();
	}

	@Then("^The components of Delete key result popup of Key Result \"([^\"]*)\" displays$")
	public void the_components_of_Delete_key_result_popup_of_Key_Result_displays(String krName) {
		// Title of Delete key result popup displays
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_DeletePopup.popupDeleteKR_lblTitle(driver));
		Assert.assertTrue(pageObj_ObjDetail_KR_DeletePopup.popupDeleteKR_lblTitle(driver).isDisplayed());

		// Message confirming the deletion of key result displays
		String actual_confirm_message = pageObj_ObjDetail_KR_DeletePopup.popupDeleteKR_msgConfirm(driver, krName)
				.getText();
		String expected_confirm_message = properties_value.getString("KR_DELETE_MSG_CONFIRM") + krName + "?";
		assertEquals(expected_confirm_message, actual_confirm_message);

		// Close button displays
		Assert.assertTrue(pageObj_ObjDetail_KR_DeletePopup.popupDeleteKR_btnClose(driver).isDisplayed());

		// Delete button displays
		Assert.assertTrue(pageObj_ObjDetail_KR_DeletePopup.popupDeleteKR_btnDelete(driver).isDisplayed());
	}

	@When("^User performs to close Delete key result popup$")
	public void user_performs_to_close_Delete_key_result_popup() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_DeletePopup.popupDeleteKR_btnClose(driver));
		pageObj_ObjDetail_KR_DeletePopup.popupDeleteKR_btnClose(driver).click();
		sleepOfThread(3000);
	}

	@Then("^Delete key result popup closes$")
	public void delete_key_result_popup_closes() {
		Assert.assertFalse(pageObj_ObjDetail_KR_DeletePopup.popupDeleteKR_lblTitle(driver).isDisplayed());
	}

	@Then("^Key Result \"([^\"]*)\" still displays on Objective Detail screen$")
	public void key_Result_still_displays_on_Objective_Detail_screen(String krName) {
		Assert.assertTrue(pageObj_ObjDetail_KR_DeletePopup.krName(driver, krName).isDisplayed());
	}

	@When("^User confirms to delete Key Result$")
	public void user_confirms_to_delete_Key_Result() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_DeletePopup.popupDeleteKR_btnDelete(driver));
		pageObj_ObjDetail_KR_DeletePopup.popupDeleteKR_btnDelete(driver).click();
		sleepOfThread(3000);
	}

	@Then("^Key Result \"([^\"]*)\" did not display on Objective Detail screen$")
	public void key_Result_did_not_display_on_Objective_Detail_screen(String krName) {
		try {
			Assert.assertTrue(pageObj_ObjDetail_KR_DeletePopup.krName(driver, krName).isDisplayed());
			Assert.assertTrue("The deleted KR is still displayed", false);
		} catch (NoSuchElementException e) {
			Assert.assertTrue("The deleted KR is disappeared", true);
		}
	}
}