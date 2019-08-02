package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObj_Objective_LinkTo {
	private static WebElement element = null;
	
    public static WebElement Objective_lb_quarter(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[@class='m-badge m-badge--outline-brand m-badge--wide p-2 f-15']"));
        return element;
    }
    public static WebElement Objective_lb_objname(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[@class='m-badge m-badge--outline-brand m-badge--wide p-2 f-15']"));
        return element;
    }

    public static WebElement Objective_link_groupname(WebDriver driver, String group) {
        element = driver.findElement(By.xpath("//a[contains(text(),'" + group + "')]"));
        return element;
    }
    
    public static WebElement Group_lb_grouptitle(WebDriver driver) {
        element = driver.findElement(By.xpath("//li[@class='breadcrumb-item active']"));
        return element;
    }
    
    public static WebElement Objective_link_object(WebDriver driver, String object) {
        element = driver.findElement(By.xpath("//a[contains(text(),'" + object + "')]"));
        return element;
    }
    
    public static WebElement Objective_btn_QuickAction(WebDriver driver, String object, String keyresult) {
        element = driver.findElement(By.xpath("//a[contains(text(),'" + object + "')]/ancestor-or-self::div//label[contains(text(),'"+keyresult+"')]/ancestor-or-self::div[@class='form-group m-form__group row']//a[@id='objective-comment-toggle']"));
        return element;
    }
    
    public static WebElement Objective_popup_QuickAction(WebDriver driver, String object, String keyresult) {
        element = driver.findElement(By.xpath("//a[contains(text(),'" + object + "')]/ancestor-or-self::div//label[contains(text(),'"+keyresult+"')]/ancestor-or-self::div[@class='form-group m-form__group row']//div[@id='dropdown-objective']/div[@class='m-dropdown__wrapper dropdown-small']"));
        return element;
    }
    
    public static WebElement Objective_QuickAction_btn_cancel(WebDriver driver, String object) {
        element = driver.findElement(By.xpath("//a[contains(text(),'" + object + "')]/ancestor-or-self::div[@class='form-group m-form__group row']//div[@id='dropdown-objective']//div[@class='m-dropdown__wrapper dropdown-small']//span[@class='m-nav__link-text']"));
        return element;
    }
    
    public static WebElement Objective_icon_waiting(WebDriver driver, String object, String keyresult) {
        element = driver.findElement(By.xpath("//a[contains(text(),'" + object + "')]/ancestor-or-self::div//label[contains(text(),'"+keyresult+"')]/ancestor-or-self::div[@class='form-group m-form__group row']//div[@class='mt-2 mb-2']//i[@class='icon-ic_waiting m--font-warning size_request_link_status_15']"));
        return element;
    }
    
    public static WebElement Objective_popup_CancelLink(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='cancel2']//div[@class='modal-content']"));
        return element;
    }
    
    public static WebElement Objective_CancelLink_lb_title(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='cancel2']//h4[@class='modal-title']"));
        return element;
    }
    
    public static WebElement Objective_CancelLink_btn_Cancel(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='cancel2']//button[@class='btn btn-danger pull-left btn-delete'][contains(text(),'Cancel link request')]"));
        return element;
    }
    
    public static WebElement Objective_CancelLink_btn_Close(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='cancel2']//button[@class='btn btn-dark'][contains(text(),'Close')]"));
        return element;
    }
    
    public static WebElement Objective_lb_message(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='alert alert-warning alert-dismissible fade show']"));
        return element;
    }

}
