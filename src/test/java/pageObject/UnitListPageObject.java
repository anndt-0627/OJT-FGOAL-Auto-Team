package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnitListPageObject {
    private static WebElement element = null;

    //---------- Elements of Unit List page ----------
    public static WebElement link_Unit(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Units')]"));
        return element;
    }

    public static WebElement lbl_UnitTitle(WebDriver driver) {
        element = driver.findElement(By.xpath("//h3[contains(@class,'m-portlet__head-text')]"));
        return element;
    }

    public static WebElement btn_addNewUnit(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[contains(@class,'btn btn-info m-btn m-btn--custom m-btn--icon')]"));
        return element;
    }

    public static WebElement txt_searchBox(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[contains(@class,'form-control form-control-sm')]"));
        return element;
    }

    public static WebElement drd_showEntries(WebDriver driver) {
        element = driver.findElement(By.xpath("//select[contains(@name,'dataTables_length')]"));
        return element;
    }

    public static WebElement drd_defaultUnit(WebDriver driver) {
        element = driver.findElement(By.xpath("//select[@name='default_unit']"));
        return element;
    }

    public static WebElement btn_setDefaultUnit(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[contains(@class,'btn btn-info ml-2')]"));
        return element;
    }

    public static WebElement column_NO(WebDriver driver) {
        element = driver.findElement(By.xpath("//th[contains(@class,'sorting_desc')]"));
        return element;
    }

    public static WebElement column_Unit(WebDriver driver) {
        element = driver.findElement(By.xpath("//th[contains(text(),'Unit')]"));
        return element;
    }

    public static WebElement column_Action(WebDriver driver) {
        element = driver.findElement(By.xpath("//th[contains(@class,'sorting_disabled')]"));
        return element;
    }

    public static WebElement column_defaultUnit(WebDriver driver, String defaultUnit) {
        element = driver.findElement(By.xpath("//td[contains(text(),'" + defaultUnit + "')]"));
        return element;
    }

    public static WebElement column_inputtedUnit(WebDriver driver, String defaultUnit) {
        element = driver.findElement(By.xpath("//td[contains(text(),'" + defaultUnit + "')]/ancestor-or-self::table[@id='dataTables']//tr[2]//td[2]"));
        return element;
    }

    public static WebElement mess_addUnitSucess(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        return element;
    }

    public static WebElement mess_invalidDataUnit(WebDriver driver) {
        element = driver.findElement(By.xpath("//p[@class='alert alert-danger']"));
        return element;
    }

    public static WebElement lbl_showEntries(WebDriver driver) {
        element = driver.findElement(By.xpath(" //div[@id='dataTables_info']"));
        return element;
    }


    //---------- Elements of Add New Unit PopUp ----------
    public static WebElement lbl_addUnit(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='myModal']//div[contains(@class,'modal-header')]"));
        return element;
    }

    public static WebElement txt_Unit(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='title-<?php echo e($unit->id); ?>']"));
        return element;
    }

    public static WebElement lbl_Unit(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='myModal']//label[contains(text(),'Unit')]"));
        return element;
    }

    public static WebElement btn_addUnit(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[contains(text(),'Add unit')]"));
        return element;
    }

    public static WebElement btn_closAddUnitPopUp(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[contains(@class,'btn btn-dark pull-left')][contains(text(),'Close')]"));
        return element;
    }
}