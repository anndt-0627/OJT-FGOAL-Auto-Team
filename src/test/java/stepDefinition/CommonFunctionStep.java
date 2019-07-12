package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.DashboardPageObject;
import pageObject.LoginPageObject;
import utility.Common;

import java.util.ResourceBundle;

public class CommonFunctionStep extends Common {

    ResourceBundle properties_value = ResourceBundle.getBundle("data_common_function");
    private WebDriver driver;

    public CommonFunctionStep() {
        this.driver = Hooks.getDriver();
    }

    @Given("^User is on FGoal Home screen$")
    public void user_is_on_FGoal_Home_screen() {
        visibilityOf(driver, 20, DashboardPageObject.leftMenu_dashboard(driver));
        DashboardPageObject.leftMenu_dashboard(driver).click();

    }

    @Then("^User should see Title Fgoal on header is displayed correctly$")
    public void user_should_see_Title_Fgoal_on_header_is_displayed_correctly() {
        Assert.assertTrue(DashboardPageObject.lb_logoFgoal(driver).isDisplayed());

    }

    @Then("^User should see Search textbox on header is displayed correctly$")
    public void user_should_see_Search_textbox_on_header_is_displayed_correctly() {
        Assert.assertTrue(DashboardPageObject.txt_searchGroup(driver).isDisplayed());

    }

    @Then("^User should see Notification icon on header is displayed correctly$")
    public void user_should_see_Notification_icon_on_header_is_displayed_correctly() {
        Assert.assertTrue(DashboardPageObject.icon_notification(driver).isDisplayed());
    }

    @Then("^User should see Avatar icon on header is displayed correctly$")
    public void user_should_see_Avatar_icon_on_header_is_displayed_correctly() {
        Assert.assertTrue(DashboardPageObject.img_avatarProfile(driver).isDisplayed());

    }

    @Then("^User should see Footer text is displayed correctly$")
    public void user_should_see_Footer_text_is_displayed_correctly() {
        String actual_footer = DashboardPageObject.lb_footer(driver).getText();
        String expected_footer = properties_value.getString("content_footer");
        Assert.assertEquals(expected_footer, actual_footer);

    }

    @When("^User navigates to Units screen$")
    public void user_navigates_to_Units_screen() {
        visibilityOfElementToBeClickable(driver, 20, DashboardPageObject.leftMenu_units(driver));
        DashboardPageObject.leftMenu_units(driver).click();

    }

    @When("^User perform clicks on Fgoal logo$")
    public void user_perform_clicks_on_Fgoal_logo() {
        DashboardPageObject.lb_logoFgoal(driver).click();

    }

    @Then("^User navigates to Dashboard screen$")
    public void user_navigates_to_Dashboard_screen() {
        Assert.assertTrue(DashboardPageObject.txt_timeFrame(driver).isDisplayed());
    }

    @Then("^Search group name or staff name is displayed as placeholder of Search textbox$")
    public void search_group_name_or_staff_name_is_displayed_as_placeholder_of_Search_textbox() {
        String actual_placeholder = DashboardPageObject.txt_searchGroup(driver).getAttribute("placeholder");
        String expected_placeholder = properties_value.getString("placeholder_search_textbox");
        Assert.assertEquals(expected_placeholder, actual_placeholder);
    }

    @When("^User inputs search keyword into search textbox as \"([^\"]*)\"$")
    public void user_inputs_search_keyword_into_search_textbox_as(String search_keyword) {
        DashboardPageObject.txt_searchGroup(driver).click();
        DashboardPageObject.txt_searchGroup(driver).sendKeys(search_keyword);

    }

    @Then("^Show suggested value contain \"([^\"]*)\" when user inputs search keyword into search textbox$")
    public void show_suggested_value_contain_when_user_inputs_search_keyword_into_search_textbox(String search_keyword) {
        Assert.assertTrue(DashboardPageObject.lb_suggest_group(driver, search_keyword).isDisplayed());

    }

    @When("^User performs select group as \"([^\"]*)\"$")
    public void user_performs_select_group_as(String search_keyword) {
        DashboardPageObject.lb_suggest_group(driver, search_keyword).click();

    }

    @Then("^Navigates to Group detail of selected group as \"([^\"]*)\"$")
    public void navigates_to_Group_detail_of_selected_group_as(String search_keyword) {
        Assert.assertTrue(DashboardPageObject.lb_nameGroup(driver, search_keyword).isDisplayed());

    }

    @Then("^User should see Dashboard item on Slide Menu of Admin Account$")
    public void user_should_see_Dashboard_item_on_Slide_Menu_of_Admin_Account() {
        Assert.assertTrue(DashboardPageObject.leftMenu_dashboard(driver).isDisplayed());
    }

    @Then("^User should see Units item on Slide Menu of Admin Account$")
    public void user_should_see_Units_item_on_Slide_Menu_of_Admin_Account() {
        Assert.assertTrue(DashboardPageObject.leftMenu_units(driver).isDisplayed());
    }

    @Then("^User should see Years Plan item on Slide Menu of Admin Account$")
    public void user_should_see_Years_Plan_item_on_Slide_Menu_of_Admin_Account() {
        Assert.assertTrue(DashboardPageObject.leftMenu_yearPlan(driver).isDisplayed());
    }

    @Then("^User should see Organization Chart item on Slide Menu of Admin Account$")
    public void user_should_see_Organization_Chart_item_on_Slide_Menu_of_Admin_Account() {
        Assert.assertTrue(DashboardPageObject.leftMenu_organizationChart(driver).isDisplayed());
    }

