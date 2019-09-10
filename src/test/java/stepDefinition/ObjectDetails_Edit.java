package stepDefinition;

import java.util.ResourceBundle;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_ObjectDetails_Edit;
import utility.Common;

public class ObjectDetails_Edit extends Common {
	ResourceBundle properties_value = ResourceBundle.getBundle("dataObjective_QuickActions");
	private WebDriver driver;

	public ObjectDetails_Edit() {
		this.driver = Hooks.getDriver();
	}

	@Given("^User navigate to Dashboard screen$")
	public void user_back_to_Dashboard_screen() {
		pageObj_ObjectDetails_Edit.menuDashboard(driver).click();
	}

	@When("^User click on \"([^\"]*)\" item in My Objectives$")
	public void user_click_on_item_in_My_Objectives(String ObjectiveName) {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjectDetails_Edit.DB_ObjectiveName(driver, ObjectiveName));
		moveToElement(driver, pageObj_ObjectDetails_Edit.DB_ObjectiveName(driver, ObjectiveName));
		pageObj_ObjectDetails_Edit.DB_ObjectiveName(driver, ObjectiveName).click();
	}
	
	@When ("^User click on item Configure the objective calculation progress$")
	public void user_click_on_item_Configure_the_objective_calculation_progress(){
		visibilityOf(driver, 20, pageObj_ObjectDetails_Edit.ObjectiveConfigure(driver));
		pageObj_ObjectDetails_Edit.ObjectiveConfigure(driver).click();
	}
	
	@When ("^User click on item Update progress manual$")
	public void user_click_on_item_Update_progress_manual(){
		visibilityOf(driver, 20, pageObj_ObjectDetails_Edit.ObjectiveUpdateManual(driver));
		pageObj_ObjectDetails_Edit.ObjectiveUpdateManual(driver).click();
	}
	
	@When ("^User input \"([^\\\"]*)\" for progress value$")
	public void user_input_for_progress_value(String ValidPercent){
		visibilityOf(driver, 20, pageObj_ObjectDetails_Edit.ObjectiveActualValue(driver));
		pageObj_ObjectDetails_Edit.ObjectiveUpdateManual(driver).clear();
		pageObj_ObjectDetails_Edit.ObjectiveUpdateManual(driver).sendKeys(ValidPercent);
	}
	
	@When ("^User click on button Update$")
	public void user_click_on_button_Update() {
		visibilityOf(driver, 20, pageObj_ObjectDetails_Edit.ObjectiveButtonUpdate(driver));
		pageObj_ObjectDetails_Edit.ObjectiveButtonUpdate(driver).click();
	}
	
	@Then ("^ \"([^\\\"]*)\" user has just input is accepted$")
	public void user_has_just_input_is_accepted(String ValidPercent) {
		visibilityOf(driver, 20, pageObj_ObjectDetails_Edit.ObjectiveCurentProgress(driver));
		String actualPercent = pageObj_ObjectDetails_Edit.ObjectiveCurentProgress(driver).getAttribute("value");
			assertEquals(ValidPercent, actualPercent);
	}
	
	@Then ("^New percent of objective user has done is updated$")
	public void new_percent_of_objective_user_has_odne_is_updated(String ValidPercent) {
		visibilityOf(driver, 20, pageObj_ObjectDetails_Edit.ObjectivePercent(driver));
		String actualPercent = pageObj_ObjectDetails_Edit.ObjectivePercent(driver).getAttribute("value");
			assertEquals(ValidPercent, actualPercent);
	}
	
	@Then ("^ \"([^\\\"]*)\" of objective is updated$")
	public void of_objective_is_updated(String Status) {
		visibilityOf(driver, 20, pageObj_ObjectDetails_Edit.ObjectiveStatus(driver));
		String actualStatus = pageObj_ObjectDetails_Edit.ObjectiveStatus(driver).getAttribute("value");
			assertEquals(Status, actualStatus);
	}

}