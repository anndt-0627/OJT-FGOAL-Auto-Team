package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.UserProfilePageObjective;

public class UserProfileStep {
    private WebDriver driver;
    private WebDriverWait wait;
    private String user_name;
    private String user_email;

    public UserProfileStep() {
        this.driver = Hooks.getDriver();
    }

    @Given("^User opens Profile popup$")
    public void user_opens_Profile_popup() {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(UserProfilePageObjective.icon_avartatProfile(driver)));
        UserProfilePageObjective.icon_avartatProfile(driver).click();
    }

    @When("^User navigate to My Profile$")
    public void user_navigate_to_My_Profile() {
        wait.until(ExpectedConditions.visibilityOf(UserProfilePageObjective.popup_lb_EmailUser(driver)));
        user_name = UserProfilePageObjective.popup_lb_nameUser(driver).getText();
        user_email = UserProfilePageObjective.popup_lb_EmailUser(driver).getText();
        UserProfilePageObjective.popup_btn_MyProfile(driver).click();

    }

    @When("^User observers data on My Profile$")
    public void user_observers_data_on_My_Profile() {
        wait.until(ExpectedConditions.visibilityOf(UserProfilePageObjective.lb_titleMyProfile(driver)));
        Assert.assertTrue(UserProfilePageObjective.img_profileAvatar(driver).isDisplayed());
        Assert.assertTrue(UserProfilePageObjective.lb_profileEmail(driver).isDisplayed());
        Assert.assertTrue(UserProfilePageObjective.lb_profileName(driver).isDisplayed());
        Assert.assertTrue(UserProfilePageObjective.lb_NameInfo(driver).isDisplayed());
        Assert.assertTrue(UserProfilePageObjective.lb_EmailInfo(driver).isDisplayed());
        Assert.assertTrue(UserProfilePageObjective.lb_CodeInfo(driver).isDisplayed());
        Assert.assertTrue(UserProfilePageObjective.lb_GroupInfo(driver).isDisplayed());
        Assert.assertTrue(UserProfilePageObjective.lb_GenderInfo(driver).isDisplayed());
        Assert.assertTrue(UserProfilePageObjective.lb_PhoneInfo(driver).isDisplayed());
        Assert.assertTrue(UserProfilePageObjective.lb_BirthdayInfoo(driver).isDisplayed());
        Assert.assertTrue(UserProfilePageObjective.lb_PositionInfo(driver).isDisplayed());
    }

    @Then("^Display data profile correctly$")
    public void display_data_profile_correctly() {
        String actual_name_profile = UserProfilePageObjective.lb_profileName(driver).getText();
        String actual_name_info = UserProfilePageObjective.value_NameInfo(driver).getText();
        Assert.assertEquals(user_name, actual_name_profile);
        Assert.assertEquals(user_name, actual_name_info);

        String actual_email_profile = UserProfilePageObjective.lb_profileEmail(driver).getText();
        String actual_email_info = UserProfilePageObjective.value_EmailInfo(driver).getText();
        Assert.assertEquals(user_email, actual_email_profile);
        Assert.assertEquals(user_email, actual_email_info);

        Assert.assertTrue(UserProfilePageObjective.value_CodeInfo(driver).isDisplayed());
        Assert.assertTrue(UserProfilePageObjective.value_GroupInfo(driver).isDisplayed());
        Assert.assertTrue(UserProfilePageObjective.value_GenderInfo(driver).isDisplayed());
        Assert.assertTrue(UserProfilePageObjective.value_BirthdayInfo(driver).isDisplayed());
        Assert.assertTrue(UserProfilePageObjective.value_PositionInfo(driver).isDisplayed());
    }
}
