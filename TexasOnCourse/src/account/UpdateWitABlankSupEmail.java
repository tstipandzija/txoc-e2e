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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import configuration.BrowserType;
import configuration.Config;
import configuration.GoToAccount;
import configuration.JSExec;
import configuration.Login_Action;
import configuration.SignOut_Action;
import configuration.Wait;
import pageObjects.Account_Page;


public class UpdateWitABlankSupEmail {

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
	public void leaveABlankEmail() {

		try {
			Login_Action.Execute(driver);
			Thread.sleep(1000);
			GoToAccount.Execute(driver);

			driver.switchTo().frame(Account_Page.iframe(driver));
			
			WebElement el = Account_Page.school(driver);
			JavascriptExecutor jsExec = (JavascriptExecutor) driver;
			jsExec.executeScript("arguments[0].click()", el);
			//JSExec.clickElement(Account_Page.school(driver), driver);
			
			
			//Thread.sleep(2000);
			
			//ovako prolazi test, kad je izvan genericke klase
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(Account_Page.supervisorEmail(driver))); 
				
			//ovako ne prolazi test, mozda je problem u generickoj klasi?
			//Wait.waitForElement(Account_Page.supervisorEmail(driver), driver);
			
			Account_Page.supervisorEmail(driver).clear();
			WebElement el1 = Account_Page.updateButton(driver);
			JavascriptExecutor jsExec1 = (JavascriptExecutor) driver;
			jsExec1.executeScript("arguments[0].click()", el1);
			//JSExec.clickElement(Account_Page.updateButton(driver), driver);

						
			driver.switchTo().defaultContent();
			SignOut_Action.Execute(driver);
			
		} catch (Throwable t) {
		     throw new Error ("Test failed: " + this.getClass().getSimpleName() + ", reason: " + t.getMessage());
		}
		  finally {

			driver.quit();
		}

	}

}
