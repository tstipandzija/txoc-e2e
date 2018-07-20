package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration_Page {
	
	private static WebElement element = null;
	
	public static WebElement firstName(WebDriver driver) {

		element = driver.findElement(By.id("firstName"));

		return element;

	}

	public static WebElement lastName(WebDriver driver) {

		element = driver.findElement(By.id("lastName"));

		return element;

	}

	public static WebElement email(WebDriver driver) {

		element = driver.findElement(By.id("email"));

		return element;

	}

	public static WebElement password(WebDriver driver) {

		element = driver.findElement(By.id("password"));

		return element;

	}

	public static WebElement repeatPassword(WebDriver driver) {

		element = driver.findElement(By.id("passwordRepeat"));

		return element;

	}

	public static WebElement district(WebDriver driver) {

		element = driver.findElement(By.id("districtInput"));

		return element;

	}
	
	public static WebElement school(WebDriver driver) {

		element = driver.findElement(By.id("schoolInput"));

		return element;

	}
	
	public static WebElement dropdown(WebDriver driver) {

		element = driver.findElement(By.id("conversionSourceDropdown"));

		return element;

	}
	
	public static WebElement firstCheckbox(WebDriver driver) {

		element = driver.findElement(By.xpath("//span[@class='check']"));

		return element;

	}
	
	public static WebElement secondCheckbox(WebDriver driver) {

		element = driver.findElement(By.id("participationDisclosure"));

		return element;

	}
	
	public static WebElement termsOfService(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='https://texasoncourse.org/terms-of-service']"));

		return element;

	}
	
	public static WebElement partDiscLink(WebDriver driver) {

		element = driver.findElement(By.linkText("Participation Disclosure Terms"));

		return element;

	}
	
	public static WebElement partDiscCloseButton(WebDriver driver) {

		element = driver.findElement(By.cssSelector("button.close"));

		return element;

	}
	
	
	public static WebElement registerButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@type='submit']"));

		return element;

	}
	
	public static WebElement contactSupport(WebDriver driver) {

		element = driver.findElement(By.linkText("Contact support"));

		return element;

	}
	
	public static WebElement alreadyRegistered(WebDriver driver) {

		element = driver.findElement(By.linkText("Already Registered?"));

		return element;

	}
	

	
}	


	
	
	
	
	
	
	
	
	
	

