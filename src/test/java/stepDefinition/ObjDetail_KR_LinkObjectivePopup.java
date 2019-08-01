package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_ObjDetail_KR_LinkObjectivePopup;
import pageObject.pageObj_Objective_QuickActions_ChangeName;
import utility.Common;

public class ObjDetail_KR_LinkObjectivePopup extends Common {
	ResourceBundle properties_value = ResourceBundle.getBundle("dataObjDetail_KR_QuickAction");
	private WebDriver driver;

	public ObjDetail_KR_LinkObjectivePopup() {
		this.driver = Hooks.getDriver();
	}

	@When("^User opens Link Objective popup of Key Result \"([^\"]*)\"$")
	public void user_opens_Link_Objective_popup_of_Key_Result(String krName) {
		ObjDetail_KR_QuickActPopup popupViewDetail = new ObjDetail_KR_QuickActPopup();
		popupViewDetail.user_opens_Quick_Actions_popup_of_Key_Result(krName);

		visibilityOf(driver, 20, pageObj_ObjDetail_KR_LinkObjectivePopup.popupQuickAct_itmLinkObj(driver));
		pageObj_ObjDetail_KR_LinkObjectivePopup.popupQuickAct_itmLinkObj(driver).click();
	}

	@Then("^The components of Link Objective popup of Key Result \"([^\"]*)\" displays$")
	public void the_components_of_Link_Objective_popup_of_Key_Result_displays(String krName) {
		// Title displays
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_title(driver, krName));
		Assert.assertTrue(pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_title(driver, krName).isDisplayed());

		// Close icon displays
		Assert.assertTrue(pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_icoClose(driver).isDisplayed());

		// Group label and its dropdown displays
		Assert.assertTrue(pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_lblGroup(driver).isDisplayed());
		Assert.assertTrue(pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_drdGroup(driver).isDisplayed());

