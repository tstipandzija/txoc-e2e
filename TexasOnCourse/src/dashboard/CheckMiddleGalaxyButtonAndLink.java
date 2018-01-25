package dashboard;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CheckMiddleGalaxyButtonAndLink {

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

	public void loginAndClickButtonAndLink() {

		try {
			invokeBrowser("https://account.stage.texasoncourse.org/interaction/3dddbdb8-0fbb-4390-aa7c-188e49d73a3b");
			String titleOfThePage = driver.getTitle();
			System.out.print("Title of the page is: " + titleOfThePage);
			driver.findElement(By.id("email")).sendKeys("dsdsds");
			driver.findElement(By.id("password")).sendKeys("dsdsds");
			driver.findElement(By.xpath("html/body/div/div/div/div[1]/form/fieldset/div[3]/button")).click();
			Thread.sleep(3000);
			String middleGalaxyTitle = driver
					.findElement(By.xpath(".//*[@id='user-dashboard']/div[2]/div[2]/div[3]/div[2]/div/a")).getText();
			System.out.println("Go To MiddleGalaxy Dashboard = " + middleGalaxyTitle);
			driver.findElement(By.xpath(".//*[@id='user-dashboard']/div[2]/div[2]/div[3]/div[2]/div/a")).click();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='user-dashboard']/div[2]/div[2]/div[3]/div[2]/p[2]/a")).click();
			
			Thread.sleep(3000);
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}
			driver.navigate().refresh();
			driver.close();
			
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}

			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div/p")).click();
			driver.findElement(By.xpath(".//*[@id='app']/div[2]/ul/li[5]/a/div")).click();
			Thread.sleep(2000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}