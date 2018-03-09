package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import configuration.BrowserType;
import configuration.Config;

public class CheckForgotPassword {

	WebDriver driver;
	
	@Test
	@Parameters("browser")
	public void invokeBrowser(@Optional("firefox") String browser) {

		try {

			driver = BrowserType.Execute(browser);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			checkForgotPass();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test(dependsOnMethods = {"invokeBrowser"})
	public void checkForgotPass() {

		try {
			driver.get(Config.url);
			driver.findElement(By.linkText("Forgot password?")).click();
			driver.findElement(By.id("email")).sendKeys(Config.email);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			String message = driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]")).getText();
			System.out.println("An email has been sent to the address you provided with instructions to reset your password. = " + message);
			Assert.assertEquals(message, "An email has been sent to the address you provided with instructions to reset your password.");
			driver.findElement(By.linkText("Contact support")).click();
			driver.navigate().back();
			Thread.sleep(10000);
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
