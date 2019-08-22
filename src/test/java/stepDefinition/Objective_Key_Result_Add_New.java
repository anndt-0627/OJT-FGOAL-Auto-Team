package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_Objective_Key_Result_Add_New;
import utility.Common;

public class Objective_Key_Result_Add_New extends Common {
	ResourceBundle properties_value;
	private WebDriver driver;

	public Objective_Key_Result_Add_New() {
		this.driver = Hooks.getDriver();
	}

	@Given("^User is on Dashboard screen$")
	public void user_is_on_Dashboard_screen() {
		pageObj_Objective_Key_Result_Add_New.btDashboard(driver).click();
	}

	@When("^User create a new Objective with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_create_a_new_Objective_with_and(String ObjectiveName, String ObjectWeight) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.btnAddNewObj(driver));
		moveToElement(driver, pageObj_Objective_Key_Result_Add_New.btnAddNewObj(driver));
		pageObj_Objective_Key_Result_Add_New.btnAddNewObj(driver).click();
		pageObj_Objective_Key_Result_Add_New.txtName(driver).sendKeys(ObjectiveName);

		pageObj_Objective_Key_Result_Add_New.txtWeight(driver).clear();
		pageObj_Objective_Key_Result_Add_New.txtWeight(driver).sendKeys(ObjectWeight);

		pageObj_Objective_Key_Result_Add_New.btnAddObjective(driver).click();
	}

