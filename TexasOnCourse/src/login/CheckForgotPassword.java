package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import pageObjects.ResetPassword_Page;

public class CheckForgotPassword {

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
	public void checkForgotPass() {

		try {
			Login_Page.forgotPassword(driver).click();
			Login_Page.email(driver).sendKeys(Config.email);
			ResetPassword_Page.resetButton(driver).click();
			String message = Login_Page.infoMessage(driver).getText();
			System.out.println(
					"An email has been sent to the address you provided with instructions to reset your password. = "
							+ message);
			Assert.assertEquals(message,
					"An email has been sent to the address you provided with instructions to reset your password.");
			Login_Page.contactSupport(driver).click();
			driver.navigate().back();

		} catch (Throwable t) {
		     throw new Error ("Test failed: " + this.getClass().getSimpleName() + ", reason: " + t.getMessage());
		     
		} finally {

			driver.quit();
		}
	}

}
