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

    public static WebElement img_avatarProfile(WebDriver driver) {
        element = driver.findElement(By.xpath("//img[@class='m--img-rounded m--marginless w-100']"));
        return element;
    }

    public static WebElement btn_logout(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[contains(@class,'btn-secondary m-btn m-btn--custom m-btn--label-brand m-btn--bolder')]"));
        return element;
    }

    public static WebElement leftMenu_dashboard(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
        return element;
    }

    public static WebElement btn_closeDebugBar(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@class='phpdebugbar-close-btn']"));
        return element;
    }
}
