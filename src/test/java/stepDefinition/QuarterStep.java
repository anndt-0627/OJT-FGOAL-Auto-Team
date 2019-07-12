package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.QuarterPageObject;
import utility.Common;

import java.util.List;
import java.util.ResourceBundle;

public class QuarterStep extends Common {
    ResourceBundle quarter_input = ResourceBundle.getBundle("data_quarter");
    private WebDriver driver;

    public QuarterStep() {
        this.driver = Hooks.getDriver();
    }

    @Given("^User is on Quarter List page$")
    public void user_is_on_Quarter_List_page() {
        visibilityOfElementToBeClickable(driver, 20, QuarterPageObject.link_yearPlan(driver));
        QuarterPageObject.link_yearPlan(driver).click();
        visibilityOf(driver, 20, QuarterPageObject.lb_newYearList(driver));
        Assert.assertTrue(QuarterPageObject.lb_newYearList(driver).isDisplayed());
    }

    @Then("^All item on the Quarter screen displays correctly$")
    public void all_item_on_the_Quarter_screen_displays_correctly() {
        //check add new year button displays
        Assert.assertTrue(QuarterPageObject.btn_newYear(driver).isDisplayed());

        //check year plan list displays
        Assert.assertTrue(QuarterPageObject.item_currentYear(driver).isDisplayed());
        Assert.assertTrue(QuarterPageObject.item_quarter(driver, quarter_input.getString("QUARTER_01")).isDisplayed());
        Assert.assertTrue(QuarterPageObject.item_quarter(driver, quarter_input.getString("QUARTER_02")).isDisplayed());
        Assert.assertTrue(QuarterPageObject.item_quarter(driver, quarter_input.getString("QUARTER_03")).isDisplayed());
        Assert.assertTrue(QuarterPageObject.item_quarter(driver, quarter_input.getString("QUARTER_04")).isDisplayed());

        //check default quarter displays
        Assert.assertTrue(QuarterPageObject.drd_quarter(driver).isDisplayed());
        Assert.assertTrue(QuarterPageObject.btn_setDefault(driver).isDisplayed());
    }

    @When("^User perform open add new year plan page$")
    public void user_perform_open_add_new_year_plan_page() {
        QuarterPageObject.btn_newYear(driver).click();
        visibilityOf(driver, 20, QuarterPageObject.lb_addYear(driver));
    }

    @When("^User choose valid \"([^\"]*)\" at Add new year plan page$")
    public void user_choose_valid_at_Add_new_year_plan_page(String year) {
        visibilityOf(driver, 20, QuarterPageObject.drd_selectYear(driver));
        QuarterPageObject.drd_selectYear(driver).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", QuarterPageObject.item_selectYear(driver, year));
        visibilityOf(driver, 20, QuarterPageObject.item_selectYear(driver, year));
        QuarterPageObject.item_selectYear(driver, year).click();
    }

    @When("^User input valid quarter start time and quarter end time for each quarter at Add new year plan page$")
    public void user_input_valid_quarter_start_time_and_quarter_end_time_for_each_quarter_at_Add_new_year_plan_page() {
        //Input start-time
        QuarterPageObject.startTime_01(driver).clear();
        QuarterPageObject.startTime_01(driver).sendKeys(quarter_input.getString("START_TIME_Q1"));
        QuarterPageObject.startTime_02(driver).clear();
        QuarterPageObject.startTime_02(driver).sendKeys(quarter_input.getString("START_TIME_Q2"));
        QuarterPageObject.startTime_03(driver).clear();
        QuarterPageObject.startTime_03(driver).sendKeys(quarter_input.getString("START_TIME_Q3"));
        QuarterPageObject.startTime_04(driver).clear();
        QuarterPageObject.startTime_04(driver).sendKeys(quarter_input.getString("START_TIME_Q4"));

        //Input end-time
        QuarterPageObject.endTime_01(driver).clear();
        QuarterPageObject.endTime_01(driver).sendKeys(quarter_input.getString("END_TIME_Q1"));
        QuarterPageObject.endTime_02(driver).clear();
        QuarterPageObject.endTime_02(driver).sendKeys(quarter_input.getString("END_TIME_Q2"));
        QuarterPageObject.endTime_03(driver).clear();
        QuarterPageObject.endTime_03(driver).sendKeys(quarter_input.getString("END_TIME_Q3"));
        QuarterPageObject.endTime_04(driver).clear();
        QuarterPageObject.endTime_04(driver).sendKeys(quarter_input.getString("END_TIME_Q4"));

    }

