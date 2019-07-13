package stepDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pageObject.PageObj_Add_New_Objective;



public class Add_New_Objective extends PageObj_Add_New_Objective  {
	ResourceBundle properties_value;
    private WebDriver driver;
    private String currenttime;
    

    public Add_New_Objective() {
        this.driver = Hooks.getDriver();
    }
	@Given("^User is on Add Objective form$")
	public void user_is_on_Add_Objective_form() throws Throwable {
		PageObj_Add_New_Objective.get_element(driver, btn_fgoal_AddObj).click();
	    
	}

	@When("^Name is emty$")
	public void name_is_emty() throws Throwable {
	    PageObj_Add_New_Objective.get_element(driver, tbx_fgoal_AddObj_name).clear();
	    
	}

	@When("^User enters weight is \"([^\"]*)\" in step$")
	public void user_enters_weight_is_in_step(String weight) throws Throwable {
	    PageObj_Add_New_Objective.get_element(driver, tbx_fgoal_AddObj_weight).sendKeys(weight);
	}

	@When("^User selects \"([^\"]*)\" value$")
	public void user_selects_value(String quater) throws Throwable {
		Select dropdown = new Select(driver.findElement(By.xpath(ddl_fgoal_AddObj_quarter)));
		dropdown.selectByVisibleText(quater);
	}

	@When("^User perform to add new Objective$")
	public void user_perform_to_add_new_Objective() throws Throwable {
	    PageObj_Add_New_Objective.get_element(driver, btn_fgoal_AddObj_add);
	
	}

	@Then("^Weight error \"([^\"]*)\" displays$")
	public void weight_error_displays(String message) throws Throwable {
	    String actual = PageObj_Add_New_Objective.get_element(driver, lb_fgoal_AddObj_error_weight).getText();
	    Assert.assertEquals(actual, message);
	}

	@When("^User enters valid \"([^\"]*)\"$")
	public void user_enters_valid(String objname) throws Throwable {
		SimpleDateFormat Dateformat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date date = new Date();
		currenttime = Dateformat.format(date);
	    PageObj_Add_New_Objective.get_element(driver, tbx_fgoal_AddObj_name).sendKeys(objname + currenttime);

	}

	@When("^Weight is empty$")
	public void weight_is_empty() throws Throwable {
	    PageObj_Add_New_Objective.get_element(driver, tbx_fgoal_AddObj_weight).clear();

	}

	@Then("^Name error message \"([^\"]*)\" displays$")
	public void name_error_displays(String message) throws Throwable {
		String actual = PageObj_Add_New_Objective.get_element(driver, lb_fgoal_AddObj_error_name).getText();
	    Assert.assertEquals(actual, message);
	}

	@Then("^Successfull \"([^\"]*)\" displays$")
	public void successfull_displays(String message) throws Throwable {
		String actual = PageObj_Add_New_Objective.get_element(driver, lb_fgoal_success_message).getText();
	    Assert.assertEquals(actual, message);
	}

	@Then("^\"([^\"]*)\", weight \"([^\"]*)\" and \"([^\"]*)\" of new objective are matched with values user had seleted$")
	public void weight_and_of_new_objective_are_matched_with_values_user_had_seleted(String objectname, String weight, String quarter) throws Throwable {
		String latestname = PageObj_Add_New_Objective.get_element(driver, lb_fgoal_Objective_name).getText();
		Assert.assertEquals(latestname,  objectname + currenttime);
		
		String latestweight = PageObj_Add_New_Objective.get_element(driver, tbx_fgoal_Objective_weight).getAttribute("value");
		Assert.assertEquals(latestweight,  weight);

	}

}
