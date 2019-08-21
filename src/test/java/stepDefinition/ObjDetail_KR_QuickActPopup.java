package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_ObjDetail_KR_QuickActionPopup;
import utility.Common;

public class ObjDetail_KR_QuickActPopup extends Common {
	private WebDriver driver;

	public ObjDetail_KR_QuickActPopup() {
		this.driver = Hooks.getDriver();
	}

	//@When("^User opens Quick Actions popup of Key Result \"([^\"]*)\"$")
	public void user_opens_Quick_Actions_popup_of_Key_Result(String krName) {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_QuickActionPopup.icoQuickActKR(driver, krName));
		moveToElement(driver, pageObj_ObjDetail_KR_QuickActionPopup.icoQuickActKR(driver, krName));
		pageObj_ObjDetail_KR_QuickActionPopup.icoQuickActKR(driver, krName).click();
	}

	@Then("^Quick Actions popup of Key Result opens$")
	public void quick_Actions_popup_of_Key_Result_opens() {
		// Popup name displays
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_title(driver));
		Assert.assertTrue(pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_title(driver).isDisplayed());

		// View Detail item displays
		Assert.assertTrue(pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmViewDetail(driver).isDisplayed());

		// Update Key result title item displays
		Assert.assertTrue(pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmUpdateKRtitle(driver).isDisplayed());

		// Update weight displays
		Assert.assertTrue(pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmUpdateWeight(driver).isDisplayed());

		// Update target item displays
		Assert.assertTrue(pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmUpdateTarget(driver).isDisplayed());

		// Delete item displays
		Assert.assertTrue(pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmDelete(driver).isDisplayed());
	}

	@When("^User opens View Detail popup of Key Result$")
	public void user_opens_View_Detail_popup_of_Key_Result() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmViewDetail(driver));
		pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmViewDetail(driver).click();
	}

	@When("^User opens Update Key result title popup of Key Result$")
	public void user_opens_Update_Key_result_title_popup_of_Key_Result() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmUpdateKRtitle(driver));
		pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmUpdateKRtitle(driver).click();
	}

	@When("^User opens Update weight popup of Key Result$")
	public void user_opens_Update_weight_popup_of_Key_Result() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmUpdateWeight(driver));
		pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmUpdateWeight(driver).click();
	}

	@When("^User opens Update target popup of Key Result$")
	public void user_opens_Update_target_popup_of_Key_Result() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmUpdateTarget(driver));
		pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmUpdateTarget(driver).click();
	}

	@When("^User opens Delete popup of Key Result$")
	public void user_opens_Delete_popup_of_Key_Result() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmDelete(driver));
		pageObj_ObjDetail_KR_QuickActionPopup.popupQuickAct_itmDelete(driver).click();
	}

	@Then("^View Detail popup of Key Result \"([^\"]*)\" opens$")
	public void view_Detail_popup_of_Key_Result_opens(String krName) {
		// Popup title displays
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_QuickActionPopup.popupViewDetail_title(driver, krName));
		Assert.assertTrue(pageObj_ObjDetail_KR_QuickActionPopup.popupViewDetail_title(driver, krName).isDisplayed());
	}

	@Then("^Update Key result title popup of Key Result \"([^\"]*)\" opens$")
	public void update_Key_result_title_popup_of_Key_Result_opens(String krName) {
		// Popup title displays
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_QuickActionPopup.popupUpdateKR_title(driver));
		Assert.assertTrue(pageObj_ObjDetail_KR_QuickActionPopup.popupUpdateKR_title(driver).isDisplayed());
	}

	@Then("^Update weight popup of Key Result \"([^\"]*)\" opens$")
	public void update_weight_popup_of_Key_Result_opens(String krName) {
		// Popup title displays
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_QuickActionPopup.popupUpdateWeight_title(driver));
		Assert.assertTrue(pageObj_ObjDetail_KR_QuickActionPopup.popupUpdateWeight_title(driver).isDisplayed());
	}

	@Then("^Update target popup of Key Result \"([^\"]*)\" opens$")
	public void update_target_popup_of_Key_Result_opens(String krName) {
		// Popup title displays
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_QuickActionPopup.popupUpdateTarget_title(driver));
		Assert.assertTrue(pageObj_ObjDetail_KR_QuickActionPopup.popupUpdateTarget_title(driver).isDisplayed());
	}

	@Then("^Delete popup of Key Result \"([^\"]*)\" opens$")
	public void delete_popup_of_Key_Result_opens(String krName) {
		// Popup title displays
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_QuickActionPopup.popupDelete_title(driver));
		Assert.assertTrue(pageObj_ObjDetail_KR_QuickActionPopup.popupDelete_title(driver).isDisplayed());
	}
}
