package stepDefinition;

import java.util.ResourceBundle;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_ObjectDetails_View;
import utility.Common;

public class ObjectDetails_View extends Common {
	ResourceBundle properties_value = ResourceBundle.getBundle("dataObjective_QuickActions");
	private WebDriver driver;

	public ObjectDetails_View() {
		this.driver = Hooks.getDriver();
	}

	@Given("^User back to Dashboard screen$")
	public void user_back_to_Dashboard_screen() {
		pageObj_ObjectDetails_View.menuDashboard(driver).click();
	}

	@When("^User create a new Objective with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_create_a_new_Objective_with_and(String ObjectiveName, String ObjectWeight) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_ObjectDetails_View.btnAddNewObj(driver));
		moveToElement(driver, pageObj_ObjectDetails_View.btnAddNewObj(driver));
		pageObj_ObjectDetails_View.btnAddNewObj(driver).click();

		pageObj_ObjectDetails_View.txtName(driver).sendKeys(ObjectiveName);

		pageObj_ObjectDetails_View.txtWeight(driver).clear();
		pageObj_ObjectDetails_View.txtWeight(driver).sendKeys(ObjectWeight);

		pageObj_ObjectDetails_View.btnAddObjective(driver).click();
	}

	@When("^User click on \"([^\"]*)\" item in My Objectives$")
	public void user_clicks_on_item_in_My_Objectives(String ObjectiveName) {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjectDetails_View.DB_ObjectiveName(driver, ObjectiveName));
		moveToElement(driver, pageObj_ObjectDetails_View.DB_ObjectiveName(driver, ObjectiveName));
		pageObj_ObjectDetails_View.DB_ObjectiveName(driver, ObjectiveName).click();
	}

	@Then("^User navigates to Objective Details screen successfully$")
	public void user_navigates_to_Objective_Details_screen_successfully(String ObjectiveName){
		visibilityOf(driver, 20, pageObj_ObjectDetails_View.ObjectiveName(driver));
		String ActualObjectiveName =pageObj_ObjectDetails_View.ObjectiveName(driver).getAttribute("value");
		assertEquals(ObjectiveName, ActualObjectiveName);

	}
	
	@Then("^Quarter of objective is \"([^\\\"]*)\"$")
	public void quarter_of_objective_is (String ExpectedQuarter) {
		visibilityOf(driver, 20, pageObj_ObjectDetails_View.ObjectiveQuater(driver));
		String ActualQuarter =pageObj_ObjectDetails_View.ObjectiveQuater(driver).getAttribute("value");
		assertEquals(ExpectedQuarter, ActualQuarter);
	}
	
	@Then("^Current percent user has done of objective is correctly$")
	public void current_percent_user_has_done_of_objective_is_correctly (String ExpectedPercent){
		visibilityOf(driver, 20, pageObj_ObjectDetails_View.ObjectiveCurentProgress(driver));
		String actual_percent =pageObj_ObjectDetails_View.ObjectiveCurentProgress(driver).getAttribute("value");
		assertEquals(ExpectedPercent, actual_percent);
	}
	
	@Then("^If percent use has done of objective is \"([^\\\"]*)\" then status of objective is \"([^\\\"]*)\"$")
	public void if_percent_use_has_done_of_objective_is_then_status_of_objective_is (String ExpectedPercent, String ExpectedStatus) {
		visibilityOf(driver, 20, pageObj_ObjectDetails_View.ObjectiveCurentProgress(driver));
		String CurrentPercent = pageObj_ObjectDetails_View.ObjectiveCurentProgress(driver).getAttribute("value");
		Assert.assertEquals(ExpectedPercent, CurrentPercent);
		String CurrentStatus = pageObj_ObjectDetails_View.ObjectiveStatus(driver).getAttribute("value");
			Assert.assertEquals(ExpectedStatus, CurrentStatus);
	}
	
}