    @When("^User perform add new year plan action$")
    public void user_perform_add_new_year_plan_action() {
        QuarterPageObject.btn_addYear(driver).click();
    }

    @Then("^User is back to Quarter List page and successfully added message displays$")
    public void user_is_back_to_Quarter_List_page_and_successfully_added_message_displays() {
        //check Quarter list displays
        visibilityOf(driver, 20, QuarterPageObject.lb_newYearList(driver));
        Assert.assertTrue(QuarterPageObject.lb_newYearList(driver).isDisplayed());

        //check show success message
        String actual_msg = QuarterPageObject.msg_successDefault(driver).getText();
        String expected_msg = quarter_input.getString("SUCCESS_ADD_YEAR");
        Assert.assertEquals(expected_msg, actual_msg);
    }

    @Given("^\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" display successfully on Quarter List page$")
    public void display_successfully_on_Quarter_List_page(String quarter01, String quarter02, String quarter03, String quarter04) {
        List<WebElement> listYear = QuarterPageObject.yearList(driver);
        int size = listYear.size();
        moveToElement(driver, QuarterPageObject.item_year(driver, size));
        visibilityOfElementToBeClickable(driver, 20, QuarterPageObject.item_year(driver, size));
        QuarterPageObject.item_year(driver, size).click();

        visibilityOf(driver, 20, QuarterPageObject.item_quarter(driver, quarter01));
        Assert.assertTrue(QuarterPageObject.item_quarter(driver, quarter01).isDisplayed());
        Assert.assertTrue(QuarterPageObject.item_quarter(driver, quarter02).isDisplayed());
        Assert.assertTrue(QuarterPageObject.item_quarter(driver, quarter03).isDisplayed());
        Assert.assertTrue(QuarterPageObject.item_quarter(driver, quarter04).isDisplayed());
    }

    @When("^User choose invalid \"([^\"]*)\" that already created at Add new year plan page$")
    public void user_choose_invalid_that_already_created_at_Add_new_year_plan_page(String invalidYear) {
        user_choose_valid_at_Add_new_year_plan_page(invalidYear);
    }

    @Then("^Duplicate new year plan displays and user can not create new year plan$")
    public void duplicate_new_year_plan_displays_and_user_can_not_create_new_year_plan() {
        Assert.assertTrue(QuarterPageObject.err_year(driver).isDisplayed());

        String actual_err = QuarterPageObject.err_year(driver).getText();
        String expected_err = quarter_input.getString("ERROR_EXIST_YEAR");
        Assert.assertEquals(expected_err, actual_err);
    }

    @When("^User choose any \"([^\"]*)\" in Quarter List dropdown$")
    public void user_choose_any_in_Quarter_List_dropdown(String quarter) {
        moveToElement(driver, QuarterPageObject.drd_quarter(driver));
        QuarterPageObject.drd_quarter(driver).click();
        visibilityOf(driver, 20, QuarterPageObject.item_selectQuarter(driver, quarter));
        QuarterPageObject.item_selectQuarter(driver, quarter).click();
    }

    @When("^User perform set default quarter action$")
    public void user_perform_set_default_quarter_action() {
        QuarterPageObject.btn_setDefault(driver).click();
    }

    @Then("^Success message displays and \"([^\"]*)\" set as default quarter$")
    public void success_message_displays_and_set_as_default_quarter(String expectedDefault) {
        //check show success message
        String actual_msg = QuarterPageObject.msg_successDefault(driver).getText();
        String expected_msg = quarter_input.getString("SUCCESS_SET_DEFAULT");
        Assert.assertEquals(expected_msg, actual_msg);

        //check default displays
        moveToElement(driver, QuarterPageObject.drd_quarter(driver));
        String actualDefault = QuarterPageObject.item_selectedQuarter(driver).getText();
        Assert.assertEquals(expectedDefault, actualDefault);
    }

    @Then("^Year plan of \"([^\"]*)\" quarter expand and show as default on Quarter List page$")
    public void year_plan_of_that_quarter_expand_and_show_as_default_on_Quarter_List_page(String quarter) {
        Assert.assertTrue(QuarterPageObject.item_quarter(driver, quarter).isDisplayed());
    }
}
