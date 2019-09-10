package stepDefinition;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_Object_Detail_Edit;
import utility.Common;

public class Objective_Detail_Edit extends Common {
	private WebDriver driver;

	public Objective_Detail_Edit() {
		this.driver = Hooks.getDriver();
	}

	@Given("^User is on Dashboard screen $")
	public void user_is_on_Dashboard_screen() {
		pageObj_Object_Detail_Edit.menuDashboard(driver).click();
	}

	@When("^User navigate to screen detail of \"([^\\\"]*)\"$")
	public void user_navigate_to_screen_detail_of(String Objective_Name) {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_Object_Detail_Edit.ObjectiveName(driver));
		moveToElement(driver, pageObj_Object_Detail_Edit.ObjectiveName(driver));
		pageObj_Object_Detail_Edit.ObjectiveName(driver).click();
	}

	@When("^User open popup Configure the objective calculation progress$")
	public void user_open_popup_Configure_the_objective_calculation_progress() {
		visibilityOf(driver, 20, pageObj_Object_Detail_Edit.ObjectiveConfigure(driver));
		pageObj_Object_Detail_Edit.ObjectiveConfigure(driver).click();
	}

	@When("^User input \"([^\\\"]*)\" for progress value and perform action update$")
	public void user_input_for_progress_value_and_perform_action_update(String Valid_Percent) {
		visibilityOf(driver, 20, pageObj_Object_Detail_Edit.ObjectiveUpdateManual(driver));
		pageObj_Object_Detail_Edit.ObjectiveUpdateManual(driver).click();
		pageObj_Object_Detail_Edit.ObjectiveUpdateManual(driver).clear();
		pageObj_Object_Detail_Edit.ObjectiveUpdateManual(driver).sendKeys(Valid_Percent);
		visibilityOf(driver, 20, pageObj_Object_Detail_Edit.ObjectiveButtonUpdate(driver));
		pageObj_Object_Detail_Edit.ObjectiveButtonUpdate(driver).click();
	}

	@Then("^New \"([^\\\"]*)\" of objective is accepted$")
	public void new_of_objective_is_accepted(String Valid_Percent) {
		visibilityOf(driver, 20, pageObj_Object_Detail_Edit.ObjectiveCurentProgress(driver));
		String actualPercent = pageObj_Object_Detail_Edit.ObjectiveCurentProgress(driver).getAttribute("value");
		assertEquals(Valid_Percent, actualPercent);
	}

	@Then("^ \"([^\\\"]*)\" of objective is changed $")
	public void of_objective_is_changed(String Status) {
		visibilityOf(driver, 20, pageObj_Object_Detail_Edit.ObjectiveStatus(driver));
		String actual_Status = pageObj_Object_Detail_Edit.ObjectiveStatus(driver).getAttribute("value");
		assertEquals(Status, actual_Status);
	}

	@When("^User select item Update weight of objective$")
	public void user_select_item_Update_weight_of_objective(String Weight, String Message) {
		visibilityOf(driver, 20, pageObj_Object_Detail_Edit.ObjectiveWeight(driver));
		pageObj_Object_Detail_Edit.ObjectiveWeight(driver).click();
	}

	@When("^User change \"([^\\\"]*)\" of objective and perform action update$")
	public void user_change_of_objective_and_perform_action(String Weight) {
		visibilityOf(driver, 20, pageObj_Object_Detail_Edit.ObjectiveWeight(driver));
		pageObj_Object_Detail_Edit.ObjectiveWeight(driver).clear();
		pageObj_Object_Detail_Edit.ObjectiveWeight(driver).sendKeys(Weight);
		driver.navigate().refresh();
	}

	@Then("^New\"([^\\\"]*)\" of objective is updated  $")
	public void new_of_objective_is_updated(String Weight) {
		String actual_Weight = pageObj_Object_Detail_Edit.ObjectiveWeight(driver).getAttribute(Weight);
		assertEquals(Weight, actual_Weight);

	}
	
	@Then("^New\"([^\\\"]*)\" of objective is updated  $")
	public void new_of_objective_is_also_updated(String Status) {
		String actual_Status = pageObj_Object_Detail_Edit.ObjectiveStatus(driver).getAttribute(Status);
		assertEquals(Status, actual_Status);

	}
}
