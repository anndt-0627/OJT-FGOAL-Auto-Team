package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObj_ObjectDetail_Comment {
	
	private static WebElement element = null;
	
	public static WebElement menuDashboard(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
		return element;
	}
	
	public static WebElement ObjectiveName(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[@class='col-form-label mt-n1 float-left label-obj']"));
		return element;
	}
	
	public static WebElement ObjectiveIconShowComment(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class='showComment btn btn-outline-accent btn-sm m-btn m-btn--icon m-btn--pill m-0']"));
		return element;
	}
	
	public static WebElement ObjectiveTextboxInputComment(WebDriver driver) {
		element = driver.findElement(By.xpath("//li[@class='d-flex align-items-center comment-post']"));
		return element;
	}
	
	public static WebElement ObjectiveContentComment(WebDriver driver, String ValidComment) {
		element = driver.findElement(By.xpath("//a[@contains(text(),,'" + ValidComment + "')]"));
		return element;
	}

	public static WebElement ObjectiveNumberComment(WebDriver driver) {
		element = driver.findElement(By.xpath("//[@class='num-comment']"));
		return element;
	}
	
	public static WebElement ObjectiveIconEditComment(WebDriver driver, String ValidComment) {
		element = driver.findElement(By.xpath("//li[@class='comment-item']//i[@class='far fa-edit'][contains(text(),,'" + ValidComment + "')]"));
		return element;
	}
	public static WebElement ObjectiveIconDeleteComment(WebDriver driver, String ValidComment) {
		element = driver.findElement(By.xpath("//li[@class='comment-item']//i[@class='far fa-trash-alt'][contains(text(),,'" + ValidComment + "')]"));
		return element;
			
	}
}