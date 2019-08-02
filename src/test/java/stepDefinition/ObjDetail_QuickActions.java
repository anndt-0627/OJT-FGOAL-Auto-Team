package stepDefinition;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_ObjDetail_QuickActions;
import utility.Common;

public class ObjDetail_QuickActions extends Common {
	ResourceBundle properties_value = ResourceBundle.getBundle("dataObjDetail_QuickActions");
	private WebDriver driver;

	public ObjDetail_QuickActions() {
		this.driver = Hooks.getDriver();
	}

	@When("^User navigates to Objective \"([^\"]*)\"$")
	public void user_navigates_to_Objective(String objName) {
		// If the Objective is existed then go to Objective details screen
		// If the Objective does not exist then creating this Objective
		try {
			Assert.assertTrue(pageObj_ObjDetail_QuickActions.DB_ObjectiveName(driver, objName).isDisplayed());
			moveToElement(driver, pageObj_ObjDetail_QuickActions.DB_ObjectiveName(driver, objName));
			pageObj_ObjDetail_QuickActions.DB_ObjectiveName(driver, objName).click();
		} catch (NoSuchElementException e) {
			create_a_new_Objective(objName);
		}
	}

	@When("^User opens Quick Actions popup of Objective$")
	public void user_opens_Quick_Actions_popup_of_Objective() {
		visibilityOfElementToBeClickable(driver, 20, pageObj_ObjDetail_QuickActions.icoQuickActions(driver));
		pageObj_ObjDetail_QuickActions.icoQuickActions(driver).click();
	}

	@When("^User performs to open Update Objective title popup$")
	public void user_performs_to_open_Update_Objective_title_popup() {
		moveToElement(driver, pageObj_ObjDetail_QuickActions.itmUpdateObjectiveTitle(driver));
		pageObj_ObjDetail_QuickActions.itmUpdateObjectiveTitle(driver).click();
	}

	@Then("^Update Objective title popup opens$")
	public void update_Objective_title_popup_opens() {
		// Title of Update Objective title popup displays
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_lblTitle(driver));
		String actual_lblTitle = pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_lblTitle(driver).getText();
		String expected_lblTitle = properties_value.getString("OBJ_NAME_TITLE");
		assertEquals(expected_lblTitle, actual_lblTitle);

		// Name label and asterisk symbol displays
		String actual_lblName = pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_lblName(driver).getText();
		String expected_lblName = properties_value.getString("OBJ_NAME_NAME");
		assertEquals(expected_lblName, actual_lblName);

		String actual_sybAsterisk = pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_sybAsterisk(driver)
				.getText();
		String expected_sybAsterisk = properties_value.getString("OBJ_ASTERISK");
		assertEquals(expected_sybAsterisk, actual_sybAsterisk);

