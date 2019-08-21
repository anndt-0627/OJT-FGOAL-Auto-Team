package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.PageObj_Add_New_Objective;
import pageObject.PageObj_ObjDetail_KR_Options;
import pageObject.PageObj_Objective_LinkTo;
import pageObject.pageObj_ObjDetail_KR_QuickActionPopup;
import pageObject.pageObj_ObjDetail_QuickActions;
import utility.Common;

public class ObjDetail_KeyResult_Options extends Common {
	
	private WebDriver driver;
	ResourceBundle input_value = ResourceBundle.getBundle("data_objective_keyresult");
	SimpleDateFormat Dateformat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	Date date = new Date();
	private String currenttime = Dateformat.format(date);

	public ObjDetail_KeyResult_Options() {
		this.driver = Hooks.getDriver();
	}
	public void checking_the_existence_KR_or_creating_Key_Result_for_Objective(String krName, String weight, String target) {
		// If the Key Result is existed then do nothing
		// If the Key Result does not exist then creating this Key Result
		try {
			Assert.assertTrue(pageObj_ObjDetail_QuickActions.KeyResultName(driver, krName).isDisplayed());
		} catch (NoSuchElementException e) {
			pageObj_ObjDetail_QuickActions.btnAddKeyResult(driver).click();

			visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupAddKeyResult_txtName(driver));
			pageObj_ObjDetail_QuickActions.popupAddKeyResult_txtName(driver).sendKeys(krName);
			pageObj_ObjDetail_QuickActions.popupAddKeyResult_txtWeight(driver).clear();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].value='" + weight + "';",
					pageObj_ObjDetail_QuickActions.popupAddKeyResult_txtWeight(driver));
			pageObj_ObjDetail_QuickActions.popupAddKeyResult_txtTarget(driver).sendKeys(target);
			pageObj_ObjDetail_QuickActions.popupAddKeyResult_btnAdd(driver).click();
			sleepOfThread(3000);
		}
	}
	
	@When("^User navigates to Objective \"([^\"]*)\" has Key Result \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_navigates_to_Objective_has_Key_Result(String objName, String krName, String weight, String target) {
		ObjDetail_QuickActions navigate = new ObjDetail_QuickActions();
		navigate.user_navigates_to_Objective(objName);
		checking_the_existence_KR_or_creating_Key_Result_for_Objective(krName, weight, target);
	}
	
	@When("^User opens Change \"([^\"]*)\" popup$")
	public void user_opens_Change_KR_name_popup(String krName) throws Throwable {
		visibilityOf(driver, 20, PageObj_ObjDetail_KR_Options.KR_QuickAction_btn_ChangeName(driver, krName));
		PageObj_ObjDetail_KR_Options.KR_QuickAction_btn_ChangeName(driver, krName).click();
	}

	@Then("^Pre-fill name in textbox is matched with current \"([^\"]*)\"$")
	public void pre_fill_name_in_textbox_is_matched_with_current(String curent_krname) throws Throwable {
		visibilityOf(driver, 20, PageObj_ObjDetail_KR_Options.KR_Changename_txb_name(driver));
		String krname = PageObj_ObjDetail_KR_Options.KR_Changename_txb_name(driver).getText();
		Assert.assertEquals(krname, curent_krname);
	}

	@Given("^Check other Key Result is existing$")
	public void check_other_Key_Result_is_existing() throws Throwable {
		String krName = input_value.getString("EXISKR");
		String weight = input_value.getString("EXISKR_WEIGHT");
		String target = input_value.getString("EXISKR_TARGET");
		checking_the_existence_KR_or_creating_Key_Result_for_Objective(krName, weight, target);
	}

	@When("^User enter name into textbox as name of exting key result$")
	public void user_enter_name_into_textbox_as_name_of_exting_key_result() throws Throwable {
		String krName = input_value.getString("EXISKR");
		visibilityOf(driver, 20, PageObj_ObjDetail_KR_Options.KR_Changename_txb_name(driver));
		PageObj_ObjDetail_KR_Options.KR_Changename_txb_name(driver).sendKeys(krName);
	}

	@When("^User performs to change KR name$")
	public void user_performs_to_change_KR_name() throws Throwable {
		visibilityOf(driver, 20, PageObj_ObjDetail_KR_Options.KR_Changename_btn_update(driver));
	    PageObj_ObjDetail_KR_Options.KR_Changename_btn_update(driver).click();
	}

	@Then("^Error \"([^\"]*)\" displays in Change KR name popup$")
	public void error_message_displays_in_Change_KR_name_popup(String message) throws Throwable {
		visibilityOf(driver, 20, PageObj_ObjDetail_KR_Options.KR_Changename_lb_error(driver));
		String actual = PageObj_ObjDetail_KR_Options.KR_Changename_lb_error(driver).getText();
		Assert.assertEquals(actual, message);
	}

	@When("^User clear text in name textbox$")
	public void user_clear_text_in_name_textbox() throws Throwable {
		visibilityOf(driver, 20, PageObj_ObjDetail_KR_Options.KR_Changename_txb_name(driver));
		PageObj_ObjDetail_KR_Options.KR_Changename_txb_name(driver).clear();
	}
	@When("^User enter valid name into textbox$")
	public void user_enter_valid_name_into_textbox() throws Throwable {
		String krName = input_value.getString("EXISKR");
		visibilityOf(driver, 10, PageObj_ObjDetail_KR_Options.KR_Changename_txb_name(driver));
		PageObj_ObjDetail_KR_Options.KR_Changename_txb_name(driver).sendKeys(krName + currenttime);
	}
	
	@When("^User performs to close change name popup$")
	public void user_performs_to_close_change_name_popup() throws Throwable {
		visibilityOf(driver, 10, PageObj_ObjDetail_KR_Options.KR_Changename_btn_close(driver));
		PageObj_ObjDetail_KR_Options.KR_Changename_btn_close(driver).click();;
	}
	
	@Then("^\"([^\"]*)\" displays on Objective Details screen$")
	public void message_displays_on_Objective_Details_screen(String message) throws Throwable {
		visibilityOf(driver, 20, PageObj_ObjDetail_KR_Options.ObjDetail_KR_lb_message(driver));
		String actual = PageObj_ObjDetail_KR_Options.ObjDetail_KR_lb_message(driver).getText();
		Assert.assertEquals(actual, message);
	}

	@Then("^Name of KR is updated$")
	public void name_of_KR_is_updated() throws Throwable {
		String krName = input_value.getString("EXISKR");
	    Assert.assertTrue(PageObj_ObjDetail_KR_Options.ObjDetail_KR_record(driver, krName + currenttime).isDisplayed());
	}
	
	@When("^User opens Change Weight popup of KR \"([^\"]*)\"$")
	public void user_opens_Change_Weight_popup_of_KR(String krName) throws Throwable {
		visibilityOf(driver, 20, PageObj_ObjDetail_KR_Options.KR_QuickAction_btn_Changeweight(driver, krName));
		PageObj_ObjDetail_KR_Options.KR_QuickAction_btn_Changeweight(driver, krName).click();
	}
	@Then("^Name of KR \"([^\"]*)\" is not changed$")
	public void name_of_KR_is_not_changed(String krName) throws Throwable {
		Assert.assertTrue(pageObj_ObjDetail_QuickActions.KeyResultName(driver, krName).isDisplayed());
	}
	
	@When("^User updates the data with value is \"([^\"]*)\" into KR Weight textbox$")
	public void user_updates_the_data_with_value_is_into_KR_Weight_textbox(String valid_value) throws Throwable {
		visibilityOf(driver, 20, pageObj_ObjDetail_QuickActions.popupUpdateWeight_txtWeight(driver));
		PageObj_ObjDetail_KR_Options.KR_QuickAction_Changeweight_txb_weight(driver).clear();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='" + valid_value + "';",
				PageObj_ObjDetail_KR_Options.KR_QuickAction_Changeweight_txb_weight(driver));
	}

	@When("^User submits Update KR weight popup$")
	public void user_submits_Update_KR_weight_popup() throws Throwable {
		visibilityOf(driver, 20, PageObj_ObjDetail_KR_Options.KR_QuickAction_Changeweight_btn_update(driver));
		PageObj_ObjDetail_KR_Options.KR_QuickAction_Changeweight_btn_update(driver).clear();
	}

	@Then("^The invalid min or max value error message displays under KR Weight textbox$")
	public void the_invalid_min_or_max_value_error_message_displays_under_KR_Weight_textbox() throws Throwable {
		visibilityOf(driver, 20, PageObj_ObjDetail_KR_Options.KR_QuickAction_Changeweight_lb_errormessage(driver));
		String actual_msgError = PageObj_ObjDetail_KR_Options.KR_QuickAction_Changeweight_lb_errormessage(driver).getText();
		String expected_msgError = input_value.getString("OBJ_WEIGHT_MSG_ERROR_MINMAX");
		assertEquals(expected_msgError, actual_msgError);
	}

	@Then("^The invalid integer value error message displays under KR Weight textbox$")
	public void the_invalid_integer_value_error_message_displays_under_KR_Weight_textbox() throws Throwable {
		visibilityOf(driver, 20, PageObj_ObjDetail_KR_Options.KR_QuickAction_Changeweight_lb_errormessage(driver));
		String actual_msgError = PageObj_ObjDetail_KR_Options.KR_QuickAction_Changeweight_lb_errormessage(driver).getText();
		String expected_msgError = input_value.getString("OBJ_WEIGHT_MSG_ERROR_DIGIT");
		assertEquals(expected_msgError, actual_msgError);
	}
	@Then("^Change KR Weight popup is closed$")
	public void change_KR_Weight_popup_is_closed ()throws Throwable {
		Assert.assertFalse(PageObj_ObjDetail_KR_Options.KR_QuickAction_Changeweight_popup(driver).isDisplayed());
	}
	
	@When("^User performs to close change KR weight popup$")
	public void user_performs_to_close_change_KR_weight_popup() throws Throwable {
		visibilityOf(driver, 10, PageObj_ObjDetail_KR_Options.KR_QuickAction_Changeweight_btn_close(driver));
		PageObj_ObjDetail_KR_Options.KR_QuickAction_Changeweight_btn_close(driver).click();;
	}
	
	@When("^User performs to update KR weight$")
	public void user_performs_to_update_KR_weight() throws Throwable {
		visibilityOf(driver, 10, PageObj_ObjDetail_KR_Options.KR_QuickAction_Changeweight_btn_update(driver));
		PageObj_ObjDetail_KR_Options.KR_QuickAction_Changeweight_btn_update(driver).click();
	}
	
}
