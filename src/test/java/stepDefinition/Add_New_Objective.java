package stepDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.PageObj_Add_New_Objective;
import utility.Common;

public class Add_New_Objective extends Common {
	private WebDriver driver;
	private String currenttime;
	ResourceBundle input_value = ResourceBundle.getBundle("data_add_objective");

	public Add_New_Objective() {
		this.driver = Hooks.getDriver();
	}

	@Given("^User is on Add Objective form$")
	public void user_is_on_Add_Objective_form() {
		Common.visibilityOfElementToBeClickable(driver, 10, PageObj_Add_New_Objective.dashboard_btn_AddObj(driver));
		PageObj_Add_New_Objective.dashboard_btn_AddObj(driver).click();

	}

	@When("^Name is emty$")
	public void name_is_emty() {
		Common.visibilityOf(driver, 10, PageObj_Add_New_Objective.addObj_tbx_name(driver));
		PageObj_Add_New_Objective.addObj_tbx_name(driver).clear();

	}

	@When("^User enters weight is \"([^\"]*)\" in step$")
	public void user_enters_weight_is_in_step(String weight) {
		Common.visibilityOf(driver, 10, PageObj_Add_New_Objective.addObj_tbx_weight(driver));
		PageObj_Add_New_Objective.addObj_tbx_weight(driver).sendKeys(weight);
	}

	@When("^User selects quarter value$")
	public void user_selects_quarter_value() {
		String quarter = input_value.getString("QUARTER");
		Select dropdown = new Select(PageObj_Add_New_Objective.addObj_ddl_quarter(driver));
		dropdown.selectByVisibleText(quarter);
	}

	@When("^User perform to add new Objective$")
	public void user_perform_to_add_new_Objective() throws Throwable {
		Common.visibilityOfElementToBeClickable(driver, 10, PageObj_Add_New_Objective.addObj_btn_AddObj(driver));
		PageObj_Add_New_Objective.addObj_btn_AddObj(driver).click();

	}

	@Then("^Weight error \"([^\"]*)\" displays$")
	public void weight_error_displays(String message) throws Throwable {
		String actual = PageObj_Add_New_Objective.addObj_lb_errorweight(driver).getText();
		Assert.assertEquals(actual, message);
	}

	@When("^User enters valid objective name$")
	public void user_enters_valid_objective_name(){
		String objectname = input_value.getString("OBJNAME");
		SimpleDateFormat Dateformat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date date = new Date();
		currenttime = Dateformat.format(date);
		Common.visibilityOf(driver, 10, PageObj_Add_New_Objective.addObj_tbx_name(driver));
		PageObj_Add_New_Objective.addObj_tbx_name(driver).sendKeys(objectname + currenttime);

	}

	@When("^Weight is empty$")
	public void weight_is_empty() {
		Common.visibilityOf(driver, 10, PageObj_Add_New_Objective.addObj_tbx_weight(driver));
		PageObj_Add_New_Objective.addObj_tbx_weight(driver).clear();

	}

	@Then("^Name error \"([^\"]*)\" displays$")
	public void name_error_displays(String message) {
		Common.visibilityOf(driver, 10, PageObj_Add_New_Objective.addObj_lb_errorname(driver));
		String actual = PageObj_Add_New_Objective.addObj_lb_errorname(driver).getText();
		Assert.assertEquals(actual, message);
	}

	@Then("^Successfull \"([^\"]*)\" displays$")
	public void successfull_displays(String message) {
		Common.visibilityOf(driver, 10, PageObj_Add_New_Objective.objDetails_lb_successfulmessage(driver));
		String actual = PageObj_Add_New_Objective.objDetails_lb_successfulmessage(driver).getText();
		Assert.assertEquals(actual, message);
	}

	@Then("^\"([^\"]*)\", weight \"([^\"]*)\" and \"([^\"]*)\" of new objective are matched with values user had seleted$")
	public void weight_and_of_new_objective_are_matched_with_values_user_had_seleted(String objectname, String weight,
			String quarter) {
		Common.visibilityOf(driver, 10, PageObj_Add_New_Objective.objDetails_lb_objname(driver));
		String latestname = PageObj_Add_New_Objective.objDetails_lb_objname(driver).getText();
		Assert.assertEquals(latestname, objectname + currenttime);

		Common.visibilityOf(driver, 10, PageObj_Add_New_Objective.objDetails_txb_weight(driver));
		String latestweight = PageObj_Add_New_Objective.objDetails_txb_weight(driver).getAttribute("value");
		Assert.assertEquals(latestweight, weight);

		Common.visibilityOf(driver, 10, PageObj_Add_New_Objective.objDetails_lb_quarter(driver, quarter));
		String latestquarter = PageObj_Add_New_Objective.objDetails_lb_quarter(driver, quarter).getText();
		Assert.assertEquals(latestquarter, quarter);
	}

}
