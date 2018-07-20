package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import configuration.BrowserType;
import configuration.Config;
import pageObjects.Login_Page;

public class AnEmailWithoutAKeyChar {

	WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void invokeBrowser(@Optional("firefox") String browser) {

		try {

			driver = BrowserType.Execute(browser);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Config.wait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Config.pageLoad, TimeUnit.SECONDS);
			driver.get(Config.url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 1)
	public void typeInAnEmailWithoutAKeyChar() {

		try {
			Login_Page.email(driver).sendKeys("tstipandzija.ee+9gmail.com"); // without @
			Login_Page.password(driver).sendKeys(Config.password);
			Login_Page.loginButton(driver).click();
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 2)
	public void typeInAnEmailWithoutSecKeyChar() {

		try {
			Login_Page.email(driver).clear();
			Login_Page.email(driver).sendKeys("tstipandzija.ee+9Atgmail.com"); // with At
			Login_Page.password(driver).sendKeys(Config.password);
			Login_Page.loginButton(driver).click();
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 3)
	public void typeInAnEmailWithoutThirdKeyChar() {

		try {
			Login_Page.email(driver).clear();
			Login_Page.email(driver).sendKeys("tstipandzija.ee+9@gmailcom"); // without dot
			Login_Page.password(driver).sendKeys(Config.password);
			Login_Page.loginButton(driver).click();
			String message = Login_Page.alertMessage(driver).getText();
			System.out.println("Sorry, we don't recognize that email/password. = " + message);
			Assert.assertEquals(message, "Sorry, we don't recognize that email/password.");
			driver.navigate().refresh();
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 4)
	public void typeInAnIncompleteEmail() {

		try {
			Login_Page.email(driver).clear();
			Login_Page.email(driver).sendKeys("tstipandzija.ee+9@gmail"); // without .com
			Login_Page.password(driver).sendKeys(Config.password);
			Login_Page.loginButton(driver).click();
			String message = Login_Page.alertMessage(driver).getText();
			System.out.println("Sorry, we don't recognize that email/password. = " + message);
			Assert.assertEquals(message, "Sorry, we don't recognize that email/password.");
			driver.navigate().refresh();
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 5)
	public void typeInAnIncompleteEmailAgain() {

		try {
			Login_Page.email(driver).clear();
			Login_Page.email(driver).sendKeys("@gmail.com"); // without first part
			Login_Page.password(driver).sendKeys(Config.password);
			Login_Page.loginButton(driver).click();
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 6)
	public void typeInAnIncompleteEmailAgain2() {

		try {
			Login_Page.email(driver).clear();
			Login_Page.email(driver).sendKeys("@gmail"); // just with @gmail
			Login_Page.password(driver).sendKeys(Config.password);
			Login_Page.loginButton(driver).click();
			Thread.sleep(1000);

		} catch (Throwable t) {
		     throw new Error ("Test failed: " + this.getClass().getSimpleName() + ", reason: " + t.getMessage());
		     
		} finally {

			driver.quit();
		}

	}

}