	@When("^User open objective details$")
	public void user_clicks_on_item_in_My_Objectives(String ObjectiveName) {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_Key_Result_Add_New.linkObjectiveName(driver, ObjectiveName));
		moveToElement(driver, pageObj_Objective_Key_Result_Add_New.linkObjectiveName(driver, ObjectiveName));
		pageObj_Objective_Key_Result_Add_New.linkObjectiveName(driver, ObjectiveName).click();
		visibilityOf(driver, 20, pageObj_Objective_Key_Result_Add_New.lblObjectiveName(driver, ObjectiveName));
	}

	@When("^User click on button Add a new key result$")
	public void user_clicks_on_button_add_a_new_key_result() {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.bttAddNewKeyResult(driver));
		moveToElement(driver, pageObj_Objective_Key_Result_Add_New.bttAddNewKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.bttAddNewKeyResult(driver).click();
	}

	@Then("^Popup Add new key result for \"([^\\\"]*)\" is displayed$")
	public void popup_add_new_key_result_for_is_displayed(String ObjectiveName) {
		Assert.assertTrue(pageObj_Objective_Key_Result_Add_New.popupAddNewKeyResult(driver).isDisplayed());
		Assert.assertTrue(pageObj_Objective_Key_Result_Add_New.popupheaderAddNewKeyResult(driver).isDisplayed());
		String expected_header = "Add new Key Result for:" + ObjectiveName;
		String actual_header = pageObj_Objective_Key_Result_Add_New.popupheaderAddNewKeyResult(driver).getText();
		assertEquals(expected_header, actual_header);
	}

	@When("^User input valid value for \"([^\\\"]*)\" and \"([^\\\"]*)\" and \"([^\"]*)\"and \"([^\\\"]*)\"$")
	public void user_input(String Keyresult_Name, String Keyresult_Weight, String Keyresult_Target,
			String Keyresult_Unit) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.txtNameKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.txtNameKeyResult(driver).clear();
		pageObj_Objective_Key_Result_Add_New.txtNameKeyResult(driver).sendKeys(Keyresult_Name);
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.txtWeightKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.txtWeightKeyResult(driver).clear();
		pageObj_Objective_Key_Result_Add_New.txtWeightKeyResult(driver).sendKeys(Keyresult_Weight);
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.txttargetKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.txttargetKeyResult(driver).clear();
		pageObj_Objective_Key_Result_Add_New.txttargetKeyResult(driver).sendKeys(Keyresult_Target);
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_Key_Result_Add_New.dropdownUnitKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.dropdownUnitKeyResult(driver).click();

	}

	@When("^User perform Add new key result action$")
	public void user_perform_add_new_key_result_action() {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_Key_Result_Add_New.popupbttAddNewKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.popupbttAddNewKeyResult(driver).click();
	}

	@Then("^A new key result of object is created$")
	public void a_new_ket_result_of_object_is_created(String ObjectiveName, String NewKeyResult) {
		visibilityOf(driver, 20, pageObj_Objective_Key_Result_Add_New.lblObjectiveName(driver, ObjectiveName));
		visibilityOf(driver, 20, pageObj_Objective_Key_Result_Add_New.linkNewKeyResult(driver, NewKeyResult));
		String actual_key_result_name = pageObj_Objective_Key_Result_Add_New.linkNewKeyResult(driver, NewKeyResult)
				.getText();
		assertEquals(NewKeyResult, actual_key_result_name);
	}

	@When("^User leave key result name blank and User leave Key result target blank and input valid value for \"([^\\\"]*)\" and \"([^\\\"]*)\" and \"([^\\\"]*)\"$")
	public void user_leave_key_result_name_blank(String Keyresult_Weight, String Keyresult_Target,
			String Keyresult_Unit) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.txtNameKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.txtNameKeyResult(driver).clear();
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.txtWeightKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.txtWeightKeyResult(driver).clear();
		pageObj_Objective_Key_Result_Add_New.txtWeightKeyResult(driver).sendKeys(Keyresult_Weight);
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.txttargetKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.txttargetKeyResult(driver).clear();
		pageObj_Objective_Key_Result_Add_New.txttargetKeyResult(driver).sendKeys(Keyresult_Target);
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_Key_Result_Add_New.dropdownUnitKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.dropdownUnitKeyResult(driver).click();

	}

	@Then("^An \"([^\\\"]*)\" is displayed at field Key result name$")
	public void an_is_displayed_at_field_key_result_name(String Error_Message) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.msgErrorName(driver));
		String actual_error_message = pageObj_Objective_Key_Result_Add_New.msgErrorName(driver).getText();
		assertEquals(Error_Message, actual_error_message);
	}

	@When("^User leave Key result target blank and input valid value for \"([^\\\"]*)\" and \"([^\"]*)\\\" and \"([^\\\"]*)\"$")
	public void user_leave_key_result_weight_blank(String Keyresult_Name, String Keyresult_Weight,
			String Keyresult_Unit) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.txtNameKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.txtNameKeyResult(driver).clear();
		pageObj_Objective_Key_Result_Add_New.txtNameKeyResult(driver).sendKeys(Keyresult_Name);
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.txtWeightKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.txtWeightKeyResult(driver).clear();
		pageObj_Objective_Key_Result_Add_New.txtWeightKeyResult(driver).sendKeys(Keyresult_Weight);
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.txttargetKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.txttargetKeyResult(driver).clear();
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_Key_Result_Add_New.dropdownUnitKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.dropdownUnitKeyResult(driver).click();

	}

	@Then("^An \"([^\\\"]*)\" is displayed at field Key result target$")
	public void an_is_displayed_at_field_key_result_target(String Error_Message) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.msgErrorTarget(driver));
		String actual_error_message = pageObj_Objective_Key_Result_Add_New.msgErrorTarget(driver).getText();
		assertEquals(Error_Message, actual_error_message);
	}

	@When("^User leave Key result name and target blank and input valid value for \"([^\\\"]*)\" and \"([^\"]*)\\\"$")
	public void user_leave_key_result_name_and_target_blank(String Keyresult_Weight, String Keyresult_Unit) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.txtNameKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.txtNameKeyResult(driver).clear();
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.txtWeightKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.txtWeightKeyResult(driver).clear();
		pageObj_Objective_Key_Result_Add_New.txtWeightKeyResult(driver).sendKeys(Keyresult_Weight);
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.txttargetKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.txttargetKeyResult(driver).clear();
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Objective_Key_Result_Add_New.dropdownUnitKeyResult(driver));
		pageObj_Objective_Key_Result_Add_New.dropdownUnitKeyResult(driver).click();

	}

	@Then("^\"([^\\\"]*)\" and \"([^\\\"]*)\" are displayed$")
	public void and_are_displayed(String Error_Message1, String Error_Message2) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.msgErrorName(driver));
		String actual_error_message1 = pageObj_Objective_Key_Result_Add_New.msgErrorName(driver).getText();
		assertEquals(Error_Message1, actual_error_message1);
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_Add_New.msgErrorTarget(driver));
		String actual_error_message2 = pageObj_Objective_Key_Result_Add_New.msgErrorTarget(driver).getText();
		assertEquals(Error_Message2, actual_error_message2);
	}
}
