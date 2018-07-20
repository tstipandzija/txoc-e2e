package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {

	private static WebElement element = null;

	public static WebElement email(WebDriver driver) {

		element = driver.findElement(By.id("email"));

		return element;

	}

	public static WebElement password(WebDriver driver) {

		element = driver.findElement(By.id("password"));

		return element;

	}

	public static WebElement loginButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@type='submit']"));

		return element;

	}

	public static WebElement alreadyRegistered(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='/users/register']"));

		return element;

	}

	public static WebElement forgotPassword(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='/passwords/reset']"));

		return element;

	}

	public static WebElement contactSupport(WebDriver driver) {

		element = driver.findElement(By.linkText("Contact support"));

		return element;

	}
	
	public static WebElement alertMessage(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[@class='alert alert-dismissible alert-danger']"));

		return element;

	}
	
	
	public static WebElement infoMessage(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[@class='alert alert-dismissible alert-info']"));

		return element;

	}
	
	
	
	
	
}

	

