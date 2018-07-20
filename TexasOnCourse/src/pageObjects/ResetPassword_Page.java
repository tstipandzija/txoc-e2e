package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPassword_Page {
	
	private static WebElement element = null;
	
	public static WebElement email(WebDriver driver) {

		element = driver.findElement(By.id("email"));

		return element;

	}
	
	public static WebElement resetButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@type='submit']"));

		return element;

	}
	
	public static WebElement contactSupport(WebDriver driver) {

		element = driver.findElement(By.linkText("Contact support"));

		return element;

	}

}
