package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_Objective_Key_Result_View;
import utility.Common;

public class Objective_Key_Result_View extends Common {
	ResourceBundle properties_value;
	private WebDriver driver;

	public Objective_Key_Result_View() {
		this.driver = Hooks.getDriver();
	}
	
	@When ("^User open popup detail \"([^\\\"]*)\" $")
		public void user_open_popup_detail(String Keyresult_Name) {
			visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_View.linkNewKeyResult(driver, Keyresult_Name));
			moveToElement(driver, pageObj_Objective_Key_Result_View.linkNewKeyResult(driver, Keyresult_Name));
			pageObj_Objective_Key_Result_View.linkNewKeyResult(driver, Keyresult_Name).click();
		}
	
	@Then ("^Popup key result details is displayed with exactly \"([^\\\"]*)\"$")
	public void popup_key_result_details_is_displayed_with_exactly(String Keyresult_Name) {
		Assert.assertTrue(pageObj_Objective_Key_Result_View.popupKeyResultDetail(driver).isDisplayed());
		Assert.assertTrue(pageObj_Objective_Key_Result_View.popupheaderKeyResult(driver).isDisplayed());
		String expected_header = Keyresult_Name;
		String actual_header = pageObj_Objective_Key_Result_View.popupheaderKeyResult(driver).getText();
		assertEquals(expected_header, actual_header);
	}
	@Then ("^\"([^\\\"]*)\" is displayed exactly $")
	public void is_displayed_exactly(String Keyresult_Weight) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_View.txtWeightKeyResult(driver));
		String expected_weight = Keyresult_Weight;
		String actual_weight = pageObj_Objective_Key_Result_View.txtWeightKeyResult(driver).getText();
		assertEquals(expected_weight, actual_weight);
	}
	@When ("^User click on button Close $")
	public void user_click_on_button_close(String Keyresult_Name) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_View.popupbttClose(driver));
		pageObj_Objective_Key_Result_View.popupbttClose(driver).click();
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objective_Key_Result_View.linkNewKeyResult(driver, Keyresult_Name));
	}
}