		// Next button displays
		Assert.assertTrue(pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_btnNext(driver).isDisplayed());
	}

	@When("^performs to close Link Objective popup$")
	public void performs_to_close_Link_Objective_popup() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_icoClose(driver));
		pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_icoClose(driver).click();
		sleepOfThread(3000);
	}

	@Then("^Link Objective popup of Key Result \"([^\"]*)\" closes$")
	public void link_Objective_popup_of_Key_Result_closes(String krName) {
		Assert.assertFalse(pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_title(driver, krName).isDisplayed());
	}

	@When("^User chooses invalid Group and goes to the next step$")
	public void user_chooses_invalid_Group_and_goes_to_the_next_step() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_drdGroup(driver));
		pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_drdGroup(driver).click();

		String groupName = properties_value.getString("KR_INVALID_GROUP");
		pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_optGroup(driver, groupName).click();

		pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_btnNext(driver).click();
	}

	@Then("^The message There are no Objective displays in Select Objective step$")
	public void the_message_There_are_no_Objective_displays_in_Select_Objective_step() {
		String actual_msg = pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_lblNoObjective(driver).getText();
		String expected_msg = properties_value.getString("KR_NO_OBJ_LBL");
		assertEquals(expected_msg, actual_msg);
	}

	@When("^User chooses valid Group and goes to the next step$")
	public void user_chooses_valid_Group_and_goes_to_the_next_step() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_drdGroup(driver));
		pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_drdGroup(driver).click();

		String groupName = properties_value.getString("KR_VALID_GROUP");
		pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_optGroup(driver, groupName).click();

		pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_btnNext(driver).click();
	}

	@Then("^The components of Select Objective step displays$")
	public void the_components_of_Select_Objective_step_displays() {
		// Tab Choose Objective displays
		Assert.assertTrue(
				pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_tabChooseObjective(driver).isDisplayed());

		// Tab Add new Objective displays
		Assert.assertTrue(
				pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_tabAddNewObjective(driver).isDisplayed());

		// List of Objective displays
		Assert.assertTrue(pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_lstObjective(driver).isDisplayed());

		// Back button displays
		Assert.assertTrue(pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_btnBack(driver).isDisplayed());

		// Submit button displays
		Assert.assertTrue(pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_btnSubmit(driver).isDisplayed());
	}

	@When("^User performs to back the previous screen at Select Objective step$")
	public void user_performs_to_back_the_previous_screen_at_Select_Objective_step() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_btnBack(driver));
		pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_btnBack(driver).click();
	}

	@Given("^User goes to Dashboard screen has Objective \"([^\"]*)\"$")
	public void user_goes_to_Dashboard_screen_has_Objective(String desObj) {
		pageObj_Objective_QuickActions_ChangeName.menuDashboard(driver).click();

		Objective_QuickActions_ChangeName navObj = new Objective_QuickActions_ChangeName();
		navObj.user_navigates_to_Objective(desObj);
	}

	@When("^User navigates to Objective \"([^\"]*)\" has Key Result \"([^\"]*)\" of another Group$")
	public void user_navigates_to_Objective_has_Key_Result_of_another_Group(String objName, String krName) {
		Objective_QuickActions_LinkObjectives anotherObj = new Objective_QuickActions_LinkObjectives();
		anotherObj.user_navigates_to_Group_details_screen_of_another_Group();
		anotherObj.user_navigates_to_Objective_has_Key_Result(objName, krName);
	}

	@When("^User performs to choose an Objective \"([^\"]*)\"$")
	public void user_performs_to_choose_an_Objective(String desObj) {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_ckbObjevtive(driver, desObj));
		moveToElement(driver, pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_ckbObjevtive(driver, desObj));
		pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_ckbObjevtive(driver, desObj).click();
	}

	@When("^User performs to submit at Select Objective step$")
	public void user_performs_to_submit_at_Select_Objective_step() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_btnSubmit(driver));
		moveToElement(driver, pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_btnSubmit(driver));
		pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_btnSubmit(driver).click();
	}

	@Then("^Link Objective successfully popup displays$")
	public void link_Objective_successfully_popup_displays() {
		// Success ring displays
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_SuccessRing(driver));
		Assert.assertTrue(pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_SuccessRing(driver).isDisplayed());

		// OK button displays
		Assert.assertTrue(pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_btnOK(driver).isDisplayed());

		// Close popup by clicking on OK button
		pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_btnOK(driver).click();
		sleepOfThread(5000);
	}

	@Then("^Key Result \"([^\"]*)\" displays in Link To section of Objective \"([^\"]*)\"$")
	public void key_Result_displays_in_Link_To_section_of_Objective(String krName, String desObj) {
		user_goes_to_Dashboard_screen_has_Objective(desObj);
		Assert.assertTrue(
				pageObj_ObjDetail_KR_LinkObjectivePopup.objDetail_LinkTo_KRName(driver, krName).isDisplayed());
	}

	@Given("^User goes to Dashboard screen has Objective \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_goes_to_Dashboard_screen_has_Objective_and(String desObj1, String desObj2) {
		user_goes_to_Dashboard_screen_has_Objective(desObj1);
		user_goes_to_Dashboard_screen_has_Objective(desObj2);
	}

	@When("^User performs to choose Objective \"([^\"]*)\" and \"([^\"]*)\" and submits$")
	public void user_performs_to_choose_Objective_and_and_submits(String desObj1, String desObj2) {
		// Perform to choose Objective
		user_performs_to_choose_an_Objective(desObj1);
		user_performs_to_choose_an_Objective(desObj2);

		// And submit
		user_performs_to_submit_at_Select_Objective_step();
	}

	@Then("^Key Result \"([^\"]*)\" displays in Link To section of Objective \"([^\"]*)\" and \"([^\"]*)\"$")
	public void key_Result_displays_in_Link_To_section_of_Objective_and(String krName, String desObj1, String desObj2) {
		key_Result_displays_in_Link_To_section_of_Objective(krName, desObj1);
		key_Result_displays_in_Link_To_section_of_Objective(krName, desObj2);
	}

	@When("^User opens Link Objective popup of Key Result \"([^\"]*)\" and link to Objective \"([^\"]*)\" again$")
	public void user_opens_Link_Objective_popup_of_Key_Result_and_link_to_Objective_again(String krName,
			String desObj) {
		user_opens_Link_Objective_popup_of_Key_Result(krName);
		user_chooses_valid_Group_and_goes_to_the_next_step();
		user_performs_to_submit_at_Select_Objective_step();
	}

	@Then("^Link Objective failed popup displays$")
	public void link_Objective_failed_popup_displays() {
		// Success ring displays
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_FailedRing(driver));
		Assert.assertTrue(pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_FailedRing(driver).isDisplayed());

		// OK button displays
		Assert.assertTrue(
				pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_RequestFailed_btnOK(driver).isDisplayed());
	}

	@When("^User navigates to Add new Objective tab$")
	public void user_navigates_to_Add_new_Objective_tab() {
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_tabAddNewObjective(driver));
		pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_tabAddNewObjective(driver).click();
	}

	@When("^User creates a new Objective \"([^\"]*)\" and submits$")
	public void user_creates_a_new_Objective_and_submits(String newObj) {
		// Create a new Objective
		visibilityOf(driver, 20, pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_txtObjectiveName(driver));
		pageObj_ObjDetail_KR_LinkObjectivePopup.popupLinkObj_txtObjectiveName(driver).sendKeys(newObj);

		// And submit
		user_performs_to_submit_at_Select_Objective_step();
	}
}