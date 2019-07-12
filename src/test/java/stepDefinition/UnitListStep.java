package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageObject.UnitListPageObject;
import utility.Common;

import java.util.ResourceBundle;

public class UnitListStep extends Common {

    private WebDriver driver;
    private ResourceBundle data_unit = ResourceBundle.getBundle("data_unit");
    private String defaultUnit;

    public UnitListStep() {
        this.driver = Hooks.getDriver();
    }

    @Given("^User is on Unit List page$")
    public void user_is_on_Unit_List_page() {
        // Click on Unit link
        visibilityOfElementToBeClickable(driver, 20, UnitListPageObject.link_Unit(driver));
        UnitListPageObject.link_Unit(driver).click();
    }

    @Then("^Unit List page displays correctly with all item$")
    public void unit_List_page_displays_correctly_with_all_item() {
        // Check if Label of page display
        visibilityOf(driver, 20, UnitListPageObject.lbl_UnitTitle(driver));
        Assert.assertTrue(UnitListPageObject.lbl_UnitTitle(driver).isDisplayed());
        String actual_label = UnitListPageObject.lbl_UnitTitle(driver).getText();
        String expected_label = data_unit.getString("label_unit");
        Assert.assertEquals(expected_label, actual_label);

        // Check if Add new unit button display
        visibilityOfElementToBeClickable(driver, 20, UnitListPageObject.btn_addNewUnit(driver));
        Assert.assertTrue(UnitListPageObject.btn_addNewUnit(driver).isDisplayed());

        // Check if Search box display
        visibilityOf(driver, 20, UnitListPageObject.txt_searchBox(driver));
        Assert.assertTrue(UnitListPageObject.txt_searchBox(driver).isDisplayed());

        // Check if Set default Unit display
        visibilityOfElementToBeClickable(driver, 20, UnitListPageObject.btn_setDefaultUnit(driver));
        Assert.assertTrue(UnitListPageObject.btn_setDefaultUnit(driver).isDisplayed());
        Assert.assertTrue(UnitListPageObject.drd_defaultUnit(driver).isDisplayed());

        // Check if Unit table display
        visibilityOfElementToBeClickable(driver, 20, UnitListPageObject.column_NO(driver));
        Assert.assertTrue(UnitListPageObject.column_NO(driver).isDisplayed());
        Assert.assertTrue(UnitListPageObject.column_Unit(driver).isDisplayed());
        Assert.assertTrue(UnitListPageObject.column_Action(driver).isDisplayed());
    }

    @When("^User perform open add new Unit form$")
    public void user_perform_open_add_new_Unit_form()  {
        // Click on add new Unit button
        visibilityOfElementToBeClickable(driver, 20 , UnitListPageObject.btn_addNewUnit(driver));
        UnitListPageObject.btn_addNewUnit(driver).click();

        // Check if Add new unit PopUp display
        visibilityOf(driver, 20, UnitListPageObject.lbl_addUnit(driver));
        Assert.assertTrue(UnitListPageObject.lbl_addUnit(driver).isDisplayed());
        String expected_label = data_unit.getString("label_add_new_popup");
        String actual_label = UnitListPageObject.lbl_addUnit(driver).getText();
        Assert.assertEquals(expected_label, actual_label);
        Assert.assertTrue(UnitListPageObject.lbl_Unit(driver).isDisplayed());
        Assert.assertTrue(UnitListPageObject.txt_Unit(driver).isDisplayed());
        Assert.assertTrue(UnitListPageObject.btn_addUnit(driver).isDisplayed());
        Assert.assertTrue(UnitListPageObject.btn_closAddUnitPopUp(driver).isDisplayed());
    }

    @When("^User input valid Unit as \"([^\"]*)\"$")
    public void user_input_valid_Unit_as(String validUnit)  {
        // Input valid value for Unit
        UnitListPageObject.txt_Unit(driver).sendKeys(validUnit);
    }

    @When("^User perform add new unit action$")
    public void user_perform_add_new_unit_action()  {
        // Click on Add unit button
        UnitListPageObject.btn_addUnit(driver).click();
    }

