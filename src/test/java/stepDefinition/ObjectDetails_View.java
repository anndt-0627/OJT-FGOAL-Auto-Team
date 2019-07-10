package stepDefinition;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_ObjectDetails_View;
import pageObject.pageObj_Objective_QuickActions_ChangeName;
import utility.Common;

public class ObjectDetails_View extends Common {
	ResourceBundle properties_value = ResourceBundle.getBundle("dataObjective_QuickActions");
	private WebDriver driver;

	public ObjectDetails_View() {
		this.driver = Hooks.getDriver();
	}

	@Given("^User navigate to Dashboard screen$")
	public void user_back_to_Dashboard_screen() {
		pageObj_ObjectDetails_View.menuDashboard(driver).click();
	}

	@When("^User create a new Objective with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_create_a_new_Objective_with_and(String objName, String objWeight) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_ObjectDetails_View.btnAddNewObj(driver));
		moveToElement(driver, pageObj_ObjectDetails_View.btnAddNewObj(driver));
		pageObj_ObjectDetails_View.btnAddNewObj(driver).click();

		pageObj_ObjectDetails_View.txtName(driver).sendKeys(objName);

		pageObj_ObjectDetails_View.txtWeight(driver).clear();
		pageObj_ObjectDetails_View.txtWeight(driver).sendKeys(objWeight);

		pageObj_ObjectDetails_View.btnAddObjective(driver).click();
	}

	@When("^User click on \"([^\"]*)\" item in My Objectives$")
	public void user_clicks_on_item_in_My_Objectives(String objName) {
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjectDetails_View.DB_ObjectiveName(driver, objName));
		moveToElement(driver, pageObj_ObjectDetails_View.DB_ObjectiveName(driver, objName));
		pageObj_ObjectDetails_View.DB_ObjectiveName(driver, objName).click();
	}

	@Then("^User navigates to Objective Details screen successfully$")
	public void user_navigates_to_Objective_Details_screen_successfully(){
		String URL = driver.getCurrentUrl();
		
		visibilityOf(driver, 20, pageObj_ObjectDetails_View.ObjectiveName(driver));
		Assert.assertTrue(pageObj_ObjectDetails_View.ObjectiveName(driver).isDisplayed());
	}
	
	@Given("^User is on Objective Details screen$")
	public void user_is_on_Objective_Details_screen() {
		pageObj_ObjectDetails_View.
	}
}