package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.pageObj_ObjectDetail_Comment;
import utility.Common;

public class Objective_Detail_Comment extends Common {
	ResourceBundle properties_value = ResourceBundle.getBundle("dataObjective_Comment");
	private WebDriver driver;

	public Objective_Detail_Comment() {
		this.driver = Hooks.getDriver();
	}

	@Given("^User is on Dashboard screen$")
	public void user_is_on_Dashboard_screen() {
		pageObj_ObjectDetail_Comment.menuDashboard(driver).click();
	}

	@When("^User select \"([^\\\"]*)\" in My Objectives$")
	public void user_select_in_my_objectives (String ObjectiveName){
		visibilityOfElementToBeClickable(driver, 20,
				pageObj_ObjectDetail_Comment.ObjectiveName(driver));
		moveToElement(driver, pageObj_ObjectDetail_Comment.ObjectiveName(driver));
		pageObj_ObjectDetail_Comment.ObjectiveName(driver).click();
	}
	
	@When ("^User click on icon text box in My Objectives$")
	public void user_click_on_icon_text_box_in_My_Objectives(){
		visibilityOf(driver, 20, pageObj_ObjectDetail_Comment.ObjectiveIconShowComment(driver));
		pageObj_ObjectDetail_Comment.ObjectiveIconShowComment(driver).click();
	}
	
	@Then ("^Text box comment of objective is displayed$")
	public void text_box_comment_of_objective_is_displayed(){
		visibilityOf(driver, 20, pageObj_ObjectDetail_Comment.ObjectiveTextboxInputComment(driver));
	}
	
	@When ("^User input a \"([^\\\"]*)\"$")
	public void user_input_a_valid_comment(String ValidComment){
		visibilityOf(driver, 20, pageObj_ObjectDetail_Comment.ObjectiveTextboxInputComment(driver));
		pageObj_ObjectDetail_Comment.ObjectiveTextboxInputComment(driver).clear();
		pageObj_ObjectDetail_Comment.ObjectiveTextboxInputComment(driver).sendKeys(ValidComment);
	}
	
	@When ("^User perform add comment action$")
	public void user_perform_add_comment_action() {
		pageObj_ObjectDetail_Comment.ObjectiveTextboxInputComment(driver).submit();
	}
	
	@Then  ("^The \"([^\\\"]*)\" user has just submit is displayed $")
	public void the_user_has_just_submit_is_dislpayed (String ValidComment) {
		visibilityOf(driver, 20, pageObj_ObjectDetail_Comment.ObjectiveContentComment(driver, ValidComment));
		String actual_Comment = pageObj_ObjectDetail_Comment.ObjectiveContentComment(driver, ValidComment).getText();
			assertEquals(ValidComment, actual_Comment);
	}
	
	@Then  ("^Number of comment is updated exactly $")
	public void number_of_comment_is_updated_exactly (String ValidComment) {
		visibilityOf(driver, 20, pageObj_ObjectDetail_Comment.ObjectiveNumberComment(driver));
		String old_number = pageObj_ObjectDetail_Comment.ObjectiveNumberComment(driver).getText();
		int number1 = Integer.parseInt(old_number);
		visibilityOf(driver, 20, pageObj_ObjectDetail_Comment.ObjectiveTextboxInputComment(driver));
		pageObj_ObjectDetail_Comment.ObjectiveTextboxInputComment(driver).clear();
		pageObj_ObjectDetail_Comment.ObjectiveTextboxInputComment(driver).submit();
		visibilityOf(driver, 20, pageObj_ObjectDetail_Comment.ObjectiveNumberComment(driver));
		String new_number = pageObj_ObjectDetail_Comment.ObjectiveNumberComment(driver).getText();
		int number2 = Integer.parseInt(new_number);
		assertEquals(number1+1, number2);
	}
	
	@When ("^User input a \"([^\\\"]*)\"$")
	public void user_input_a_long_comment(String LongComment){
		visibilityOf(driver, 20, pageObj_ObjectDetail_Comment.ObjectiveTextboxInputComment(driver));
		pageObj_ObjectDetail_Comment.ObjectiveTextboxInputComment(driver).clear();
		pageObj_ObjectDetail_Comment.ObjectiveTextboxInputComment(driver).sendKeys(LongComment);
		visibilityOf(driver, 20, pageObj_ObjectDetail_Comment.ObjectiveContentComment(driver, LongComment));
		String actual_Comment = pageObj_ObjectDetail_Comment.ObjectiveContentComment(driver, LongComment).getText();
			assertEquals(LongComment, actual_Comment);
	}
	
	@When ("^User User open text box comment$")
	public void user_open_text_box_comment(String ValidComment, String NewComment){
		visibilityOf(driver, 20, pageObj_ObjectDetail_Comment.ObjectiveContentComment(driver,ValidComment ));
		pageObj_ObjectDetail_Comment.ObjectiveContentComment(driver, ValidComment).click();
		pageObj_ObjectDetail_Comment.ObjectiveTextboxInputComment(driver).clear();
		pageObj_ObjectDetail_Comment.ObjectiveTextboxInputComment(driver).sendKeys(NewComment);
		pageObj_ObjectDetail_Comment.ObjectiveTextboxInputComment(driver).submit();
	}
	
	@Then ("^The \"([^\\\"]*)\" user has just submit is displayed$")
	public void the_user_has_just_submit_is_displayed (String NewComment){
		visibilityOf(driver, 20, pageObj_ObjectDetail_Comment.ObjectiveContentComment(driver, NewComment));
		String actual_Comment = pageObj_ObjectDetail_Comment.ObjectiveContentComment(driver, NewComment).getText();
			assertEquals(NewComment, actual_Comment);
	}
}