		// Name textbox displays
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_txtName(driver).isDisplayed());

		// Close button displays
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_btnClose(driver).isDisplayed());

		// Update button displays
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_btnUpdate(driver).isDisplayed());
	}

	@Then("^The value in Name textbox is equal to \"([^\"]*)\"$")
	public void the_value_in_Name_textbox_is_equal_to(String expected_objName) {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_txtName(driver));
		String actual_txtName = pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_txtName(driver)
				.getAttribute("value");
		assertEquals(expected_objName, actual_txtName);
	}

	@When("^User updates the data with value is \"([^\"]*)\" into Name textbox$")
	public void user_updates_the_data_with_value_is_into_Name_textbox(String valid_value) {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_txtName(driver));
		pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_txtName(driver).clear();
		pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_txtName(driver).sendKeys(valid_value);
	}

	@When("^User submits Update Objective title popup$")
	public void user_submits_Update_Objective_title_popup() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_btnUpdate(driver));
		pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_btnUpdate(driver).click();
	}

	@Then("^Update Objective title popup closes$")
	public void update_Objective_title_popup_closes() {
		Assert.assertFalse(pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_lblTitle(driver).isDisplayed());
	}

	@Then("^Success objective update message displays$")
	public void success_objective_update_message_displays() {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.msgSuccess(driver));
		String text = pageObj_ObjDetail_QuickActions.msgSuccess(driver).getText();
		assertEquals(properties_value.getString("OBJ_UPDATE_MSG_SUCCESS"), text);
	}

	@Then("^Objective Name in Objective section is equal to \"([^\"]*)\"$")
	public void objective_Name_in_Objective_section_is_equal_to(String valid_value) {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.lblObjectiveName(driver));
		String actual_lblObjectiveName = pageObj_ObjDetail_QuickActions.lblObjectiveName(driver).getText();
		assertEquals(valid_value, actual_lblObjectiveName);
	}

	@When("^User removes data in Name textbox$")
	public void user_removes_data_in_Name_textbox() {
		pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_txtName(driver).clear();
	}

	@Then("^The error message required data displays$")
	public void the_error_message_required_data_displays() {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_msgError(driver));
		String actual_msgError = pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_msgError(driver).getText();
		String expected_msgError = properties_value.getString("OBJ_UPDATE_MSG_ERROR_REQUIRED_NAME");
		assertEquals(expected_msgError, actual_msgError);
	}

	@Then("^The error message existed data displays$")
	public void the_error_message_existed_data_displays() {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.msgError(driver));
		String actual_msgError = pageObj_ObjDetail_QuickActions.msgError(driver).getText();
		String expected_msgError = properties_value.getString("OBJ_UPDATE_MSG_ERROR_EXISTED_NAME");
		assertEquals(expected_msgError, actual_msgError);
	}

	@When("^Checking the existence or creating Objective \"([^\"]*)\"$")
	public void checking_the_existence_or_creating_Objective(String existedObjName) {
		// If the Objective is existed then do nothing
		// If the Objective does not exist then creating this Objective and back
		// to Dashboard screen
		try {
			Assert.assertTrue(pageObj_ObjDetail_QuickActions.DB_ObjectiveName(driver, existedObjName).isDisplayed());
		} catch (NoSuchElementException e) {
			create_a_new_Objective(existedObjName);
			pageObj_ObjDetail_QuickActions.menuDashboard(driver).click();
		}
	}

	@When("^User performs to close Update Objective title popup$")
	public void user_performs_to_close_Update_Objective_title_popup() {
		pageObj_ObjDetail_QuickActions.popupUpdateObjectiveTitle_btnClose(driver).click();
		sleepOfThread(3000);
	}

	public void create_a_new_Objective(String objName) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_ObjDetail_QuickActions.btnAddNewObj(driver));
		moveToElement(driver, pageObj_ObjDetail_QuickActions.btnAddNewObj(driver));
		pageObj_ObjDetail_QuickActions.btnAddNewObj(driver).click();

		pageObj_ObjDetail_QuickActions.txtName(driver).sendKeys(objName);

		pageObj_ObjDetail_QuickActions.btnAddObjective(driver).click();
		sleepOfThread(3000);
	}

	@When("^User performs to open Update weight popup$")
	public void user_performs_to_open_Update_weight_popup() {
		moveToElement(driver, pageObj_ObjDetail_QuickActions.itmUpdateWeight(driver));
		pageObj_ObjDetail_QuickActions.itmUpdateWeight(driver).click();
	}

	@Then("^Update weight popup opens$")
	public void update_weight_popup_opens() {
		// Title of Update weight popup displays
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupUpdateWeight_lblTitle(driver));
		String actual_lblTitle = pageObj_ObjDetail_QuickActions.popupUpdateWeight_lblTitle(driver).getText();
		String expected_lblTitle = properties_value.getString("OBJ_WEIGHT_TITLE");
		assertEquals(expected_lblTitle, actual_lblTitle);

		// Weight label and asterisk symbol displays
		String actual_lblWeight = pageObj_ObjDetail_QuickActions.popupUpdateWeight_lblWeight(driver).getText();
		String expected_lblWeight = properties_value.getString("OBJ_WEIGHT_WEIGHT");
		assertEquals(expected_lblWeight, actual_lblWeight);

		String actual_sybAsterisk = pageObj_ObjDetail_QuickActions.popupUpdateWeight_sybAsterisk(driver).getText();
		String expected_sybAsterisk = properties_value.getString("OBJ_ASTERISK");
		assertEquals(expected_sybAsterisk, actual_sybAsterisk);

		// Weight textbox displays
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupUpdateWeight_txtWeight(driver).isDisplayed());

		// Close button displays
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupUpdateWeight_btnClose(driver).isDisplayed());

		// Update button displays
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupUpdateWeight_btnUpdate(driver).isDisplayed());
	}

	@When("^User updates the data with value is \"([^\"]*)\" into Weight textbox$")
	public void user_updates_the_data_with_value_is_into_Weight_textbox(String valid_value) {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupUpdateWeight_txtWeight(driver));
		pageObj_ObjDetail_QuickActions.popupUpdateWeight_txtWeight(driver).clear();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='" + valid_value + "';",
				pageObj_ObjDetail_QuickActions.popupUpdateWeight_txtWeight(driver));
	}

	@When("^User submits Update weight popup$")
	public void user_submits_Update_weight_popup() {
		pageObj_ObjDetail_QuickActions.popupUpdateWeight_btnUpdate(driver).click();
		sleepOfThread(3000);
	}

	@Then("^Update weight popup closes$")
	public void update_weight_popup_closes() {
		Assert.assertFalse(pageObj_ObjDetail_QuickActions.popupUpdateWeight_lblTitle(driver).isDisplayed());
	}

	@Then("^Objective Weight in Objective section is equal to \"([^\"]*)\"$")
	public void objective_Weight_in_Objective_section_is_equal_to(String expected_objWeight) {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.txtObjectiveWeight(driver));
		String actual_txtObjectiveWeight = pageObj_ObjDetail_QuickActions.txtObjectiveWeight(driver)
				.getAttribute("value");
		assertEquals(expected_objWeight, actual_txtObjectiveWeight);
	}

	@Then("^The invalid min or max value error message displays under Weight textbox$")
	public void the_invalid_min_or_max_value_error_message_displays_under_Weight_textbox() {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupUpdateWeight_msgError(driver));
		String actual_msgError = pageObj_ObjDetail_QuickActions.popupUpdateWeight_msgError(driver).getText();
		String expected_msgError = properties_value.getString("OBJ_WEIGHT_MSG_ERROR_MINMAX");
		assertEquals(expected_msgError, actual_msgError);
	}

	@Then("^The invalid integer value error message displays under Weight textbox$")
	public void the_invalid_integer_value_error_message_displays_under_Weight_textbox() {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupUpdateWeight_msgError(driver));
		String actual_msgError = pageObj_ObjDetail_QuickActions.popupUpdateWeight_msgError(driver).getText();
		String expected_msgError = properties_value.getString("OBJ_WEIGHT_MSG_ERROR_DIGIT");
		assertEquals(expected_msgError, actual_msgError);
	}

	@When("^User performs to close Update weight popup$")
	public void user_performs_to_close_Update_weight_popup() {
		pageObj_ObjDetail_QuickActions.popupUpdateWeight_btnClose(driver).click();
		sleepOfThread(3000);
	}

	@When("^User performs to open Delete objective popup$")
	public void user_performs_to_open_Delete_objective_popup() {
		moveToElement(driver, pageObj_ObjDetail_QuickActions.itmDelete(driver));
		pageObj_ObjDetail_QuickActions.itmDelete(driver).click();
	}

	@Then("^Delete objective popup of \"([^\"]*)\" opens$")
	public void delete_objective_popup_of_opens(String objName) {
		// Title of Delete objective popup displays
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupDeleteObjective_lblTitle(driver));
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupDeleteObjective_lblTitle(driver).isDisplayed());

		// Message confirming the deletion of "<objName>" displays
		String actual_confirm_message = pageObj_ObjDetail_QuickActions.popupDeleteObjective_msgConfirm(driver, objName)
				.getText();
		String expected_confirm_message = properties_value.getString("OBJ_DELETE_MSG_CONFIRM") + objName + " ?";
		assertEquals(expected_confirm_message, actual_confirm_message);

		// Close button displays
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupDeleteObjective_btnClose(driver).isDisplayed());

		// Delete button displays
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupDeleteObjective_btnDelete(driver).isDisplayed());
	}

	@When("^User performs to close Delete objective popup$")
	public void user_performs_to_close_Delete_objective_popup() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjDetail_QuickActions.popupDeleteObjective_btnClose(driver));
		pageObj_ObjDetail_QuickActions.popupDeleteObjective_btnClose(driver).click();
		sleepOfThread(3000);
	}

	@Then("^Delete objective popup closes$")
	public void delete_objective_popup_closes() {
		Assert.assertFalse(pageObj_ObjDetail_QuickActions.popupDeleteObjective_lblTitle(driver).isDisplayed());
	}

	@When("^User confirms to delete Objective$")
	public void user_confirms_to_delete_Objective() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjDetail_QuickActions.popupDeleteObjective_btnDelete(driver));
		pageObj_ObjDetail_QuickActions.popupDeleteObjective_btnDelete(driver).click();
	}

	@Then("^Objective \"([^\"]*)\" did not display on Dashboard screen$")
	public void objective_did_not_display_on_Dashboard_screen(String objName) {
		// Go to Dashboard screen
		pageObj_ObjDetail_QuickActions.menuDashboard(driver).click();
		// Verify the deleted Objective is displayed on Dashboard screen or not?
		try {
			Assert.assertTrue(pageObj_ObjDetail_QuickActions.DB_ObjectiveName(driver, objName).isDisplayed());
			Assert.assertTrue("The deleted Objective is still displayed", false);
		} catch (NoSuchElementException e) {
			Assert.assertTrue("The deleted Objective is disappeared", true);
		}
	}

	@When("^User performs to open Link to Key Result popup$")
	public void user_performs_to_open_Link_to_Key_Result_popup() {
		// User opens Quick Actions popup of Objective
		user_opens_Quick_Actions_popup_of_Objective();

		// User performs to open Link to Key Result popup
		visibilityOfElementToBeClickable(driver, 20, pageObj_ObjDetail_QuickActions.itmLinkObjectives(driver));
		pageObj_ObjDetail_QuickActions.itmLinkObjectives(driver).click();
	}

	@Then("^The components of Select Group screen displays$")
	public void the_components_of_Select_Group_screen_displays() {
		// Title of Link to Key Result popup displays
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_lblTitle(driver));
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_lblTitle(driver).isDisplayed());

		// Close icon displays in Link to Key Result popup
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_icoClose(driver).isDisplayed());

		// Group label displays in Link to Key Result popup
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_lblGroup(driver).isDisplayed());

		// Group dropdown displays in Link to Key Result popup
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlGroup(driver).isDisplayed());

		// Next button at Select Group screen displays in Link to Key Result
		// popup
		Assert.assertTrue(
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnNext_SelectGroup(driver).isDisplayed());
	}

	@When("^User performs to close Link to Key Result popup$")
	public void user_performs_to_close_Link_to_Key_Result_popup() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_icoClose(driver));
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_icoClose(driver).click();
		sleepOfThread(3000);
	}

	@Then("^Link to Key Result popup closes$")
	public void link_to_Key_Result_popup_closes() {
		Assert.assertFalse(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_lblTitle(driver).isDisplayed());
	}

	@When("^User opens Group dropdown$")
	public void user_opens_Group_dropdown() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlGroup(driver));
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlGroup(driver).click();
	}

	@Then("^Group dropdown menu of Group dropdown displays$")
	public void group_dropdown_menu_of_Group_dropdown_displays() {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlGroup_mennu(driver));
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlGroup_mennu(driver).isDisplayed());
	}

	@Then("^Search textbox displays in Group dropdown menu$")
	public void search_textbox_displays_in_Group_dropdown_menu() {
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlGroup_txtSearch(driver).isDisplayed());
	}

	@When("^User enters keyword not match into Search textbox$")
	public void user_enters_keyword_not_match_into_Search_textbox() {
		String keyword = properties_value.getString("OBJ_LINKOBJ_SEARCH_GROUP_NOT_EXIST");
		user_opens_Group_dropdown();
		user_enters_keyword_into_Search_textbox(keyword);
	}

	@Then("^Nothing selected text displays in Group dropdown$")
	public void nothing_selected_text_displays_in_Group_dropdown() {
		String actual_text = pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlGroup(driver).getText();
		String expected_text = properties_value.getString("OBJ_LINKOBJ_GROUP_NOTHING_SELECTED");
		assertEquals(expected_text, actual_text);
	}

	@When("^User performs to submit at Select Group screen$")
	public void user_performs_to_submit_at_Select_Group_screen() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnNext_SelectGroup(driver));
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnNext_SelectGroup(driver).click();
	}

	@Then("^The error message for case no choice Group displays$")
	public void the_error_message_for_case_no_choice_Group_displays() {
		String actual_msgError = pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_msgError_SelectGroup(driver)
				.getText();
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
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_lblTitle(driver));
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_lblTitle(driver).isDisplayed());

		// Close icon displays in Link to Key Result popup
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_icoClose(driver).isDisplayed());

		// Objectives label displays in Link to Key Result popup
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_lblObjectives(driver));
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_lblObjectives(driver).isDisplayed());

		// List of Objective displays in Link to Key Result popup
		list_of_Objective_displays_in_Link_to_Key_Result_popup();

		// Back button at Select Objective screen displays in Link to Key Result
		// popup
		Assert.assertTrue(
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnBack_SelectObjective(driver).isDisplayed());

		// Next button at Select Objective screen displays in Link to Key Result
		// popup
		Assert.assertTrue(
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnNext_SelectObjective(driver).isDisplayed());
	}

	@Then("^Message there is no objective displays in Link to Key Result popup$")
	public void message_there_is_no_objective_displays_in_Link_to_Key_Result_popup() {
		Assert.assertTrue(
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_msgNoObjectiveInGroup(driver).isDisplayed());
	}

	@When("^User selects valid Group and go to the next step$")
	public void user_selects_valid_Group_and_go_to_the_next_step() {
		String keyword = properties_value.getString("OBJ_LINKOBJ_GROUP_HAS_OBJ");
		user_opens_Group_dropdown();
		user_enters_keyword_into_Search_textbox(keyword);
		user_performs_to_submit_at_Select_Group_screen();
	}

	@Then("^List of Objective displays in Link to Key Result popup$")
	public void list_of_Objective_displays_in_Link_to_Key_Result_popup() {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_lstObjective(driver));
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_lstObjective(driver).isDisplayed());
	}

	@When("^User performs to back the previous screen at Select Objective screen$")
	public void user_performs_to_back_the_previous_screen_at_Select_Objective_screen() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnBack_SelectObjective(driver));
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnBack_SelectObjective(driver).click();
	}

	@When("^User performs to submit at Select Objective screen$")
	public void user_performs_to_submit_at_Select_Objective_screen() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnNext_SelectObjective(driver));
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnNext_SelectObjective(driver).click();
	}

	@Then("^The error message for case no choice Objective displays$")
	public void the_error_message_for_case_no_choice_Objective_displays() {
		String actual_msgError = pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_msgError_SelectObjective(driver)
				.getText();
		String expected_msgError = properties_value.getString("OBJ_LINKOBJ_NO_CHOICE_OBJ");
		assertEquals(expected_msgError, actual_msgError);
	}

	@Given("^User navigates to Group details screen of another Group$")
	public void user_navigates_to_Group_details_screen_of_another_Group() {
		// Go to another Group via Left menu
		visibilityOfElementToBeClickable(driver, 20, pageObj_ObjDetail_QuickActions.menuMyGroups(driver));
		pageObj_ObjDetail_QuickActions.menuMyGroups(driver).click();

		String anotherGroup = properties_value.getString("OBJ_LINKOBJ_GROUP_HAS_OBJ");
		pageObj_ObjDetail_QuickActions.menuMyGroups_Group(driver, anotherGroup).click();
	}

	@When("^User navigates to Objective \"([^\"]*)\" has Key Result \"([^\"]*)\"$")
	public void user_navigates_to_Objective_has_Key_Result(String objName, String krName) {
		user_navigates_to_Objective(objName);
		checking_the_existence_or_creating_Key_Result_for_Objective(krName);
	}

	@When("^User goes to Dashboard screen and navigates to Objective \"([^\"]*)\"$")
	public void user_goes_to_Dashboard_screen_and_navigates_to_Objective(String objName) {
		pageObj_ObjDetail_QuickActions.menuDashboard(driver).click();
		user_navigates_to_Objective(objName);
	}

	@When("^User selects the Objective \"([^\"]*)\" and go to the next step$")
	public void user_selects_the_Objective_and_go_to_the_next_step(String objName) {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_radioObjective(driver, objName));
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_radioObjective(driver, objName).click();

		// User performs to submit at Select Objective screen
		user_performs_to_submit_at_Select_Objective_screen();
	}

	@Then("^The components of Select Key Result screen with the selected Objective \"([^\"]*)\" displays$")
	public void the_components_of_Select_Key_Result_screen_with_the_selected_Objective_displays(String objNameNew) {
		// Title of Link to Key Result popup displays
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_lblTitle(driver));
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_lblTitle(driver).isDisplayed());

		// Close icon displays in Link to Key Result popup
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_icoClose(driver).isDisplayed());

		// Key Result label displays in Link to Key Result popup
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_lblKeyResult(driver).isDisplayed());

		// Key Result dropdown displays in Link to Key Result popup
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlKeyResult(driver).isDisplayed());

		// Placeholder of Key Result dropdown displays in Link to Key Result
		// popup
		String actual_placeholder = pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlKeyResult(driver).getText();
		String expected_placeholder = properties_value.getString("OBJ_LINKOBJ_PLACEHOLDER_KR") + objNameNew;
		assertEquals(expected_placeholder, actual_placeholder);

		// Back button at Select Key Result screen displays in Link to Key
		// Result popup
		Assert.assertTrue(
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnBack_SelectKeyResult(driver).isDisplayed());

		// Submit button at Select Key Result screen displays in Link to Key
		// Result popup
		Assert.assertTrue(
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnSubmit_SelectKeyResult(driver).isDisplayed());
	}

	@Given("^User opens Key Result dropdown$")
	public void user_opens_Key_Result_dropdown() {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlKeyResult(driver));
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlKeyResult(driver).click();
	}

	@Then("^Key Result dropdown menu of Key Result dropdown displays$")
	public void key_Result_dropdown_menu_of_Key_Result_dropdown_displays() {
		// Key Result dropdown menu displays
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlKeyResult_mennu(driver));
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlKeyResult_mennu(driver).isDisplayed());

		// Select All button displays
		Assert.assertTrue(
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnSelectAll_SelectKeyResult(driver).isDisplayed());

		// Deselect All button displays
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnDeselectAll_SelectKeyResult(driver)
				.isDisplayed());
	}

	@Given("^User performs to back the previous screen at Select Key Result screen$")
	public void user_performs_to_back_the_previous_screen_at_Select_Key_Result_screen() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnBack_SelectKeyResult(driver));
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnBack_SelectKeyResult(driver).click();
	}

	@Given("^User performs to submit at Select Key Result screen$")
	public void user_performs_to_submit_at_Select_Key_Result_screen() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnSubmit_SelectKeyResult(driver));
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnSubmit_SelectKeyResult(driver).click();
	}

	@Then("^The error message for case no choice Key Result displays$")
	public void the_error_message_for_case_no_choice_Key_Result_displays() {
		String actual_msgError = pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_msgError_SelectKeyRessult(driver)
				.getText();
		String expected_msgError = properties_value.getString("OBJ_LINKOBJ_NO_CHOICE_KR");
		assertEquals(expected_msgError, actual_msgError);
	}

	@Given("^User opens and selects Key Result \"([^\"]*)\" in Key Result dropdown$")
	public void user_opens_and_selects_Key_Result_in_Key_Result_dropdown(String krName) {
		// User opens Key Result dropdown
		user_opens_Key_Result_dropdown();

		// User selects Key Result
		visibilityOf(driver, 20,
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_krName_SelectKeyResult(driver, krName));
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_krName_SelectKeyResult(driver, krName).click();
	}

	@Then("^The selected Key Result \"([^\"]*)\" displays in Key Result dropdown$")
	public void the_selected_Key_Result_displays_in_Key_Result_dropdown(String krName) {
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlKeyResult_Selected(driver, krName)
				.isDisplayed());
	}

	@When("^User opens and performs to select all of Key Result in Key Result dropdown$")
	public void user_opens_and_performs_to_select_all_of_Key_Result_in_Key_Result_dropdown() {
		// User opens Key Result dropdown
		user_opens_Key_Result_dropdown();

		// User selects all of Key Result
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnSelectAll_SelectKeyResult(driver));
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnSelectAll_SelectKeyResult(driver).click();

		// Collapse Key Result dropdown menu by click on Title
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_lblTitle(driver).click();
	}

	@Then("^The all of Key Result \"([^\"]*)\" and \"([^\"]*)\" displays in Key Result dropdown$")
	public void the_all_of_Key_Result_and_displays_in_Key_Result_dropdown(String krName1, String krName2) {
		Assert.assertTrue(pageObj_ObjDetail_QuickActions
				.popupLinkToKeyResult_ddlKeyResult_multiSelected(driver, krName1, krName2).isDisplayed());

		// Expand Key Result dropdown menu by click on
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlKeyResult_multiSelected(driver, krName1, krName2)
				.click();
	}

	@When("^User performs to deselect all of Key Result in Key Result dropdown$")
	public void user_performs_to_deselect_all_of_Key_Result_in_Key_Result_dropdown() {
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnDeselectAll_SelectKeyResult(driver).click();
	}

	@Then("^Reset the data and display the placeholder with the selected Objective \"([^\"]*)\" in Key Result dropdown$")
	public void reset_the_data_and_display_the_placeholder_with_the_selected_Objective_in_Key_Result_dropdown(
			String objNameNew) {
		String actual_placeholder = pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlKeyResult(driver).getText();
		String expected_placeholder = properties_value.getString("OBJ_LINKOBJ_PLACEHOLDER_KR") + objNameNew;
		assertEquals(expected_placeholder, actual_placeholder);
	}

	@Then("^Link to Key Result successfully popup displays$")
	public void link_to_Key_Result_successfully_popup_displays() {
		// Success ring displays
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_SuccessRing(driver));
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_SuccessRing(driver).isDisplayed());

		// Message "Request has been sent" displays
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_msgRequestSent(driver).isDisplayed());

		// Message "Waiting for approval" displays
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_msgWaitFor(driver).isDisplayed());

		// OK button displays
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_btnOK(driver).isDisplayed());
	}

	@When("^User navigates to Objective \"([^\"]*)\" has Key Result \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_navigates_to_Objective_has_Key_Result_and(String objNameNew, String krName1, String krName2) {
		user_navigates_to_Objective(objNameNew);
		checking_the_existence_or_creating_Key_Result_for_Objective(krName1);
		checking_the_existence_or_creating_Key_Result_for_Objective(krName2);
	}
	
	@When("User enters keyword is a group that has Objective into Search textbox$")
	public void user_enters_keyword_is_a_group_that_has_Objective_into_Search_textbox (){
		String keyword = properties_value.getString("OBJ_LINKOBJ_GROUP_HAS_OBJ");
		user_opens_Group_dropdown();
		user_enters_keyword_into_Search_textbox(keyword);		
	}

	public void user_enters_keyword_into_Search_textbox(String keyword) {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlGroup_txtSearch(driver));
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlGroup_txtSearch(driver).sendKeys(keyword);

		// waiting for search result displays and gets the selected item as
		// data in Group dropdown
		sleepOfThread(3000);
		pageObj_ObjDetail_QuickActions.popupLinkToKeyResult_ddlGroup(driver).click();
	}

	public void checking_the_existence_or_creating_Key_Result_for_Objective(String krName) {
		// If the Key Result is existed then do nothing
		// If the Key Result does not exist then creating this Key Result
		try {
			Assert.assertTrue(pageObj_ObjDetail_QuickActions.KeyResultName(driver, krName).isDisplayed());
		} catch (NoSuchElementException e) {
			pageObj_ObjDetail_QuickActions.btnAddKeyResult(driver).click();

			visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupAddKeyResult_txtName(driver));
			pageObj_ObjDetail_QuickActions.popupAddKeyResult_txtName(driver).sendKeys(krName);
			pageObj_ObjDetail_QuickActions.popupAddKeyResult_btnAdd(driver).click();
			sleepOfThread(3000);
		}
	}
}