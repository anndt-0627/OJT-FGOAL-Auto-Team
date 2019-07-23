package stepDefinition;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_Objective_QuickActions_ChangeName;
import pageObject.pageObj_Objective_QuickActions_LinkObjectives;
import utility.Common;

public class Objective_QuickActions_LinkObjectives extends Common {
	ResourceBundle properties_value = ResourceBundle.getBundle("dataObjective_QuickActions");
	private WebDriver driver;

	public Objective_QuickActions_LinkObjectives() {
		this.driver = Hooks.getDriver();
	}

	@When("^User performs to open Link to Key Result popup$")
	public void user_performs_to_open_Link_to_Key_Result_popup() {
		// User opens Quick Actions popup of Objective
		Objective_QuickActions_ChangeName popupQuickActions = new Objective_QuickActions_ChangeName();
		popupQuickActions.user_opens_Quick_Actions_popup_of_Objective();

		// User performs to open Link to Key Result popup
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.itmLinkObjectives(driver));
		pageObj_Objective_QuickActions_LinkObjectives.itmLinkObjectives(driver).click();
	}

	@Then("^The components of Select Group screen displays$")
	public void the_components_of_Select_Group_screen_displays() {
		// Title of Link to Key Result popup displays
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_lblTitle(driver));
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_lblTitle(driver).isDisplayed());

		// Close icon displays in Link to Key Result popup
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_icoClose(driver).isDisplayed());

		// Group label displays in Link to Key Result popup
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_lblGroup(driver).isDisplayed());

		// Group dropdown displays in Link to Key Result popup
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlGroup(driver).isDisplayed());

		// Next button at Select Group screen displays in Link to Key Result
		// popup
		Assert.assertTrue(pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_btnNext_SelectGroup(driver)
				.isDisplayed());
	}

	@When("^User performs to close Link to Key Result popup$")
	public void user_performs_to_close_Link_to_Key_Result_popup() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_icoClose(driver));
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_icoClose(driver).click();
		sleepOfThread(3000);
	}

	@Then("^Link to Key Result popup closes$")
	public void link_to_Key_Result_popup_closes() {
		Assert.assertFalse(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_lblTitle(driver).isDisplayed());
	}

	@When("^User opens Group dropdown$")
	public void user_opens_Group_dropdown() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlGroup(driver));
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlGroup(driver).click();
	}

	@Then("^Group dropdown menu of Group dropdown displays$")
	public void group_dropdown_menu_of_Group_dropdown_displays() {
		visibilityOf(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlGroup_mennu(driver));
		Assert.assertTrue(pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlGroup_mennu(driver)
				.isDisplayed());
	}

	@Then("^Search textbox displays in Group dropdown menu$")
	public void search_textbox_displays_in_Group_dropdown_menu() {
		Assert.assertTrue(pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlGroup_txtSearch(driver)
				.isDisplayed());
	}

	@When("^User enters keyword not match into Search textbox$")
	public void user_enters_keyword_not_match_into_Search_textbox() {
		String keyword = properties_value.getString("OBJ_LINKOBJ_SEARCH_GROUP_NOT_EXIST");
		user_opens_Group_dropdown();
		user_enters_keyword_into_Search_textbox(keyword);
	}

	@Then("^Nothing selected text displays in Group dropdown$")
	public void nothing_selected_text_displays_in_Group_dropdown() {
		String actual_text = pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlGroup(driver)
				.getText();
		String expected_text = properties_value.getString("OBJ_LINKOBJ_GROUP_NOTHING_SELECTED");
		assertEquals(expected_text, actual_text);
	}

	@When("^User performs to submit at Select Group screen$")
	public void user_performs_to_submit_at_Select_Group_screen() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_btnNext_SelectGroup(driver));
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_btnNext_SelectGroup(driver).click();
	}

	@Then("^The error message for case no choice Group displays$")
	public void the_error_message_for_case_no_choice_Group_displays() {
		String actual_msgError = pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_msgError_SelectGroup(driver).getText();
		String expected_msgError = properties_value.getString("OBJ_LINKOBJ_NO_CHOICE_GROUP");
		assertEquals(expected_msgError, actual_msgError);
	}

	@When("^User enters keyword matched into Search textbox$")
	public void user_enters_keyword_matched_into_Search_textbox() {
		String keyword = properties_value.getString("OBJ_LINKOBJ_SEARCH_GROUP_EXISTED");
		user_opens_Group_dropdown();
		user_enters_keyword_into_Search_textbox(keyword);
	}

	@When("^User enters keyword is a group that has no Objective into Search textbox$")
	public void user_enters_keyword_is_a_group_that_has_no_Objective_into_Search_textbox() {
		String keyword = properties_value.getString("OBJ_LINKOBJ_GROUP_HAS_NO_OBJ");
		user_opens_Group_dropdown();
		user_enters_keyword_into_Search_textbox(keyword);
	}

	@Then("^The components of Select Objective screen displays$")
	public void the_components_of_Select_Objective_screen_displays() {
		// Title of Link to Key Result popup displays
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_lblTitle(driver));
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_lblTitle(driver).isDisplayed());

		// Close icon displays in Link to Key Result popup
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_icoClose(driver).isDisplayed());

		// Objectives label displays in Link to Key Result popup
		visibilityOf(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_lblObjectives(driver));
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_lblObjectives(driver).isDisplayed());

		// List of Objective displays in Link to Key Result popup
		list_of_Objective_displays_in_Link_to_Key_Result_popup();

		// Back button at Select Objective screen displays in Link to Key Result
		// popup
		Assert.assertTrue(pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_btnBack_SelectObjective(driver).isDisplayed());

		// Next button at Select Objective screen displays in Link to Key Result
		// popup
		Assert.assertTrue(pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_btnNext_SelectObjective(driver).isDisplayed());
	}

	@Then("^Message there is no objective displays in Link to Key Result popup$")
	public void message_there_is_no_objective_displays_in_Link_to_Key_Result_popup() {
		Assert.assertTrue(pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_msgNoObjectiveInGroup(driver).isDisplayed());
	}

	@When("^User enters keyword is a group that has Objective into Search textbox and submits$")
	public void user_enters_keyword_is_a_group_that_has_Objective_into_Search_textbox_and_submits() {
		String keyword = properties_value.getString("OBJ_LINKOBJ_GROUP_HAS_OBJ");
		user_opens_Group_dropdown();
		user_enters_keyword_into_Search_textbox(keyword);
		user_performs_to_submit_at_Select_Group_screen();
	}

	@Then("^List of Objective displays in Link to Key Result popup$")
	public void list_of_Objective_displays_in_Link_to_Key_Result_popup() {
		visibilityOf(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_lstObjective(driver));
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_lstObjective(driver).isDisplayed());
	}

	@When("^User performs to back the previous screen at Select Objective screen$")
	public void user_performs_to_back_the_previous_screen_at_Select_Objective_screen() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_btnBack_SelectObjective(driver));
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_btnBack_SelectObjective(driver).click();
	}

	@When("^User performs to submit at Select Objective screen$")
	public void user_performs_to_submit_at_Select_Objective_screen() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_btnNext_SelectObjective(driver));
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_btnNext_SelectObjective(driver).click();
	}

	@Then("^The error message for case no choice Objective displays$")
	public void the_error_message_for_case_no_choice_Objective_displays() {
		String actual_msgError = pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_msgError_SelectObjective(driver).getText();
		String expected_msgError = properties_value.getString("OBJ_LINKOBJ_NO_CHOICE_OBJ");
		assertEquals(expected_msgError, actual_msgError);
	}

	@Given("^User navigates to Group details screen of another Group$")
	public void user_navigates_to_Group_details_screen_of_another_Group() {
		// Go to another Group via Left menu
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.menuMyGroups(driver));
		pageObj_Objective_QuickActions_LinkObjectives.menuMyGroups(driver).click();

		String anotherGroup = properties_value.getString("OBJ_LINKOBJ_GROUP_HAS_OBJ");
		pageObj_Objective_QuickActions_LinkObjectives.menuMyGroups_Group(driver, anotherGroup).click();
	}

	@When("^Checking the existence or creating Key Result \"([^\"]*)\" for Objective$")
	public void checking_the_existence_or_creating_Key_Result_for_Objective(String krName) {
		// If the Key Result is existed then do nothing
		// If the Key Result does not exist then creating this Key Result
		try {
			Assert.assertTrue(
					pageObj_Objective_QuickActions_LinkObjectives.KeyResultName(driver, krName).isDisplayed());
		} catch (NoSuchElementException e) {
			create_new_Key_Result_for_Objective(krName);
		}
	}

	@When("^User goes to Dashboard screen and navigates to Objective \"([^\"]*)\"$")
	public void user_goes_to_Dashboard_screen_and_navigates_to_Objective(String objName) {
		sleepOfThread(3000);
		pageObj_Objective_QuickActions_ChangeName.menuDashboard(driver).click();

		Objective_QuickActions_ChangeName navObj = new Objective_QuickActions_ChangeName();
		navObj.user_navigates_to_Objective(objName);
	}

	@When("^User selects the Objective \"([^\"]*)\" at Select Objective screen and submits$")
	public void user_selects_the_Objective_at_Select_Objective_screen_and_submits(String objName) {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_radioObjective(driver, objName));
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_radioObjective(driver, objName).click();

		// User performs to submit at Select Objective screen
		user_performs_to_submit_at_Select_Objective_screen();
	}

	@Then("^The components of Select Key Result screen with the selected Objective \"([^\"]*)\" displays$")
	public void the_components_of_Select_Key_Result_screen_with_the_selected_Objective_displays(String objNameNew) {
		// Title of Link to Key Result popup displays
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_lblTitle(driver));
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_lblTitle(driver).isDisplayed());

		// Close icon displays in Link to Key Result popup
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_icoClose(driver).isDisplayed());

		// Key Result label displays in Link to Key Result popup
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_lblKeyResult(driver).isDisplayed());

		// Key Result dropdown displays in Link to Key Result popup
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlKeyResult(driver).isDisplayed());

		// Placeholder of Key Result dropdown displays in Link to Key Result
		// popup
		String actual_placeholder = pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_ddlKeyResult(driver).getText();
		String expected_placeholder = properties_value.getString("OBJ_LINKOBJ_PLACEHOLDER_KR") + objNameNew;
		assertEquals(expected_placeholder, actual_placeholder);

		// Back button at Select Key Result screen displays in Link to Key
		// Result popup
		Assert.assertTrue(pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_btnBack_SelectKeyResult(driver).isDisplayed());

		// Submit button at Select Key Result screen displays in Link to Key
		// Result popup
		Assert.assertTrue(pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_btnSubmit_SelectKeyResult(driver).isDisplayed());
	}

	@Given("^User opens Key Result dropdown$")
	public void user_opens_Key_Result_dropdown() {
		visibilityOf(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlKeyResult(driver));
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlKeyResult(driver).click();
	}

	@Then("^Key Result dropdown menu of Key Result dropdown displays$")
	public void key_Result_dropdown_menu_of_Key_Result_dropdown_displays() {
		visibilityOf(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlKeyResult_mennu(driver));
		Assert.assertTrue(pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlKeyResult_mennu(driver)
				.isDisplayed());
	}

	@Then("^Select All button displays in Key Result dropdown menu$")
	public void select_All_button_displays_in_Key_Result_dropdown_menu() {
		Assert.assertTrue(pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_btnSelectAll_SelectKeyResult(driver).isDisplayed());
	}

	@Then("^Deselect All button displays in Key Result dropdown menu$")
	public void deselect_All_button_displays_in_Key_Result_dropdown_menu() {
		Assert.assertTrue(pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_btnDeselectAll_SelectKeyResult(driver).isDisplayed());
	}

	@Given("^User performs to back the previous screen at Select Key Result screen$")
	public void user_performs_to_back_the_previous_screen_at_Select_Key_Result_screen() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_btnBack_SelectKeyResult(driver));
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_btnBack_SelectKeyResult(driver).click();
	}

	@Given("^User performs to submit at Select Key Result screen$")
	public void user_performs_to_submit_at_Select_Key_Result_screen() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_btnSubmit_SelectKeyResult(driver));
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_btnSubmit_SelectKeyResult(driver).click();
	}

	@Then("^The error message for case no choice Key Result displays$")
	public void the_error_message_for_case_no_choice_Key_Result_displays() {
		String actual_msgError = pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_msgError_SelectKeyRessult(driver).getText();
		String expected_msgError = properties_value.getString("OBJ_LINKOBJ_NO_CHOICE_KR");
		assertEquals(expected_msgError, actual_msgError);
	}

	@Given("^User opens and selects Key Result \"([^\"]*)\" in Key Result dropdown$")
	public void user_opens_and_selects_Key_Result_in_Key_Result_dropdown(String krName) {
		// User opens Key Result dropdown
		user_opens_Key_Result_dropdown();

		// User selects Key Result
		visibilityOf(driver, 20, pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_krName_SelectKeyResult(driver, krName));
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_krName_SelectKeyResult(driver, krName)
				.click();
	}

	@Then("^The selected Key Result \"([^\"]*)\" displays in Key Result dropdown$")
	public void the_selected_Key_Result_displays_in_Key_Result_dropdown(String krName) {
		Assert.assertTrue(pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_ddlKeyResult_Selected(driver, krName).isDisplayed());
	}

	@When("^User opens and performs to select all of Key Result in Key Result dropdown$")
	public void user_opens_and_performs_to_select_all_of_Key_Result_in_Key_Result_dropdown() {
		// User opens Key Result dropdown
		user_opens_Key_Result_dropdown();

		// User selects all of Key Result
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_btnSelectAll_SelectKeyResult(driver));
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_btnSelectAll_SelectKeyResult(driver).click();

		// Collapse Key Result dropdown menu by click on Title
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_lblTitle(driver).click();
	}

	@Then("^The all of Key Result \"([^\"]*)\" and \"([^\"]*)\" displays in Key Result dropdown$")
	public void the_all_of_Key_Result_and_displays_in_Key_Result_dropdown(String krName1, String krName2) {
		Assert.assertTrue(pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_ddlKeyResult_multiSelected(driver, krName1, krName2).isDisplayed());

		// Expand Key Result dropdown menu by click on
		pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_ddlKeyResult_multiSelected(driver, krName1, krName2).click();
	}

	@When("^User performs to deselect all of Key Result in Key Result dropdown$")
	public void user_performs_to_deselect_all_of_Key_Result_in_Key_Result_dropdown() {
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_btnDeselectAll_SelectKeyResult(driver)
				.click();
	}

	@Then("^Reset the data and display the placeholder with the selected Objective \"([^\"]*)\" in Key Result dropdown$")
	public void reset_the_data_and_display_the_placeholder_with_the_selected_Objective_in_Key_Result_dropdown(
			String objNameNew) {
		String actual_placeholder = pageObj_Objective_QuickActions_LinkObjectives
				.popupLinkToKeyResult_ddlKeyResult(driver).getText();
		String expected_placeholder = properties_value.getString("OBJ_LINKOBJ_PLACEHOLDER_KR") + objNameNew;
		assertEquals(expected_placeholder, actual_placeholder);
	}

	@Then("^Link to Key Result successfully popup displays$")
	public void link_to_Key_Result_successfully_popup_displays() {
		// Success ring displays
		visibilityOf(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_SuccessRing(driver));
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_SuccessRing(driver).isDisplayed());

		// Message "Request has been sent" displays
		Assert.assertTrue(pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_msgRequestSent(driver)
				.isDisplayed());

		// Message "Waiting for approval" displays
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_msgWaitFor(driver).isDisplayed());

		// OK button displays
		Assert.assertTrue(
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_btnOK(driver).isDisplayed());
	}

	public void user_enters_keyword_into_Search_textbox(String keyword) {
		visibilityOf(driver, 20,
				pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlGroup_txtSearch(driver));
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlGroup_txtSearch(driver).sendKeys(keyword);

		// waiting for search result displays and gets the selected item as
		// data in Group dropdown
		sleepOfThread(3000);
		pageObj_Objective_QuickActions_LinkObjectives.popupLinkToKeyResult_ddlGroup(driver).click();
	}

	public void create_new_Key_Result_for_Objective(String krName) {
		pageObj_Objective_QuickActions_LinkObjectives.btnAddKeyResult(driver).click();

		visibilityOf(driver, 20, pageObj_Objective_QuickActions_LinkObjectives.popupAddKeyResult_txtName(driver));
		pageObj_Objective_QuickActions_LinkObjectives.popupAddKeyResult_txtName(driver).sendKeys(krName);
		pageObj_Objective_QuickActions_LinkObjectives.popupAddKeyResult_btnAdd(driver).click();
		sleepOfThread(3000);
	}
}
