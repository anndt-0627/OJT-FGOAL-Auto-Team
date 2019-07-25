package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_ObjDetail_KR_QuickActionPopup {
	private static WebElement element = null;

	public static WebElement icoQuickActKR(WebDriver driver, String krName) {
		element = driver.findElement(By.xpath("//a[contains(text(),'" + krName
				+ "')]/ancestor-or-self::div[@class='form-group m-form__group row parentComment m-auto']//a[@class='m-portlet__nav-link m-dropdown__toggle btn btn-secondary m-btn m-btn--icon m-btn--pill m-0']"));
		return element;
	}

	// =====Quick Actions popup=====

	public static WebElement popupQuickAct_title(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//div[@class='m-dropdown__wrapper dropup-personal']//span[@class='m-nav__section-text'][contains(text(),'Quick Actions')]"));
		return element;
	}

	public static WebElement popupQuickAct_itmViewDetail(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'View Detail')]"));
		return element;
	}

	public static WebElement popupQuickAct_itmUpdateKRtitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Update Key result title')]"));
		return element;
	}

	public static WebElement popupQuickAct_itmUpdateWeight(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//a[@class='m-nav__link bt-changeWeightKeyResult']//span[@class='m-nav__link-text'][contains(text(),'Update weight')]"));
		return element;
	}

	public static WebElement popupQuickAct_itmUpdateTarget(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Update target')]"));
		return element;
	}

	public static WebElement popupQuickAct_itmDelete(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//a[@class='m-nav__link bt-deleteKeyResult']//span[@class='m-nav__link-text'][contains(text(),'Delete')]"));
		return element;
	}

	// =====Quick Actions item popup=====

	public static WebElement popupViewDetail_title(WebDriver driver, String krName) {
		element = driver.findElement(By.xpath("//h4[contains(text(),'" + krName + "')]"));
		return element;
	}

	public static WebElement popupViewDetail_btnClose(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//div[@class='modal-dialog modal-lg']//button[@class='btn btn-dark pull-left'][contains(text(),'Close')]"));
		return element;
	}

	public static WebElement popupUpdateKR_title(WebDriver driver) {
		element = driver.findElement(By.xpath("//h4[contains(text(),'Update Key result title')]"));
		return element;
	}

	public static WebElement popupUpdateKR_btnClose(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//form[@id='updateNameKeyResult']//button[@class='btn btn-dark'][contains(text(),'Close')]"));
		return element;
	}

	public static WebElement popupUpdateWeight_title(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//div[@id='changeWeight']//h4[@class='modal-title'][contains(text(),'Update weight')]"));
		return element;
	}

	public static WebElement popupUpdateWeight_btnClose(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//form[@id='updateWeightKeyResult']//button[@class='btn btn-dark'][contains(text(),'Close')]"));
		return element;
	}

	public static WebElement popupUpdateTarget_title(WebDriver driver) {
		element = driver.findElement(By.xpath("//h4[contains(text(),'Update target')]"));
		return element;
	}

	public static WebElement popupUpdateTarget_btnClose(WebDriver driver) {
		element = driver.findElement(By
				.xpath("//form[@id='updateTargetKeyResult']//button[@class='btn btn-dark'][contains(text(),'Close')]"));
		return element;
	}

	public static WebElement popupDelete_title(WebDriver driver) {
		element = driver.findElement(By.xpath("//h4[contains(text(),'Delete key result')]"));
		return element;
	}

	public static WebElement popupDelete_btnClose(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//form[@id='deleteKeyResult']//button[@class='btn btn-dark'][contains(text(),'Close')]"));
		return element;
	}
}
