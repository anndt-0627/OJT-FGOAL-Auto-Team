package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObj_Add_New_Objective {
	private static WebElement element = null;
	public final String weight = "2";
	public static String btn_fgoal_AddObj = "//button[@id='btn-createObj']";
	public static String ddl_fgoal_AddObj_quarter = "//h5[@id='titleQuarter']";
    public static String tbx_fgoal_AddObj_name = "//input[@name='name']";
    public static String tbx_fgoal_AddObj_weight = "//input[@name='weight']";
    public static String btn_fgoal_AddObj_add = "//div[@class='modal-footer']//button[@type='submit']";
	public static String lb_fgoal_AddObj_error_name = "//label[@id='name-error']";
	public static String lb_fgoal_AddObj_error_weight = " //div[@class='error input-group']";
	public static String lb_fgoal_success_message = "//div[@class='alert alert-success']";
	public static String lb_fgoal_Objective_name = "//label[@class='col-form-label mt-n1 float-left label-obj']";
	public static String tbx_fgoal_Objective_weight = "//input[@class='form-control m-input objectiveWeight pdtl']";
	
    public static WebElement get_element(WebDriver driver, String xpath) {
        element = driver.findElement(By.xpath(xpath));
        return element;
    }
}
