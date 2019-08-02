package stepDefinition;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.PageObj_Add_New_Objective;
import pageObject.PageObj_Objective_LinkTo;
import pageObject.pageObj_ObjDetail_QuickActions;
import utility.Common;

public class LinkTo_Details extends Common {
	private WebDriver driver;
	ResourceBundle check_value = ResourceBundle.getBundle("data_objective_linkto");

	public LinkTo_Details() {
		this.driver = Hooks.getDriver();
	}

	public void user_creates_new_objective_with_valid_data() throws Throwable {
		Add_New_Objective addObj = new Add_New_Objective();
		String weight = check_value.getString("WEIGHT");
		addObj.user_is_on_Add_Objective_form();
		addObj.user_enters_valid_objective_name();
		addObj.user_enters_weight_is_in_step(weight);
		addObj.user_perform_to_add_new_Objective();

	}

	public void user_creats_new_linkto() {
		ObjDetail_QuickActions addLinkTo = new ObjDetail_QuickActions();
		String objectname = check_value.getString("OBJECT_LINKTO");
		String krname = check_value.getString("KRNAME");
		// open quick action popup of objective
		addLinkTo.user_opens_Quick_Actions_popup_of_Objective();
		// open Link to Key Result popup
		addLinkTo.user_performs_to_open_Link_to_Key_Result_popup();
		// choose valid Group
		addLinkTo.user_selects_valid_Group_and_go_to_the_next_step();
		// select the Objective
		addLinkTo.user_selects_the_Objective_and_go_to_the_next_step(objectname);
		// select KR
		addLinkTo.user_opens_and_selects_Key_Result_in_Key_Result_dropdown(krname);
		// User performs to submit at Select Key Result screen
		addLinkTo.user_performs_to_submit_at_Select_Key_Result_screen();
	}

	@Given("^User navigates to Objective details has linkto$")
	public void user_navigates_to_Objective_details_has_linkto() throws Throwable {
		String objname = check_value.getString("OBJNAME");
		String newobject = check_value.getString("OBJECT_LINKTO");
		String krname = check_value.getString("KRNAME");
		try {
			Assert.assertTrue(pageObj_ObjDetail_QuickActions.DB_ObjectiveName(driver, objname).isDisplayed());
			moveToElement(driver, pageObj_ObjDetail_QuickActions.DB_ObjectiveName(driver, objname));
			pageObj_ObjDetail_QuickActions.DB_ObjectiveName(driver, objname).click();
			try {
				Assert.assertTrue(
						PageObj_Objective_LinkTo.Objective_btn_QuickAction(driver, newobject, krname).isDisplayed());
				moveToElement(driver, PageObj_Objective_LinkTo.Objective_btn_QuickAction(driver, newobject, krname));
			} catch (NoSuchElementException e) {
				user_creats_new_linkto();
			}

		}

		catch (NoSuchElementException e) {
			user_creates_new_objective_with_valid_data();
			user_creats_new_linkto();
		}
	}

	@When("^User clicks group link of linkto$")
	public void user_clicks_group_link_of_linkto() {
		String group = check_value.getString("GROUP");
		PageObj_Objective_LinkTo.Objective_link_groupname(driver, group).click();
	}

	@Then("^Corresponding group screen dislays$")
	public void corresponding_screen_dislays(String group) {
		visibilityOf(driver, 10, PageObj_Objective_LinkTo.Group_lb_grouptitle(driver));
		String lastgroupname = PageObj_Objective_LinkTo.Group_lb_grouptitle(driver).getText();
		Assert.assertEquals(lastgroupname, group);

	}

	@When("^User clicks objective link$")
	public void user_clicks_object_link() {
		String newobject = check_value.getString("OBJECT_LINKTO");
		PageObj_Objective_LinkTo.Objective_link_object(driver, newobject).click();
	}

	@Then("^corresponding objective Details screen dislays$")
	public void corresponding_Details_screen_dislays(String object) {
		visibilityOf(driver, 10, PageObj_Add_New_Objective.objDetails_lb_objname(driver));
		String latestname = PageObj_Add_New_Objective.objDetails_lb_objname(driver).getText();
		Assert.assertEquals(latestname, object);
	}

	@When("^User performs to open Quick Action popup$")
	public void user_performs_to_open_Quick_Action_popup() {
		String newobject = check_value.getString("OBJECT_LINKTO");
		String krname = check_value.getString("KRNAME");
		PageObj_Objective_LinkTo.Objective_btn_QuickAction(driver, newobject, krname).click();
	}

	@Then("^Quick Action popup dislays$")
	public void quick_Action_popup_dislays() {
		String newobject = check_value.getString("OBJECT_LINKTO");
		String krname = check_value.getString("KRNAME");
		Assert.assertTrue(
				PageObj_Objective_LinkTo.Objective_popup_QuickAction(driver, newobject, krname).isDisplayed());
	}

	@When("^User performs to open Cancel link request dialog$")
	public void user_performs_to_open_Cancel_link_request_dialog() {
		String object = check_value.getString("OBJNAME");
		PageObj_Objective_LinkTo.Objective_QuickAction_btn_cancel(driver, object).click();
	}

	@Then("^Cancel link request dialog displays$")
	public void cancel_link_request_dialog_displays() {
		PageObj_Objective_LinkTo.Objective_popup_CancelLink(driver).isDisplayed();
		String title = check_value.getString("CANCELTITLE");
		String canceltitle = PageObj_Objective_LinkTo.Objective_CancelLink_lb_title(driver).getText();
		Assert.assertEquals(canceltitle, title);
	}

	@When("^User performs to close Cancel link request dialog$")
	public void user_performs_to_close_Cancel_link_request_dialog() {
		PageObj_Objective_LinkTo.Objective_CancelLink_btn_Close(driver).click();
	}

	@Then("^Cancel link request dialog is closed$")
	public void cancel_link_request_dialog_is_closed() {
		Assert.assertFalse(PageObj_Objective_LinkTo.Objective_popup_CancelLink(driver).isDisplayed());

	}

	@Then("^Linkto is existing$")
	public void linkto_is_existing(String group) {
		PageObj_Objective_LinkTo.Objective_link_groupname(driver, group).isDisplayed();
	}

	@When("^User performs to confirm cancel link to$")
	public void user_performs_to_confirm_cancel_link_to() {
		PageObj_Objective_LinkTo.Objective_CancelLink_btn_Cancel(driver).click();
	}

	@Then("^Message displays \"([^\"]*)\"$")
	public void message_displays(String message) {
		String successmess = PageObj_Objective_LinkTo.Objective_lb_message(driver).getText();
		Assert.assertEquals(successmess, message);
	}

	@Then("^linkto has been canceled is not existing$")
	public void linkto_has_been_canceled_is_not_existing() {
		String newobject = check_value.getString("OBJECT_LINKTO");
		String krname = check_value.getString("KRNAME");
		Assert.assertFalse(PageObj_Objective_LinkTo.Objective_btn_QuickAction(driver, newobject, krname).isDisplayed());
		;
	}

}
