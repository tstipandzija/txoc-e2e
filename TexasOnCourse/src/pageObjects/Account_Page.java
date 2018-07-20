package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Account_Page {

	private static WebElement element = null;

	public static WebElement iframe(WebDriver driver) {

		element = driver
				.findElement(By.xpath("//iframe[@src='https://account.stage.texasoncourse.org/users/profile']"));

		return element;

	}

	public static WebElement personal(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='#personalContent']"));

		return element;

	}

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

	public static WebElement occupation(WebDriver driver) {

		element = driver.findElement(By.id("occupation"));

		return element;

	}

	public static WebElement updateButton(WebDriver driver) {

		element = driver.findElement(By.id("updateButton"));

		return element;

	}

	public static WebElement classCodes(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='/class-codes']"));

		return element;

	}

	public static WebElement contactSupport(WebDriver driver) {

		element = driver.findElement(By.linkText("Contact support"));

		return element;

	}

	public static WebElement school(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='#schoolContent']"));

		return element;

	}

	public static WebElement district(WebDriver driver) {

		element = driver.findElement(By.id("districtInput"));

		return element;

	}

	public static WebElement schoolInput(WebDriver driver) {

		element = driver.findElement(By.id("schoolInput"));

		return element;

	}

	public static WebElement supervisor(WebDriver driver) {

		element = driver.findElement(By.id("supervisor"));

		return element;

	}

	public static WebElement supervisorEmail(WebDriver driver) {

		element = driver.findElement(By.id("supervisorEmail"));

		return element;

	}

	public static WebElement social(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='#socialContent']"));

		return element;

	}

	public static WebElement twitter(WebDriver driver) {

		element = driver.findElement(By.id("twitter"));

		return element;

	}

	public static WebElement linkedIn(WebDriver driver) {

		element = driver.findElement(By.id("linkedIn"));

		return element;

	}

	public static WebElement accessPathbriteProfile(WebDriver driver) {

		element = driver.findElement(By.xpath(
				"//a[@href='https://texasoncourse-staging.difference-engine.com/lti/auto/url?client_id=dashboard&custom_url=/pathbrite/portfolio']"));

		return element;

	}

	public static WebElement notifications(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='#notificationsContent']"));

		return element;

	}

	public static WebElement newClassCode(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='/class-codes/create']"));

		return element;

	}

	public static WebElement issuedClassCode(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='/class-codes/show/111']"));

		return element;

	}

	public static WebElement classCodeList(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='/class-codes']"));

		return element;

	}

	public static WebElement profilePage(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='/users/profile']"));

		return element;

	}

}
