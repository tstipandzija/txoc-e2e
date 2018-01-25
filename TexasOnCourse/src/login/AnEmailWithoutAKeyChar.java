package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AnEmailWithoutAKeyChar {

	WebDriver driver;

	public void invokeBrowser(String url) {

		try {

			System.setProperty("webdriver.chrome.driver", "/Users/tomislavstipandzija/Downloads/chromedriver");
			driver = new ChromeDriver();

			/*
			 * System.setProperty("webdriver.gecko.driver",
			 * "/Users/tomislavstipandzija/Downloads/geckodriver"); ProfilesIni profile =
			 * new ProfilesIni(); FirefoxProfile myprofile = profile.getProfile("default");
			 * DesiredCapabilities dc = DesiredCapabilities.firefox();
			 * dc.setCapability(FirefoxDriver.PROFILE, myprofile);
			 * dc.setCapability("marionette", true); driver = new FirefoxDriver();
			 */

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void typeInAnEmailWithoutAKeyChar() {

		try {
			invokeBrowser("https://account.stage.texasoncourse.org/interaction/13a24ef4-7ca8-4d3a-aaf8-2600772bbf9d/");
			driver.findElement(By.id("email")).sendKeys("dsdsds"); // without @
			driver.findElement(By.id("password")).sendKeys("edede");
			driver.findElement(By.xpath("html/body/div/div/div/div[1]/form/fieldset/div[3]/button")).click();
			Thread.sleep(3000);
			typeInAnEmailWithoutSecKeyChar();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void typeInAnEmailWithoutSecKeyChar() {

		try {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys("dsdsds"); // with At
			driver.findElement(By.id("password")).sendKeys("dsdsds");
			driver.findElement(By.xpath("html/body/div/div/div/div[1]/form/fieldset/div[3]/button")).click();
			Thread.sleep(3000);
			typeInAnEmailWithoutThirdKeyChar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void typeInAnEmailWithoutThirdKeyChar() {

		try {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys("dsdsds"); // without dot
			driver.findElement(By.id("password")).sendKeys("dsdsds");
			driver.findElement(By.xpath("html/body/div/div/div/div[1]/form/fieldset/div[3]/button")).click();
			String message = driver.findElement(By.xpath("html/body/div/div/div/div[2]")).getText();
			System.out.println("Sorry, we don't recognize that email/password. = " + message);
			driver.navigate().refresh();
			Thread.sleep(3000);
			typeInAnIncompleteEmail();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void typeInAnIncompleteEmail() {

		try {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys("dsdsds"); // without .com
			driver.findElement(By.id("password")).sendKeys("dsdsds");
			driver.findElement(By.xpath("html/body/div/div/div/div[1]/form/fieldset/div[3]/button")).click();
			String message = driver.findElement(By.xpath("html/body/div/div/div/div[2]")).getText();
			System.out.println("Sorry, we don't recognize that email/password. = " + message);
			driver.navigate().refresh();
			Thread.sleep(3000);
			typeInAnIncompleteEmailAgain();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void typeInAnIncompleteEmailAgain() {

		try {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys("dsdsds"); // without first part
			driver.findElement(By.id("password")).sendKeys("dsdsds");
			driver.findElement(By.xpath("html/body/div/div/div/div[1]/form/fieldset/div[3]/button")).click();
			Thread.sleep(3000);
			typeInAnIncompleteEmailAgain2();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void typeInAnIncompleteEmailAgain2() {

		try {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys("dsdsds"); // just with @gmail
			driver.findElement(By.id("password")).sendKeys("dsdsds");
			driver.findElement(By.xpath("html/body/div/div/div/div[1]/form/fieldset/div[3]/button")).click();
			Thread.sleep(3000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