    @Then("^Successfully added message displays$")
    public void successfully_added_message_displays() {
        // Check if successfully added message display
        visibilityOf(driver, 20 , UnitListPageObject.mess_addUnitSucess(driver));
        Assert.assertTrue(UnitListPageObject.mess_addUnitSucess(driver).isDisplayed());
        String expected_message = data_unit.getString("add_unit_successfully");
        String actual_message = UnitListPageObject.mess_addUnitSucess(driver).getText();
        Assert.assertEquals(expected_message, actual_message);
    }

    @Then("^New \"([^\"]*)\" displays correctly under the default Unit on Unit table$")
    public void new_displays_correctly_under_the_default_Unit_on_Unit_table(String validUnit)  {
        // Write code here that turns the phrase above into concrete actions
        Select select = new Select(UnitListPageObject.drd_defaultUnit(driver));
        defaultUnit = select.getFirstSelectedOption().getText();
        visibilityOf(driver, 20, UnitListPageObject.column_inputtedUnit(driver, defaultUnit));
        Assert.assertTrue(UnitListPageObject.column_inputtedUnit(driver, defaultUnit).isDisplayed());
        String actual_value = UnitListPageObject.column_inputtedUnit(driver, defaultUnit).getText();
        Assert.assertEquals(validUnit, actual_value);
    }

    @When("^User input unit contain number data$")
    public void user_input_unit_contain_number_data() {
        // Input invalid value for Unit
        UnitListPageObject.txt_Unit(driver).sendKeys(data_unit.getString("unit_contain_number"));
    }

    @Then("^User can not add successfully an Unit and input contain number error message display$")
    public void user_can_not_add_successfully_an_Unit_and_input_contain_number_error_message_display() {
        // Check if successfully added message display
        visibilityOf(driver, 20 , UnitListPageObject.mess_invalidDataUnit(driver));
        Assert.assertTrue(UnitListPageObject.mess_invalidDataUnit(driver).isDisplayed());
        String expected_message = data_unit.getString("error_message_unit_contain_number");
        String actual_message = UnitListPageObject.mess_invalidDataUnit(driver).getText();
        Assert.assertEquals(expected_message, actual_message);
    }

    @When("^User input unit already existed data$")
    public void user_input_unit_already_existed_data(){
        // Input invalid value for Unit
        UnitListPageObject.txt_Unit(driver).sendKeys(data_unit.getString("unit_already_existed"));
    }

    @Then("^User can not add successfully an Unit and duplicate unit error message display$")
    public void user_can_not_add_successfully_an_Unit_and_duplicate_unit_error_message_display()  {
        // Check if successfully added message display
        visibilityOf(driver, 20 , UnitListPageObject.mess_invalidDataUnit(driver));
        Assert.assertTrue(UnitListPageObject.mess_invalidDataUnit(driver).isDisplayed());
        String expected_message = data_unit.getString("error_message_unit_already_existed");
        String actual_message = UnitListPageObject.mess_invalidDataUnit(driver).getText();
        Assert.assertEquals(expected_message, actual_message);
    }

    @Given("^Default number of entries show on Unit table is \"([^\"]*)\"$")
    public void default_number_of_entries_show_on_Unit_table_is(String numberOfEntries) {
        Select select = new Select(UnitListPageObject.drd_showEntries(driver));
        String actual_default_entries = select.getFirstSelectedOption().getText();
        Assert.assertEquals(numberOfEntries, actual_default_entries);
    }

    @When("^User choose any number of entries as \"([^\"]*)\" in Show entries dropdown$")
    public void user_choose_any_number_of_entries_as_in_Show_entries_dropdown(String numberOfEntries)  {
        Select select = new Select(UnitListPageObject.drd_showEntries(driver));
        select.selectByValue(numberOfEntries);
    }

    @Then("^Unit table show \"([^\"]*)\" number of entries chosen before$")
    public void unit_table_show_number_of_entries_chosen_before(String numberOfEntries) {
        String expected_number_entries = data_unit.getString("number_of_entries") + numberOfEntries;
        String actual_number_entries = UnitListPageObject.lbl_showEntries(driver).getText();
        Assert.assertTrue(actual_number_entries.contains(expected_number_entries));
    }
}
