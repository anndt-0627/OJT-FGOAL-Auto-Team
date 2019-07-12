package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserListPageObject {
    private static WebElement element;

    public static WebElement lb_titleUserList(WebDriver driver) {
        element = driver.findElement(By.xpath("//h3[@class='m-portlet__head-text']"));
        return element;
    }

    public static WebElement txt_inputSearch(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@class='form-control form-control-sm']"));
        return element;
    }

    public static WebElement drd_pagingOption(WebDriver driver) {
        element = driver.findElement(By.xpath("//select[@name='dataTables_length']"));
        return element;
    }

    //Title of Table list search result
    public static WebElement lb_NoColumn(WebDriver driver) {
        element = driver.findElement(By.xpath("//th[contains(text(),'NO')]"));
        return element;
    }

    public static WebElement lb_NameColumn(WebDriver driver) {
        element = driver.findElement(By.xpath("//th[contains(text(),'Name')]    "));
        return element;
    }

    public static WebElement lb_EmailColumn(WebDriver driver) {
        element = driver.findElement(By.xpath("//th[contains(text(),'Email')]"));
        return element;
    }

    public static WebElement lb_CodeColumn(WebDriver driver) {
        element = driver.findElement(By.xpath("//th[contains(text(),'Code')]"));
        return element;
    }

    public static WebElement lb_GenderColumn(WebDriver driver) {
        element = driver.findElement(By.xpath("//th[contains(text(),'Gender')]"));
        return element;
    }

    public static WebElement lb_PhoneColumn(WebDriver driver) {
        element = driver.findElement(By.xpath("//th[contains(text(),'Phone')]"));
        return element;
    }

    public static WebElement lb_PositionColumn(WebDriver driver) {
        element = driver.findElement(By.xpath("//th[contains(text(),'Position')]"));
        return element;
    }

    //List search result
    public static WebElement lb_ResultMatchingNo(WebDriver driver,int index_result) {
        element = driver.findElement(By.xpath("//table[@id='dataTables']//tbody/tr["+index_result+"]/td[position()=1]"));
        return element;
    }
    public static WebElement lb_ResultMatchingName(WebDriver driver,int index_result) {
        element = driver.findElement(By.xpath("//table[@id='dataTables']//tbody/tr["+index_result+"]/td[position()=2]"));
        return element;
    }
    public static WebElement lb_ResultMatchingEmail(WebDriver driver,int index_result) {
        element = driver.findElement(By.xpath("//table[@id='dataTables']//tbody/tr["+index_result+"]/td[position()=3]"));
        return element;
    }
    public static WebElement lb_ResultMatchingCode(WebDriver driver,int index_result) {
        element = driver.findElement(By.xpath("//table[@id='dataTables']//tbody/tr["+index_result+"]/td[position()=4]"));
        return element;
    }
    public static WebElement lb_ResultMatchingGender(WebDriver driver,int index_result) {
        element = driver.findElement(By.xpath("//table[@id='dataTables']//tbody/tr["+index_result+"]/td[position()=5]"));
        return element;
    }
    public static WebElement lb_ResultMatchingPhone(WebDriver driver,int index_result) {
        element = driver.findElement(By.xpath("//table[@id='dataTables']//tbody/tr["+index_result+"]/td[position()=6]"));
        return element;
    }
    public static WebElement lb_ResultMatchingPosition(WebDriver driver,int index_result) {
        element = driver.findElement(By.xpath("//table[@id='dataTables']//tbody/tr["+index_result+"]/td[position()=7]"));
        return element;
    }

    public static WebElement lb_NoResultMatching(WebDriver driver) {
        element = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
        return element;
    }

    //Number search result
    public static WebElement lb_totalResult(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='dataTables_info']"));
        return element;
    }
}
