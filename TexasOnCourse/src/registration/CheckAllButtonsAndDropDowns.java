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
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import configuration.BrowserType;


public class CheckAllButtonsAndDropDowns {

	WebDriver driver; 
	
	
	@Test
	@Parameters("browser")
	public void invokeBrowser(@Optional("firefox") String browser) {

		try {
			
			driver = BrowserType.Execute(browser);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			getTheUrl();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test(dependsOnMethods = {"invokeBrowser"})
	public void getTheUrl() {

		try {
			driver.get("https://account.stage.texasoncourse.org/users/register");
			String titleofThePage = driver.getTitle();
			System.out.println("Title of the page is: " + titleofThePage);
			Assert.assertEquals(titleofThePage, "Texas OnCourse");
			checkAndSelect();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test(dependsOnMethods = {"getTheUrl"})
	public void checkAndSelect() {

		try {
			driver.findElement(By.id("conversionSourceDropdown"));
			Select dropdown = new Select(driver.findElement(By.id("conversionSourceDropdown")));
			dropdown.selectByVisibleText("School");
			Thread.sleep(500);
			Select dropDown = new Select(driver.findElement(By.id("conversionSourceDropdown")));
			dropDown.selectByIndex(0);
			Thread.sleep(1000);
			Select dropDoWn = new Select(driver.findElement(By.id("conversionSourceDropdown")));
			dropDoWn.selectByIndex(2);
			boolean status = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
			System.out.println(status);
			driver.findElement(By.xpath("//span[@class='check']")).click(); 
			driver.findElement(By.xpath("//*[@id='participationDisclosure']"))
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
				

				driver.findElement(By.xpath("//a[@class='button']")).click();
				Thread.sleep(1000);
				driver.navigate().back();
				driver.findElement(By.xpath("//a[@id='scroll-anchor-fixed']")).click();
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
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
