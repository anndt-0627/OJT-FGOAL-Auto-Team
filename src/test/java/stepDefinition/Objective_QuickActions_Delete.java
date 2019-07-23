package stepDefinition;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_Objective_QuickActions_ChangeName;
import pageObject.pageObj_Objective_QuickActions_Delete;
import utility.Common;

public class Objective_QuickActions_Delete extends Common {
	ResourceBundle properties_value = ResourceBundle.getBundle("dataObjective_QuickActions");
	private WebDriver driver;

	public Objective_QuickActions_Delete() {
		this.driver = Hooks.getDriver();
	}

	@When("^User performs to open Delete objective popup$")
	public void user_performs_to_open_Delete_objective_popup() {
		moveToElement(driver, pageObj_Objective_QuickActions_Delete.itmDelete(driver));
		pageObj_Objective_QuickActions_Delete.itmDelete(driver).click();
	}

	@Then("^Delete objective popup of \"([^\"]*)\" opens$")
	public void delete_objective_popup_of_opens(String objName) {
		// Title of Delete objective popup displays
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_Delete.popupDeleteObjective_lblTitle(driver));
		Assert.assertTrue(pageObj_Objective_QuickActions_Delete.popupDeleteObjective_lblTitle(driver).isDisplayed());

		// Message confirming the deletion of "<objName>" displays
		String actual_confirm_message = pageObj_Objective_QuickActions_Delete
				.popupDeleteObjective_msgConfirm(driver, objName).getText();
		String expected_confirm_message = properties_value.getString("OBJ_DELETE_MSG_CONFIRM") + objName + " ?";
		assertEquals(expected_confirm_message, actual_confirm_message);

		// Close button displays
		Assert.assertTrue(pageObj_Objective_QuickActions_Delete.popupDeleteObjective_btnClose(driver).isDisplayed());

		// Delete button displays
		Assert.assertTrue(pageObj_Objective_QuickActions_Delete.popupDeleteObjective_btnDelete(driver).isDisplayed());
	}

	@When("^User performs to close Delete objective popup$")
	public void user_performs_to_close_Delete_objective_popup() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_QuickActions_Delete.popupDeleteObjective_btnClose(driver));
		pageObj_Objective_QuickActions_Delete.popupDeleteObjective_btnClose(driver).click();
		sleepOfThread(3000);
	}

	@Then("^Delete objective popup closes$")
	public void delete_objective_popup_closes() {
		Assert.assertFalse(pageObj_Objective_QuickActions_Delete.popupDeleteObjective_lblTitle(driver).isDisplayed());
	}

	@When("^User confirms to delete Objective$")
	public void user_confirms_to_delete_Objective() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_QuickActions_Delete.popupDeleteObjective_btnDelete(driver));
		pageObj_Objective_QuickActions_Delete.popupDeleteObjective_btnDelete(driver).click();
	}

	@Then("^Objective \"([^\"]*)\" did not display on Dashboard screen$")
	public void objective_did_not_display_on_Dashboard_screen(String objName) {
		// Go to Dashboard screen
		pageObj_Objective_QuickActions_ChangeName.menuDashboard(driver).click();
		// Verify the deleted Objective is displayed on Dashboard screen or not?
		try {
			Assert.assertTrue(
					pageObj_Objective_QuickActions_ChangeName.DB_ObjectiveName(driver, objName).isDisplayed());
			Assert.assertTrue("The deleted Objective is still displayed", false);
		} catch (NoSuchElementException e) {
			Assert.assertTrue("The deleted Objective is disappeared", true);
		}
	}
}
