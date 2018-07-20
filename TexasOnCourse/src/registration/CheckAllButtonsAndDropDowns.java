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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import configuration.BrowserType;
import configuration.Config;
import pageObjects.Registration_Page;

public class CheckAllButtonsAndDropDowns {

	WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void invokeBrowser(@Optional("firefox") String browser) {

		try {

			driver = BrowserType.Execute(browser);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Config.wait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Config.pageLoad, TimeUnit.SECONDS);
			driver.get("https://account.stage.texasoncourse.org/users/register");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void checkAndSelect() {

		try {
			String titleofThePage = driver.getTitle();
			System.out.println("Title of the page is: " + titleofThePage);
			Assert.assertEquals(titleofThePage, "Texas OnCourse");
			Registration_Page.dropdown(driver).click();
			Select dropdown = new Select(Registration_Page.dropdown(driver));
			dropdown.selectByVisibleText("School");
			Thread.sleep(500);
			dropdown.selectByIndex(0);
			Thread.sleep(500);
			dropdown.selectByIndex(2);
			boolean status = Registration_Page.registerButton(driver).isEnabled();
			System.out.println("The button is enabled = " + status);
			Registration_Page.firstCheckbox(driver).click();
			Registration_Page.secondCheckbox(driver).click();
			Registration_Page.contactSupport(driver).click();
			driver.navigate().back();
			driver.navigate().forward();
			driver.navigate().back();
			Registration_Page.alreadyRegistered(driver).click();
			driver.navigate().back();
			driver.navigate().forward();
			driver.navigate().back();
			Registration_Page.partDiscLink(driver).click();
			Thread.sleep(500);
			WebElement closeButton = Registration_Page.partDiscCloseButton(driver);
			closeButton.click();
			Thread.sleep(500);
			Registration_Page.termsOfService(driver).click();
			Thread.sleep(1000);
		

			for (int i = driver.getWindowHandles().size() - 1; i > 0; i--) {

				String winHandle = driver.getWindowHandles().toArray()[i].toString();

				driver.switchTo().window(winHandle);
				
				driver.close();
			}

			Set<String> allWindowHandles = driver.getWindowHandles();

			for (String handle : allWindowHandles) {
				System.out.println("Switching to window - > " + handle);
				System.out.println("Navigating to Texas OnCourse Registration Page");
				driver.switchTo().window(handle);
				driver.get("https://account.stage.texasoncourse.org/users/register");
			}
			Registration_Page.contactSupport(driver).click();
			driver.navigate().back();

		} catch (Throwable t) {
		     throw new Error ("Test failed: " + this.getClass().getSimpleName() + ", reason: " + t.getMessage());
			
		}

		finally {

			driver.quit();
		}

	}

}
