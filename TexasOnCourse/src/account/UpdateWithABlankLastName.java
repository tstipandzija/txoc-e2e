package account;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateWithABlankLastName {

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



	public void leaveEmptyLastNameAndUpdate() {

		try {
			invokeBrowser("https://account.stage.texasoncourse.org/interaction/1ac8be08-0660-4cdf-8998-0e10aedd20a3");
			driver.findElement(By.id("email")).sendKeys("dsdsds");
			driver.findElement(By.id("password")).sendKeys("dsdsds");
			driver.findElement(By.xpath("html/body/div/div/div/div[1]/form/fieldset/div[3]/button")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='app']/div[3]/div[2]/div/div/div/div/p")).click();
			driver.findElement(By.xpath(".//*[@id='app']/div[2]/ul/li[2]/a/div")).click();

			driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div/div[3]/iframe")));
			Thread.sleep(2000);

			driver.findElement(By.id("lastName")).clear();
			Thread.sleep(1000);

			String update = driver.findElement(By.xpath(".//*[@id='updateButton']")).getText();
			System.out.println("Update = " + update);
			WebElement el = driver.findElement(By.xpath(".//*[@id='updateButton']"));
			JavascriptExecutor jsExec = (JavascriptExecutor) driver;
			jsExec.executeScript("arguments[0].click()", el);
			Thread.sleep(4000);

			driver.switchTo().defaultContent();
			driver.findElement(By.xpath(".//*[@id='app']/div[2]/div[2]/div/div/div/div/p")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div[1]/ul/li[4]/a/div")).click();
			Thread.sleep(5000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}