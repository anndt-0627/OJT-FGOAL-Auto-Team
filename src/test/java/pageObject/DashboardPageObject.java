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
}
