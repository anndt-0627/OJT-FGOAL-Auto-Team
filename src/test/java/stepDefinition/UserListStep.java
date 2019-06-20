package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.DashboardPageObject;
import pageObject.UserListPageObject;

import java.text.Normalizer;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class UserListStep {
    private ResourceBundle data_userList = ResourceBundle.getBundle("data_userList");
    private String expected_input;
    private WebDriver driver;
    private WebDriverWait wait;

    public UserListStep() {
        this.driver = Hooks.getDriver();
    }

    @Given("^User navigate to User List$")
    public void user_navigate_to_User_List() {
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.leftMenu_users(driver)));
        DashboardPageObject.leftMenu_users(driver).click();
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.lb_titleUserList(driver)));
    }

    @When("^User search with exited ID exactly match$")
    public void user_search_with_exited_ID_exactly_match() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        expected_input = data_userList.getString("exited_no");
        UserListPageObject.txt_inputSearch(driver).sendKeys(expected_input);
    }

    @Then("^Display results mapping with ID of user")
    public void display_results_mapping_with_ID_of_user() {
        Assert.assertTrue(UserListPageObject.lb_NoColumn(driver).isDisplayed());
        check_search_result();
    }

    @When("^User search with existed ID partial match$")
    public void user_search_with_existed_ID_partial_match() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        expected_input = data_userList.getString("exited_partial_no");
        UserListPageObject.txt_inputSearch(driver).sendKeys(expected_input);
    }

    @When("^User search with exited Name exactly match$")
    public void user_search_with_exited_Name_exactly_match() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        expected_input = data_userList.getString("exited_name");
        UserListPageObject.txt_inputSearch(driver).sendKeys(expected_input);
    }

    @Then("^Display results mapping with Name of user$")
    public void display_results_mapping_with_Name_of_user() {
        Assert.assertTrue(UserListPageObject.lb_NameColumn(driver).isDisplayed());
        int total_result_in_current_page = Integer.parseInt(UserListPageObject.lb_totalResult(driver).getText().split(" ")[3]);
        for (int i = 1; i <= total_result_in_current_page; i++) {
            //Normalized characters
            String actual_name_normalize = Normalizer.normalize(UserListPageObject.lb_ResultMatchingName(driver, 2).getText(), Normalizer.Form.NFD);
            //Compile diacritical mark for Tieng Viet character
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            //Return string after compile
            String actual_name = pattern.matcher(actual_name_normalize).replaceAll("");
            boolean actual_result = actual_name.toLowerCase().contains(expected_input.toLowerCase());
            if (!actual_result) {
                actual_result = UserListPageObject.lb_ResultMatchingEmail(driver, i).getText().contains(expected_input);
                if (!actual_result)
                    Assert.assertTrue("Result list incorrectly", false);
            } else
                Assert.assertTrue(actual_name.toLowerCase().contains(expected_input.toLowerCase()));
        }
    }

    @When("^User search with existed Name partial match$")
    public void user_search_with_existed_Name_partial_match() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        expected_input = data_userList.getString("exited_partial_name");
        UserListPageObject.txt_inputSearch(driver).sendKeys(expected_input);
    }

    @When("^User search with exited Email exactly match$")
    public void user_search_with_exited_Email_exactly_match() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        expected_input = data_userList.getString("exited_email");
        UserListPageObject.txt_inputSearch(driver).sendKeys(expected_input);
    }

    @Then("^Display results mapping with Email of userr$")
    public void display_results_mapping_with_Email_of_user() {
        Assert.assertTrue(UserListPageObject.lb_EmailColumn(driver).isDisplayed());
        int total_result_in_current_page = Integer.parseInt(UserListPageObject.lb_totalResult(driver).getText().split(" ")[3]);
        for (int i = 1; i <= total_result_in_current_page; i++) {
            String actual_email = UserListPageObject.lb_ResultMatchingEmail(driver, i).getText();
            boolean actual_result = actual_email.toLowerCase().contains(expected_input.toLowerCase());
            if (!actual_result) {
                actual_result = UserListPageObject.lb_ResultMatchingName(driver, i).getText().toLowerCase().contains(expected_input);
                if (!actual_result)
                    Assert.assertTrue("Result list incorrectly", false);
            } else
                Assert.assertTrue(actual_email.contains(expected_input));
        }
    }

    @When("^User search with existed Email partial match$")
    public void user_search_with_existed_Email_partial_match() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        expected_input = data_userList.getString("exited_partial_email");
        UserListPageObject.txt_inputSearch(driver).sendKeys(expected_input);
    }

    @When("^User search with exited Code exactly match$")
    public void user_search_with_exited_Code_exactly_match() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        expected_input = data_userList.getString("exited_code");
        UserListPageObject.txt_inputSearch(driver).sendKeys(expected_input);
    }

    @Then("^Display results mapping with Code of user$")
    public void display_results_mapping_with_Code_of_user() {
        Assert.assertTrue(UserListPageObject.lb_CodeColumn(driver).isDisplayed());
        check_search_result();
    }

    @When("^User search with existed Code partial match$")
    public void user_search_with_existed_Code_partial_match() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        expected_input = data_userList.getString("exited_partial_code");
        UserListPageObject.txt_inputSearch(driver).sendKeys(expected_input);
    }

    @When("^User search with Gender is Male$")
    public void user_search_with_Gender_is_Male() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        expected_input = data_userList.getString("female_gender");
        UserListPageObject.txt_inputSearch(driver).sendKeys(expected_input);
    }

    @Then("^Display results mapping with Gender of user$")
    public void display_results_mapping_with_Gender_of_user() {
        Assert.assertTrue(UserListPageObject.lb_GenderColumn(driver).isDisplayed());
        check_search_result();
    }

    @When("^User search with Gender is Female$")
    public void user_search_with_Gender_is_Female() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        expected_input = data_userList.getString("male_gender");
        UserListPageObject.txt_inputSearch(driver).sendKeys(expected_input);
    }

    @When("^User search with exited exited Phone number exactly match$")
    public void user_search_with_exited_Phone_exactly_match() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        expected_input = data_userList.getString("exited_phone");
        UserListPageObject.txt_inputSearch(driver).sendKeys(expected_input);
    }

    @Then("^Display results mapping with Phone of user$")
    public void display_results_mapping_with_Phone_of_user_of_user() {
        Assert.assertTrue(UserListPageObject.lb_PhoneColumn(driver).isDisplayed());
        check_search_result();
    }

    @When("^User search with existed Phone number partial match$")
    public void user_search_with_existed_Phone_partial_match() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        expected_input = data_userList.getString("exited_partial_phone");
        UserListPageObject.txt_inputSearch(driver).sendKeys(expected_input);
    }

    @When("^User search with exited Position exactly match$")
    public void user_search_with_exited_Position_exactly_match() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        expected_input = data_userList.getString("exited_position");
        UserListPageObject.txt_inputSearch(driver).sendKeys(expected_input);
    }

    @Then("^Display results mapping with Position of user$")
    public void display_results_mapping_with_Position_of_user() {
        Assert.assertTrue(UserListPageObject.lb_PositionColumn(driver).isDisplayed());
        check_search_result();
    }

    @When("^User search with existed Position partial match$")
    public void user_search_with_existed_Position_partial_match() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        expected_input = data_userList.getString("exited_partial_position");
        UserListPageObject.txt_inputSearch(driver).sendKeys(expected_input);
    }

    @When("^User search with special characters$")
    public void user_search_with_special_characters() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        UserListPageObject.txt_inputSearch(driver).sendKeys(data_userList.getString("special_characters"));
    }

    @Then("^Has no result on list search$")
    public void has_no_result_on_list_search() {
        String actual_result = UserListPageObject.lb_NoResultMatching(driver).getText();
        String expected_result = data_userList.getString("no_result_matching");
        Assert.assertEquals(expected_result, actual_result);
    }

    @When("^User search with not matching wit any data$")
    public void user_search_with_not_matching_wit_any_data() {
        wait.until(ExpectedConditions.visibilityOf(UserListPageObject.txt_inputSearch(driver)));
        UserListPageObject.txt_inputSearch(driver).sendKeys(data_userList.getString("not_edit_data"));
    }

    private void check_search_result() {
        int total_result_in_current_page = Integer.parseInt(UserListPageObject.lb_totalResult(driver).getText().split(" ")[3]);
        for (int i = 1; i <= total_result_in_current_page; i++) {
            String actual_input = UserListPageObject.lb_ResultMatchingNo(driver, i).getText().toLowerCase();
            expected_input = expected_input.toLowerCase();
            boolean actual_result = actual_input.contains(expected_input);
            if (!actual_result) {
                actual_result = UserListPageObject.lb_ResultMatchingName(driver, i).getText().contains(expected_input);
                if (!actual_result) {
                    actual_result = UserListPageObject.lb_ResultMatchingEmail(driver, i).getText().contains(expected_input);
                    if (!actual_result) {
                        actual_result = UserListPageObject.lb_ResultMatchingCode(driver, i).getText().contains(expected_input);
                        if (!actual_result) {
                            actual_result = UserListPageObject.lb_ResultMatchingGender(driver, i).getText().contains(expected_input);
                            if (!actual_result) {
                                actual_result = UserListPageObject.lb_ResultMatchingPhone(driver, i).getText().contains(expected_input);
                                if (!actual_result) {
                                    actual_result = UserListPageObject.lb_ResultMatchingPosition(driver, i).getText().contains(expected_input);
                                    if (!actual_result) {
                                        Assert.assertTrue("Result list incorrectly", false);
                                    }
                                }
                            }
                        }
                    }
                }
            } else
                Assert.assertTrue(actual_input.contains(expected_input));
        }
    }
}
