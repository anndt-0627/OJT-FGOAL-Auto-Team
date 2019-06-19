package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.DashboardPageObject;
import pageObject.LoginPageObject;

import java.util.ResourceBundle;

public class LoginStep {
    ResourceBundle properties_value = ResourceBundle.getBundle("data_login");
    private WebDriver driver;

    public LoginStep() {
        this.driver = Hooks.getDriver();
    }

    @Given("^User navigate to Login page of Fgoal$")
    public void user_navigate_to_Login_page_of_Fgoal() {
        //To pass basic authentication on WSM
        driver.get(properties_value.getString("URL_WSM"));
        driver.navigate().to(properties_value.getString("URL_Fgoal"));
        LoginPageObject.btn_loginViaWSM(driver).click();
    }

    @When("^User navigate to Login page of WSM$")
    public void user_navigate_to_Login_page_of_WSM() {
        LoginPageObject.btn_loginInWSM(driver).click();
    }

    @When("^User enter valid account as user account$")
    public void user_enter_valid_account_as_user_account() {
        LoginPageObject.txt_userEmail(driver).sendKeys(properties_value.getString("user_email"));
    }

    @When("^User enter valid password as password of user$")
    public void user_enter_valid_password_as_password_of_user() {
        LoginPageObject.txt_password(driver).sendKeys(properties_value.getString("user_password"));
        LoginPageObject.btn_submitLoginInWSM(driver).click();

    }

    @Then("^User should be access Fgoal successfully$")
    public void user_should_be_access_Fgoal_successfully() {
        Assert.assertTrue(DashboardPageObject.lb_logoFgoal(driver).isDisplayed());
    }

    @When("^User enter valid account as admin account$")
    public void user_enter_valid_account_as_admin_account() {
        LoginPageObject.txt_userEmail(driver).sendKeys(properties_value.getString("admin_email"));
    }

    @When("^User enter valid password as password of admin$")
    public void user_enter_valid_password_as_password_of_admin() {
        LoginPageObject.txt_password(driver).sendKeys(properties_value.getString("admin_password"));
        LoginPageObject.btn_submitLoginInWSM(driver).click();
    }
}
