package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPageObject {
    private static WebElement element = null;

    public static WebElement lb_logoFgoal(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@class='m-brand__logo-wrapper']//img"));
        return element;
    }
    public static WebElement leftMenu_users(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        return element;
    }

    public static WebElement btn_closeDebugBar(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@class='phpdebugbar-close-btn']"));
        return element;
    }

    public static WebElement txt_searchGroup(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='m_quicksearch_input_search']"));
        return element;
    }

    public static WebElement lb_suggest_group(WebDriver driver, String group_name) {
        element = driver.findElement(By.xpath("//div[@class='m-dropdown__content-search']//span[contains(text(),'" + group_name + "')]"));
        return element;
    }

    public static WebElement icon_notification(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@id='m_topbar_notification_icon']"));
        return element;
    }

    public static WebElement leftMenu_units(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Units')]"));
        return element;
    }

    public static WebElement leftMenu_yearPlan(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Year Plan')]"));
        return element;
    }

    public static WebElement leftMenu_organizationChart(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Organization Chart')]"));
        return element;
    }

    public static WebElement leftMenu_myGroups(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@class='m-menu__link m-menu__toggle']//span[@class='m-menu__link-text'][contains(text(),'My Groups')]"));
        return element;
    }

    public static WebElement leftMenu_pinGroups(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@class='m-menu__link m-menu__toggle']//span[@class='m-menu__link-text'][contains(text(),'Pin Groups')]"));
        return element;
    }

    public static WebElement leftMenu_timeLine(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[@class='m-menu__link-text'][contains(text(),'Timeline')]"));
        return element;
    }

    public static WebElement leftMenu_users(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        return element;
    }

    public static WebElement leftMenu_logOut(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Logout')]"));
        return element;
    }

    public static WebElement lb_footer(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[@class='m-footer__copyright']"));
        return element;
    }

    public static WebElement txt_timeFrame(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='groupQuaterDashboard col-form-label col-lg-2 col-md-2']"));
        return element;
    }

    public static WebElement lb_nameGroup(WebDriver driver, String group_name) {
        element = driver.findElement(By.xpath("//li[@class='breadcrumb-item active'][contains(text(), '" + group_name + "')]"));
        return element;
    }

    public static WebElement lb_listUnit(WebDriver driver) {
        element = driver.findElement(By.xpath("//h3[@class='m-portlet__head-text'][contains(text(), 'List unit')]"));
        return element;
    }

    public static WebElement lb_listYearPlan(WebDriver driver) {
        element = driver.findElement(By.xpath("//h3[@class='m-portlet__head-text'][contains(text(), 'List Year Plan')]"));
        return element;
    }

    public static WebElement lb_organizationChart(WebDriver driver) {
        element = driver.findElement(By.xpath("//h3[@class='m-portlet__head-text'][contains(text(), 'Organization Chart')]"));
        return element;
    }

    public static WebElement lb_listUsers(WebDriver driver) {
        element = driver.findElement(By.xpath("//h3[@class='m-portlet__head-text'][contains(text(), 'List user')]"));
        return element;
    }

    public static WebElement lnk_myProfile(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'My Profile')]"));
        return element;
    }

    public static WebElement lnk_email(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@class='m-card-user__email m--font-weight-300 m-link name_long_text']"));
        return element;
    }


}
