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


public class IncorrectEmailCorrectPass {

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

	@Test
	public void typeInTheWrongCredentials2() {

		try {
			Login_Page.email(driver).sendKeys("tstipandzija.ee+25@gmail.com");
			Login_Page.password(driver).sendKeys(Config.password);
			Login_Page.loginButton(driver).click();
			String message = Login_Page.alertMessage(driver).getText();
			System.out.println("Sorry, we don't recognize that email/password. = " + message);
			Assert.assertEquals(message, "Sorry, we don't recognize that email/password.");

		} catch (Throwable t) {
		     throw new Error ("Test failed: " + this.getClass().getSimpleName() + ", reason: " + t.getMessage());
		     
		} finally {

			driver.quit();
		}

	}

}
