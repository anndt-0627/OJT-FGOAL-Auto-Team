package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserProfilePageObjective {
    private static WebElement element;

    public static WebElement icon_avartatProfile(WebDriver driver) {
        element = driver.findElement(By.xpath("//img[@class='m--img-rounded m--marginless w-100']"));
        return element;
    }

    //Profile popup
    public static WebElement popup_lb_nameUser(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[@class='m-card-user__name m--font-weight-500']"));
        return element;
    }

    public static WebElement popup_lb_EmailUser(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@class='m-card-user__email m--font-weight-300 m-link name_long_text']"));
        return element;
    }

    public static WebElement popup_btn_MyProfile(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[@class='m-nav__link-text']"));
        return element;
    }

    //My Profile page
    public static WebElement lb_titleMyProfile(WebDriver driver) {
        element = driver.findElement(By.xpath("//h3[contains(@class,'m-subheader__title')]"));
        return element;
    }

    public static WebElement img_profileAvatar(WebDriver driver) {
        element = driver.findElement(By.xpath("//img[@id='previewImg']"));
        return element;
    }

    public static WebElement lb_profileName(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[@class='m-card-profile__name']"));
        return element;
    }

    public static WebElement lb_profileEmail(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[contains(@class,'m-card-profile__email m-link name_long_text')]"));
        return element;
    }

    //img[@id='previewImg']
    public static WebElement lb_NameInfo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[1]//td[1]"));
        return element;
    }

    public static WebElement value_NameInfo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[1]//td[2]"));
        return element;
    }

    public static WebElement lb_EmailInfo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[2]//td[1]"));
        return element;
    }

    public static WebElement value_EmailInfo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[2]//td[2]"));
        return element;
    }

    public static WebElement lb_CodeInfo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[3]//td[1]"));
        return element;
    }

    public static WebElement value_CodeInfo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[3]//td[2]"));
        return element;
    }

    public static WebElement lb_GroupInfo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[4]//td[1]"));
        return element;
    }

    public static WebElement value_GroupInfo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[4]//td[2]"));
        return element;
    }

    public static WebElement lb_GenderInfo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[5]//td[1]"));
        return element;
    }

    public static WebElement value_GenderInfo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[5]//td[2]"));
        return element;
    }

    public static WebElement lb_PhoneInfo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[6]//td[1]"));
        return element;
    }

    public static WebElement lb_BirthdayInfoo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[7]//td[1]"));
        return element;
    }

    public static WebElement value_BirthdayInfo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[7]//td[2]"));
        return element;
    }

    public static WebElement lb_PositionInfo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[8]//td[1]"));
        return element;
    }
    public static WebElement value_PositionInfo(WebDriver driver) {
        element = driver.findElement(By.xpath("//tr[8]//td[2]"));
        return element;
    }

}
