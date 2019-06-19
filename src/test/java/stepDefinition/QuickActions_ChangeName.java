package stepDefinition;

import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.ResourceBundle;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_QuickActions_ChangeName;

public class QuickActions_ChangeName {
	ResourceBundle properties_value;
	private WebDriver driver;

	public QuickActions_ChangeName() {
		this.driver = Hooks.getDriver();
	}

	@Given("^User goes to FGoal screen$")
	public void user_goes_to_FGoal_screen() {
		properties_value = ResourceBundle.getBundle("data_example");
		driver.get(properties_value.getString("data_example.baseURL"));
	}

	@When("^User perform login into WSM$")
	public void user_perform_login_into_WSM() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://wsm:dangnhap_wsm@edev.sun-asterisk.vn/users/sign_in");
		pageObj_QuickActions_ChangeName.btnWSM_Login(driver).click();
		pageObj_QuickActions_ChangeName.txtWSM_Email(driver).sendKeys("chu.anh.tuan@framgia.com.edev");
		pageObj_QuickActions_ChangeName.txtWSM_Pass(driver).sendKeys("123456");
		pageObj_QuickActions_ChangeName.btnWSM_OK(driver).click();
		Thread.sleep(3000);
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		pageObj_QuickActions_ChangeName.btnLoginViaWSM(driver).click();
	}

	@Then("^FGoal is loggedin and Dashboard screen of FGoal displays$")
	public void fgoal_is_loggedin_and_Dashboard_screen_of_FGoal_displays() throws InterruptedException {
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		assertEquals("https://stg-fgoal.sun-asterisk.vn/", url);
	}

	@Given("^User is on Dashboard screen$")
	public void user_is_on_Dashboard_screen() {
		String url = driver.getCurrentUrl();
		assertEquals("https://stg-fgoal.sun-asterisk.vn/", url);
	}

	@When("^Create a new Objective with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void create_a_new_Objective_with_and(String objName, String objWeight) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", pageObj_QuickActions_ChangeName.btnAddNewObj(driver));

		pageObj_QuickActions_ChangeName.txtName(driver).clear();
		pageObj_QuickActions_ChangeName.txtName(driver).sendKeys(objName);

		pageObj_QuickActions_ChangeName.txtWeight(driver).clear();
		pageObj_QuickActions_ChangeName.txtWeight(driver).sendKeys(objWeight);

		pageObj_QuickActions_ChangeName.btnAddObjective(driver).click();
	}

	@When("^User clicks on the Quick Actions icon in Objective section$")
	public void user_clicks_on_the_Quick_Actions_icon_in_Objective_section() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", pageObj_QuickActions_ChangeName.icoQuickActions(driver));
	}

	@When("^User clicks on \"([^\"]*)\" item in My Objectives section$")
	public void user_clicks_on_item_in_My_Objectives_section(String objName) throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",
				pageObj_QuickActions_ChangeName.DB_ObjectiveName(driver, objName));
		Thread.sleep(3000);
	}

	@When("^User clicks on Update Objective title option in Quick Actions menu$")
	public void user_clicks_on_Update_Objective_title_option_in_Quick_Actions_menu() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",
				pageObj_QuickActions_ChangeName.itmUpdateObjectiveTitle(driver));
	}

	@Then("^Update Objective title popup opens$")
	public void update_Objective_title_popup_opens() throws InterruptedException {
		Thread.sleep(2000);
		String text = pageObj_QuickActions_ChangeName.popupUpdateObjectiveTitle(driver).getAttribute("style");
		assertEquals("padding-right: 17px; display: block;", text);
	}

	@Then("^Title of Update Objective title popup displays$")
	public void title_of_Update_Objective_title_popup_displays() throws InterruptedException {
		Thread.sleep(2000);
		String text = pageObj_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblTitle(driver).getText();
		assertEquals("Update Objective title", text);
	}

	@Then("^Name label and asterisk symbol displays in Update Objective title popup$")
	public void name_label_and_asterisk_symbol_displays_in_Update_Objective_title_popup() {
		String text = pageObj_QuickActions_ChangeName.popupUpdateObjectiveTitle_lblName(driver).getText();
		assertEquals("Name", text);
		String asterisk = pageObj_QuickActions_ChangeName.popupUpdateObjectiveTitle_sybAsterisk(driver).getText();
		assertEquals("*", asterisk);
	}

	@Then("^Name textbox displays in Update Objective title popup$")
	public void name_textbox_displays_in_Update_Objective_title_popup() {
		pageObj_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver).isDisplayed();
	}

	@Then("^Close button displays in Update Objective title popup$")
	public void close_button_displays_in_Update_Objective_title_popup() {
		pageObj_QuickActions_ChangeName.popupUpdateObjectiveTitle_btnClose(driver).isDisplayed();
	}

	@Then("^Update button displays in Update Objective title popup$")
	public void update_button_displays_in_Update_Objective_title_popup() {
		pageObj_QuickActions_ChangeName.popupUpdateObjectiveTitle_btnUpdate(driver).isDisplayed();
	}

	@Then("^The value in Name textbox is equal to \"([^\"]*)\"$")
	public void the_value_in_Name_textbox_is_equal_to(String objName) throws InterruptedException {
		Thread.sleep(2000);
		String text = pageObj_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver).getAttribute("value");
		assertEquals(objName, text);
	}

	@When("^User updates the data with value is \"([^\"]*)\" into Name textbox$")
	public void user_updates_the_data_with_value_is_into_Name_textbox(String valid_value) throws InterruptedException {
		Thread.sleep(2000);
		pageObj_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver).clear();
		pageObj_QuickActions_ChangeName.popupUpdateObjectiveTitle_txtName(driver).sendKeys(valid_value);
	}

	@When("^User submits Update Objective title popup$")
	public void user_submits_Update_Objective_title_popup() throws InterruptedException {
		pageObj_QuickActions_ChangeName.popupUpdateObjectiveTitle_btnUpdate(driver).click();
		Thread.sleep(2000);
	}

	@Then("^Update Objective title popup closes$")
	public void update_Objective_title_popup_closes() throws InterruptedException {
		Thread.sleep(2000);
		String text = pageObj_QuickActions_ChangeName.popupUpdateObjectiveTitle(driver).getAttribute("aria-hidden");
		assertEquals("true", text);
	}

	@Then("^Success message displays$")
	public void success_message_displays() throws InterruptedException {
		Thread.sleep(2000);
		String text = pageObj_QuickActions_ChangeName.msgSuccess(driver).getText();
		assertEquals("Update successful", text);
	}

	@Then("^Objective Name in Objective section is equal to \"([^\"]*)\"$")
	public void objective_Name_in_Objective_section_is_equal_to(String valid_value) throws InterruptedException {
		Thread.sleep(2000);
		String text = pageObj_QuickActions_ChangeName.lblObjectiveName(driver).getText();
		assertEquals(valid_value, text);
	}

	@Then("^The \"([^\"]*)\" displays$")
	public void the_displays(String error_message) throws InterruptedException {
		Thread.sleep(2000);
		String text = pageObj_QuickActions_ChangeName.msgError(driver).getText();
		assertEquals(error_message, text);
	}

	@When("^User clicks on Close button in Update Objective title popup$")
	public void user_clicks_on_Close_button_in_Update_Objective_title_popup() {
		pageObj_QuickActions_ChangeName.popupUpdateObjectiveTitle_btnClose(driver).click();
	}

}
