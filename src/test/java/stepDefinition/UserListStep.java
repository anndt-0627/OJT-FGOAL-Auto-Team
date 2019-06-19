package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.DashboardPageObject;
import pageObject.UserListPageObject;

import java.util.ResourceBundle;

public class UserListStep{
    ResourceBundle data_userList = ResourceBundle.getBundle("data_userList");
    private WebDriver driver;
    private WebDriverWait wait;

    public UserListStep() {
        this.driver = Hooks.getDriver();
    }
    @Given("^User navigate to User List$")
    public void user_navigate_to_User_List() {
        wait  = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.leftMenu_users(driver)));
        DashboardPageObject.leftMenu_users(driver).click();
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.lb_titleUserList(driver)));
    }

    @When("^User search with exited Name exactly match$")
    public void user_search_with_exited_Name_exactly_match() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        UserListPageObject.txt_inputSearch(driver).sendKeys(data_userList.getString("exited_name"));
    }

    @Then("^Display results mapping with Name of user of user$")
    public void display_results_mapping_with_Name_of_user_of_user() {
        String paging_number = UserListPageObject.lb_totalResult(driver).getText().split(" ")[6];
        System.out.println("==================="+paging_number);
    }

    @When("^User search with existed Name partial match$")
    public void user_search_with_existed_Name_partial_match() {
    }

    @When("^User search with special characters$")
    public void user_search_with_special_characters() {
    }

    @Then("^Has no result on list search$")
    public void has_no_result_on_list_search() {
    }

    @When("^User search with not matching wit any data$")
    public void user_search_with_not_matching_wit_any_data() {
    }
}
