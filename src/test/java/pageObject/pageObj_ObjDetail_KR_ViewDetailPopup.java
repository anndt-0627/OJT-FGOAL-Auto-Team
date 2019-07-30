package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_ObjDetail_KR_ViewDetailPopup {
	private static WebElement element = null;

	public static WebElement popupViewDetail_progressbar(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//div[@class='m-nouislider--drag-danger keyResultSliderDetail ob-danger noUi-target noUi-ltr noUi-horizontal']//div[@class='noUi-base']"));
		return element;
	}

	public static WebElement popupViewDetail_txtProgress(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='keyResultSliderDetailInput']"));
		return element;
	}

	public static WebElement popupViewDetail_txtWeight(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@class='form-control m-input keyResultWeightInputDetail']"));
		return element;
	}

	public static WebElement popupViewDetail_lnkConfig(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//div[@class='col-lg-12 m--margin-top-25']//a[@id='showSetupCalActual']"));
		return element;
	}

	public static WebElement popupViewDetail_LinkObjectives(WebDriver driver) {
		element = driver.findElement(By.xpath("//h5[contains(text(),'Link objectives')]"));
		return element;
	}

	public static WebElement popupViewDetail_msgToast(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='toast-message']"));
		return element;
	}

	public static WebElement popupViewDetail_lnkDesc(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//div[@class='row align-items-center']//a[@class='pl-2 text-muted m-link'][contains(text(),'Description')]"));
		return element;
	}

	public static WebElement popupViewDetail_txtDesc(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//div[@id='ks-dt-description4201']//textarea[@placeholder='There is no description!']"));
		return element;
	}

	public static WebElement popupViewDetail_btnUpdate(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//div[@class='dt-actionDes4201 center-block text-center']//button[@class='btn m-btn--pill btn-info updateDes'][contains(text(),'Update')]"));
		return element;
	}

	// =====Objective Detail/ Key Result=====
	public static WebElement txtProgressKR(WebDriver driver, String krName) {
		element = driver.findElement(By.xpath("//a[contains(text(),'" + krName
				+ "')]/ancestor-or-self::div[@class='form-group m-form__group row parentComment m-auto']//input[@placeholder='Progress']"));
		return element;
	}

	public static WebElement txtWeightKR(WebDriver driver, String krName) {
		element = driver.findElement(By.xpath("//a[contains(text(),'" + krName
				+ "')]/ancestor-or-self::div[@class='form-group m-form__group row parentComment m-auto']//input[@class='form-control m-input keyResultWeightInput pdtl']"));
		return element;
	}

	public static WebElement lnkDescKR(WebDriver driver, String krName) {
		element = driver.findElement(By.xpath("//a[contains(text(),'" + krName
				+ "')]/ancestor-or-self::div[@class='form-group m-form__group row parentComment m-auto']//a[@class='pl-2 text-muted m-link'][contains(text(),'Description')]"));
		return element;
	}

	public static WebElement txtDescKR(WebDriver driver, String krName) {
		element = driver.findElement(By.xpath("//a[contains(text(),'" + krName
				+ "')]/ancestor-or-self::div[@class='form-group m-form__group row parentComment m-auto']//div[@id='ks-description4201']//textarea[@placeholder='There is no description!']"));
		return element;
	}
}