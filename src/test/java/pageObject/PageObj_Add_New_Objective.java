package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObj_Add_New_Objective {
	private static WebElement element = null;
	public final String weight = "2";

    public static WebElement dashboard_btn_AddObj(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@id='btn-createObj']"));
        return element;
    }
    
    public static WebElement addObj_ddl_quarter(WebDriver driver) {
        element = driver.findElement(By.xpath("//h5[@id='titleQuarter']"));
        return element;
    }
    
    public static WebElement addObj_tbx_name(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@name='name']"));
        return element;
    }
    
    public static WebElement addObj_tbx_weight(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@name='weight']"));
        return element;
    }
    
    public static WebElement addObj_btn_AddObj(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='modal-footer']//button[@type='submit']"));
        return element;
    }
    
    public static WebElement addObj_lb_errorname(WebDriver driver) {
        element = driver.findElement(By.xpath("//label[@id='name-error']"));
        return element;
    }
    
    public static WebElement addObj_lb_errorweight(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='error input-group']"));
        return element;
    }
    
    public static WebElement objDetails_lb_successfulmessage(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        return element;
    }
    
    public static WebElement objDetails_lb_objname(WebDriver driver) {
        element = driver.findElement(By.xpath("//label[@class='col-form-label mt-n1 float-left label-obj']"));
        return element;
    }
    
    public static WebElement objDetails_txb_weight(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@class='form-control m-input objectiveWeight pdtl']"));
        return element;
    }
    public static WebElement objDetails_lb_quarter(WebDriver driver, String quarter) {
        element = driver.findElement(By.xpath("//strong[contains(text(),'" + quarter + "')]"));
        return element;
    }
    
  
}