    @Then("^User should see My Groups item on Slide Menu of Admin Account$")
    public void user_should_see_My_Groups_item_on_Slide_Menu_of_Admin_Account() {
        Assert.assertTrue(DashboardPageObject.leftMenu_myGroups(driver).isDisplayed());
    }

    @Then("^User should see Pin Groups item on Slide Menu of Admin Account$")
    public void user_should_see_Pin_Groups_item_on_Slide_Menu_of_Admin_Account() {
        Assert.assertTrue(DashboardPageObject.leftMenu_pinGroups(driver).isDisplayed());
    }

    @Then("^User should see Timeline item on Slide Menu of Admin Account$")
    public void user_should_see_Timeline_item_on_Slide_Menu_of_Admin_Account() {
        Assert.assertTrue(DashboardPageObject.leftMenu_timeLine(driver).isDisplayed());
    }

    @Then("^User should see Users item on Slide Menu of Admin Account$")
    public void user_should_see_Users_item_on_Slide_Menu_of_Admin_Account() {
        Assert.assertTrue(DashboardPageObject.leftMenu_users(driver).isDisplayed());
    }

    @Then("^User should see Logout item on Slide Menu of Admin Account$")
    public void user_should_see_Logout_item_on_Slide_Menu_of_Admin_Account() {
        Assert.assertTrue(DashboardPageObject.leftMenu_logOut(driver).isDisplayed());
    }

    @Then("^User clicks on Dashboard item at Slide Menu of Admin Account$")
    public void user_clicks_on_Dashboard_item_at_Slide_Menu_of_Admin_Account() {
        DashboardPageObject.leftMenu_dashboard(driver).click();

    }

    @Then("^Navigates to Dashboard screen correctly$")
    public void navigates_to_Dashboard_screen_correctly() {
        Assert.assertTrue(DashboardPageObject.txt_timeFrame(driver).isDisplayed());
    }

    @Then("^User clicks on Units item at Slide Menu of Admin Account$")
    public void user_clicks_on_Units_item_at_Slide_Menu_of_Admin_Account() {
        DashboardPageObject.leftMenu_units(driver).click();
    }

    @Then("^Navigates to Units screen correctly$")
    public void navigates_to_Units_screen_correctly() {
        Assert.assertTrue(DashboardPageObject.lb_listUnit(driver).isDisplayed());
    }

    @Then("^User clicks on Years Plan item at Slide Menu of Admin Account$")
    public void user_clicks_on_Years_Plan_item_at_Slide_Menu_of_Admin_Account() {
        DashboardPageObject.leftMenu_yearPlan(driver).click();
    }

    @Then("^Navigates to Years Plan screen correctly$")
    public void navigates_to_Years_Plan_screen_correctly() {
        Assert.assertTrue(DashboardPageObject.lb_listYearPlan(driver).isDisplayed());
    }

    @Then("^User clicks on Organization Chart item at Slide Menu of Admin Account$")
    public void user_clicks_on_Organization_Chart_item_at_Slide_Menu_of_Admin_Account() {
        DashboardPageObject.leftMenu_organizationChart(driver).click();
    }

    @Then("^Navigates to Organization Chart screen correctly$")
    public void navigates_to_Organization_Chart_screen_correctly() {
        Assert.assertTrue(DashboardPageObject.lb_organizationChart(driver).isDisplayed());
    }

    @Then("^User clicks on Timeline item at Slide Menu of Admin Account$")
    public void user_clicks_on_Timeline_item_at_Slide_Menu_of_Admin_Account() {
        DashboardPageObject.leftMenu_timeLine(driver).click();
    }

    @Then("^Navigates to Timeline screen correctly$")
    public void navigates_to_Timeline_screen_correctly() {
        //TBD
    }

    @Then("^User clicks on Users item at Slide Menu of Admin Account$")
    public void user_clicks_on_Users_item_at_Slide_Menu_of_Admin_Account() {
        DashboardPageObject.leftMenu_users(driver).click();
    }

    @Then("^Navigates to Users screen correctly$")
    public void navigates_to_Users_screen_correctly() {
        Assert.assertTrue(DashboardPageObject.lb_listUsers(driver).isDisplayed());
    }

    @Then("^User clicks on Log out item at Slide Menu of Admin Account$")
    public void user_clicks_on_Log_out_item_at_Slide_Menu_of_Admin_Account() {
        DashboardPageObject.leftMenu_logOut(driver).click();
    }

    @Then("^Navigates to Login screen$")
    public void navigates_to_Login_screen() {
        Assert.assertTrue(LoginPageObject.btn_loginViaWSM(driver).isDisplayed());
    }

    @When("^User clicks on Avatar icon$")
    public void user_clicks_on_Avatar_icon() {
        DashboardPageObject.img_avatarProfile(driver).click();

    }

    @Then("^User information pop up is displayed$")
    public void user_information_pop_up_is_displayed() {
        Assert.assertTrue(DashboardPageObject.btn_logout(driver).isDisplayed());
    }

    @Then("^User should see Email address link on User information pop up$")
    public void user_should_see_Email_address_link_on_User_information_pop_up() {
        Assert.assertTrue(DashboardPageObject.lnk_email(driver).isDisplayed());
    }

    @Then("^User should see My Profile link on User information pop up$")
    public void user_should_see_My_Profile_link_on_User_information_pop_up() {
        Assert.assertTrue(DashboardPageObject.lnk_myProfile(driver).isDisplayed());
    }

    @Then("^User should see Log out button on User information pop up$")
    public void user_should_see_Log_out_button_on_User_information_pop_up() {
        Assert.assertTrue(DashboardPageObject.btn_logout(driver).isDisplayed());
    }


}
