package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.ResourceBundle;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_Objecive_Detail_Key_Result_Edit;
import utility.Common;

public class Objective_Key_Result_Edit extends Common {
	ResourceBundle properties_value;
	private WebDriver driver;

	public Objective_Key_Result_Edit() {
		this.driver = Hooks.getDriver();
	}
	
	@When("^User input \"([^\"]*)\" $")
	public void user_input(String New_Keyresult_Weight) {
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objecive_Detail_Key_Result_Edit.txtWeightKeyResult(driver));
		pageObj_Objecive_Detail_Key_Result_Edit.txtWeightKeyResult(driver).clear();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value='" + New_Keyresult_Weight + "';",
				pageObj_Objecive_Detail_Key_Result_Edit.txtWeightKeyResult(driver));
		}
	
	@Then ("^\"([^\"]*)\" is updated$")
	public void is_updated(String Keyresult_Name, String New_Keyresult_Weight) {
		driver.navigate().refresh();
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objecive_Detail_Key_Result_Edit.linkKeyResult(driver, Keyresult_Name));
		visibilityOfElementToBeClickable(driver, 20, pageObj_Objecive_Detail_Key_Result_Edit.txtWeightKeyResult(driver));
		String new_weight = pageObj_Objecive_Detail_Key_Result_Edit.txtWeightKeyResult(driver).getText();
		assertEquals(New_Keyresult_Weight, new_weight);
	}
}
