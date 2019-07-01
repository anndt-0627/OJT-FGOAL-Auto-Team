package stepDefinition;

import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.ResourceBundle;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_ObjectDetails_View;

public class Objective_Details_View {
	ResourceBundle properties_value;
	private WebDriver driver;

	public Objective_Details_View() {
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
		pageObj_ObjectDetails_View.btnWSM_Login(driver).click();
		pageObj_ObjectDetails_View.txtWSM_Email(driver).sendKeys("chu.anh.tuan@framgia.com.edev");
		pageObj_ObjectDetails_View.txtWSM_Pass(driver).sendKeys("123456");
		pageObj_ObjectDetails_View.btnWSM_OK(driver).click();
		Thread.sleep(3000);
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		pageObj_ObjectDetails_View.btnLoginViaWSM(driver).click();
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
		executor.executeScript("arguments[0].click();", pageObj_ObjectDetails_View.btnAddNewObj(driver));

		pageObj_ObjectDetails_View.txtName(driver).clear();
		pageObj_ObjectDetails_View.txtName(driver).sendKeys(objName);

		pageObj_ObjectDetails_View.txtWeight(driver).clear();
		pageObj_ObjectDetails_View.txtWeight(driver).sendKeys(objWeight);

		pageObj_ObjectDetails_View.btnAddObjective(driver).click();
	}

	@When("^User back to Dashboard screen$")
	public void user_back_to_Dashboard_screen() {
		String url = driver.getCurrentUrl();
		assertEquals("https://stg-fgoal.sun-asterisk.vn/", url);
	}

	@When("^User can navigate to screen objective detail to view$")
	public void user_can_navigate_to_screen_objective_detail_to_view() throws InterruptedException {
		Thread.sleep(2000);
		String objName = "CHAUTTB_01";
		String expectedString = "detail_objective";
		pageObj_ObjectDetails_View.linkObjectiveName(driver, objName ).click();
		String url = driver.getCurrentUrl();
		assertTrue(url.contains(expectedString));
		}

	@Then("^Quarter of objective is displayed corectly$")
	public void quarter_of_objective_is_displayed_corectly() throws InterruptedException {
		Thread.sleep(2000);
		String objQuater = "Quarter 2";
		String text = pageObj_ObjectDetails_View.lblObjectiveQuater(driver).getText();
		assertEquals(objQuater, text);
	}

	@Then("^Name of objective is displayed corectly$")
	public void name_of_objective_is_displayed_corectly() throws InterruptedException {
		Thread.sleep(2000);
		String objName = "CHAUTTB_01";
		String text = pageObj_ObjectDetails_View.lblObjectiveName(driver).getText();
		assertEquals(objName, text);
	}

}