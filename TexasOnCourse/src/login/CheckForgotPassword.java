package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CheckForgotPassword {

	WebDriver driver;

	public void invokeBrowser(String url) {

		try {

			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "/Users/tomislavstipandzija/Downloads/chromedriver"); driver = new
			 * ChromeDriver();
			 */

			System.setProperty("webdriver.gecko.driver", "/Users/tomislavstipandzija/Downloads/geckodriver");
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myprofile = profile.getProfile("default");
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setCapability(FirefoxDriver.PROFILE, myprofile);
			dc.setCapability("marionette", true);
			driver = new FirefoxDriver();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get(url);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void checkForgotPass() {

		try {
			invokeBrowser("https://account.stage.texasoncourse.org/interaction/13a24ef4-7ca8-4d3a-aaf8-2600772bbf9d/");
			driver.findElement(By.linkText("Forgot password?")).click();
			driver.findElement(By.id("email")).sendKeys("dsdsds");
			driver.findElement(By.xpath("html/body/div/div/div/div/form/fieldset/div[2]/button")).click();
			String message = driver.findElement(By.xpath("html/body/div/div/div/div/div[1]")).getText();
			System.out.println("An email has been sent to the address you provided with instructions to reset your password. = " + message);
			driver.findElement(By.linkText("Contact support")).click();
			driver.navigate().back();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
