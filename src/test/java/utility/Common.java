package utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.DashboardPageObject;

import java.util.List;

public class Common {
    private static final Logger LOGGER = Logger.getLogger(Common.class);

    private static WebDriver driver = null;

    protected static void sleepOfThread(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    protected static WebElement visibilityOfElementToBeClickable(WebDriver driver, long timeout, WebElement element) {
        return (new WebDriverWait(driver, timeout))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected static void visibilityOf(WebDriver driver, long timeout, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected static void visibilityOfAllElementsOfWait(WebDriver driver, long timeout, List<WebElement> listResult) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfAllElements(listResult));
    }

    protected static void moveToElement(WebDriver driver, WebElement element) {
        if (DashboardPageObject.btn_closeDebugBar(driver).isDisplayed()) {
            DashboardPageObject.btn_closeDebugBar(driver).click();
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
        } else {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
        }

    }

    protected static void switchToNewWindow(WebDriver driver) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

}
