package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class QuarterPageObject {
    private static WebElement element = null;

    //xpath on quarter screen
    public static WebElement link_yearPlan(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Year Plan')]"));
        return element;
    }

    public static WebElement btn_newYear(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@class='btn btn-info m-btn m-btn--custom m-btn--icon m-btn--air text-white']"));
        return element;
    }

    public static WebElement lb_newYearList(WebDriver driver) {
        element = driver.findElement(By.xpath("//h3[@class='m-portlet__head-text']"));
        return element;
    }

    public static WebElement item_currentYear(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='accordion']//div[1]//div[1]//h5[1]//a[1]"));
        return element;
    }

    public static WebElement item_quarter(WebDriver driver, String quarter) {
        element = driver.findElement(By.xpath("//b[contains(text(),'" + quarter + "')]"));
        return element;
    }

    public static WebElement drd_quarter(WebDriver driver) {
        element = driver.findElement(By.xpath("//select[@name='current_quarter']"));
        return element;
    }

    public static WebElement msg_successDefault(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        return element;
    }

    public static WebElement item_selectQuarter(WebDriver driver, String quarter) {
        element = driver.findElement(By.xpath("//option[text()='" + quarter + "']"));
        return element;
    }

    public static WebElement item_selectedQuarter(WebDriver driver) {
        element = driver.findElement(By.xpath("//option[@selected]"));
        return element;
    }

    public static WebElement btn_setDefault(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@id='updateDefaultQuater']"));
        return element;
    }

    public static WebElement item_listYears(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@class='dropdown-item']"));
        return element;
    }

    public static WebElement item_year(WebDriver driver, int index) {
        element = driver.findElement(By.xpath("//div[@class='card'][" + index + "]"));
        return element;
    }

    public static List<WebElement> yearList(WebDriver driver) {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='card']"));
        return elements;
    }

    //xpath on add new year
    public static WebElement lb_addYear(WebDriver driver) {
        element = driver.findElement(By.xpath("//h3[@class='m-portlet__head-text']"));
        return element;
    }

    public static WebElement drd_selectYear(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='filter-option-inner']"));
        return element;
    }

    public static WebElement item_selectYear(WebDriver driver, String year) {
        element = driver.findElement(By.xpath("//span[@class='text'][contains(text(),'" + year + "')]"));
        return element;
    }

    public static WebElement err_year(WebDriver driver) {
        element = driver.findElement(By.xpath("//label[@class='error']"));
        return element;
    }

    public static WebElement startTime_01(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='quarter-in-year']//div[1]//div[1]//div[3]//input[1]"));
        return element;
    }

    public static WebElement startTime_02(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='row']//div[2]//div[1]//div[3]//input[1]"));
        return element;
    }

    public static WebElement startTime_03(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[3]//div[1]//div[3]//input[1]"));
        return element;
    }

    public static WebElement startTime_04(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[4]//div[1]//div[3]//input[1]"));
        return element;
    }

    public static WebElement endTime_01(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='quarter-in-year']//div[1]//div[1]//div[4]//input[1]"));
        return element;
    }

    public static WebElement endTime_02(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='row']//div[2]//div[1]//div[4]//input[1]"));
        return element;
    }

    public static WebElement endTime_03(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[3]//div[1]//div[4]//input[1]"));
        return element;
    }

    public static WebElement endTime_04(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[4]//div[1]//div[4]//input[1]"));
        return element;
    }

    public static WebElement btn_addYear(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@class='btn btn-info pull-right prevent-multiClick']"));
        return element;
    }

    //xpath on dashboard page
    public static WebElement link_dashboard(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
        return element;
    }

    public static WebElement item_defaultQuarter(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@id='quarter-select']"));
        return element;
    }

    public static WebElement item_detailQuarter(WebDriver driver) {
        element = driver.findElement(By.xpath(" //span[@class='m-nav__link-text text-center']"));
        return element;
    }

}
