package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObjDemo {
    private static WebElement element = null;

    public static WebElement link_Objective(WebDriver driver, String objectiveName) {
        element = driver.findElement(By.xpath("//a[@class='w3-bar-item w3-button'][contains(text(),'" + objectiveName + "')]"));
        return element;
    }


}
