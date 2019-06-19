package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
    private static WebElement element = null;

    public static WebElement btn_loginViaWSM(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@class='btn btn-success m-btn m-btn--pill m-btn--custom m-btn--air m-login__btn m-login__btn--primary btn-lg']"));
        return element;
    }
    public static WebElement btn_loginInWSM(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']"));
        return element;
    }

    public static WebElement txt_userEmail(WebDriver driver) {
        element = driver.findElement(By.xpath("//form[@id='devise-login-form']//input[@id='user_email']"));
        return element;
    }
    public static WebElement txt_password(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='user_password']"));
        return element;
    }
    public static WebElement btn_submitLoginInWSM(WebDriver driver){
        element=driver.findElement(By.xpath("//div[@class='container container-login display-none']//button[1]"));
        return element;
    }
    public static WebElement lbl_logoWSM(WebDriver driver){
        element=driver.findElement(By.xpath("//div[@class='logo']"));
        return element;
    }

}
