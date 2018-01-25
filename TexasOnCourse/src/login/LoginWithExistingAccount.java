package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LoginWithExistingAccount {

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

	public void typeInTheRightCredentials() {

		try {
			invokeBrowser("https://account.stage.texasoncourse.org/interaction/13a24ef4-7ca8-4d3a-aaf8-2600772bbf9d/");
			driver.findElement(By.id("email")).sendKeys("dsdsds");
			driver.findElement(By.id("password")).sendKeys("dsdsds");
			driver.findElement(By.xpath("html/body/div/div/div/div[1]/form/fieldset/div[3]/button")).click();
			driver.findElement(By.xpath(".//*[@id='app']/div[3]/div[2]/div/div/div/div/p")).click();
			driver.findElement(By.xpath(".//*[@id='app']/div[2]/ul/li[4]/a/div")).click();
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
