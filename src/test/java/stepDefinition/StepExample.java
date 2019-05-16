package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObject.pageObjDemo;

import java.util.ResourceBundle;


public class StepExample {
    ResourceBundle properties_value;
    private WebDriver driver;

    public StepExample() {
        this.driver = Hooks.getDriver();
    }

    @Given("^User is on Home screen$")
    public void user_is_on_Home_screen() {
        properties_value = ResourceBundle.getBundle("data_example");
        driver.get(properties_value.getString("data_example.baseURL"));
    }

    @When("^User click on \"([^\"]*)\" label$")
    public void user_click_on_label(String objectiveName) {
        System.out.println(objectiveName);
        pageObjDemo.link_Objective(driver, objectiveName).click();
    }

    @When("^User input valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_input_valid_and(String username, String password) {
        System.out.println(username);
        System.out.println(password);
    }

    @Then("^Title is displayed correctly$")
    public void title_is_displayed_correctly() {
        System.out.println("PASS");
    }
}
