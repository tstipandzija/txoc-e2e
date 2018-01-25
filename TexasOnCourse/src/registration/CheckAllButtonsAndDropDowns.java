package registration;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.Select;

public class CheckAllButtonsAndDropDowns {

	WebDriver driver; 

	public void invokeBrowser() {

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
			getTheUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getTheUrl() {

		try {
			driver.get("https://account.stage.texasoncourse.org/users/register");
			String titleofThePage = driver.getTitle();
			System.out.println("Title of the page is: " + titleofThePage);
			checkAndSelect();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void checkAndSelect() {

		try {
			driver.findElement(By.id("escRegion"));
			Select region = new Select(driver.findElement(By.id("escRegion")));
			region.selectByIndex(5);
			driver.findElement(By.id("conversionSourceDropdown"));
			Select dropdown = new Select(driver.findElement(By.id("conversionSourceDropdown")));
			dropdown.selectByVisibleText("School");
			Thread.sleep(500);
			Select dropDown = new Select(driver.findElement(By.id("conversionSourceDropdown")));
			dropDown.selectByIndex(0);
			Thread.sleep(1000);
			Select dropDoWn = new Select(driver.findElement(By.id("conversionSourceDropdown")));
			dropDoWn.selectByIndex(2);
			boolean status = driver
					.findElement(By.xpath("html/body/div[1]/div/div[1]/div[2]/form/fieldset/div[14]/button"))
					.isEnabled();
			System.out.println(status);
			driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[2]/form/fieldset/div[11]/label/span/span"))
					.click();
			driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[2]/form/fieldset/div[12]/label/span/span"))
					.click();
			driver.findElement(By.partialLinkText("Contact")).click();
			driver.navigate().back();
			driver.navigate().forward();
			driver.navigate().back();
			driver.findElement(By.linkText("Already Registered?")).click();
			driver.navigate().back();
			driver.navigate().forward();
			driver.navigate().back();
			driver.findElement(By.linkText("Participation Disclosure Terms")).click();
			Thread.sleep(500);
			driver.findElement(By.cssSelector("button.close")).click();
			Thread.sleep(500);
			driver.findElement(By.linkText("Texas OnCourse Terms of Service")).click();
			Thread.sleep(3000);

			for (int i = driver.getWindowHandles().size() - 1; i > 0; i--) {

				String winHandle = driver.getWindowHandles().toArray()[i].toString();

				driver.switchTo().window(winHandle);
	
				driver.findElement(By.xpath("html/body/footer/div[1]/div/div/div[1]/a")).click();
				Thread.sleep(1000);
				driver.navigate().back();
				driver.findElement(By.xpath("html/body/footer/div[1]/div/div/div[3]/p/a/span[1]")).click();
				Thread.sleep(1000);
				driver.navigate().back();
				driver.close();
			}

			Set<String> allWindowHandles = driver.getWindowHandles();

			for (String handle : allWindowHandles) {
				System.out.println("Switching to window - > " + handle);
				System.out.println("Navigating to Texas OnCourse Registration Page");
				driver.switchTo().window(handle); 
				driver.get("https://account.stage.texasoncourse.org/users/register");
			}
			driver.findElement(By.partialLinkText("Contact")).click();
			driver.navigate().back();
			Thread.sleep(1000);
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		CheckAllButtonsAndDropDowns myObj = new CheckAllButtonsAndDropDowns();
		myObj.invokeBrowser();
		
	}

}
