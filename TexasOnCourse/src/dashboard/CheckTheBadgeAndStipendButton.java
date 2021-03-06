package dashboard;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import configuration.GoToTab;
import configuration.SignOut_Action;
import pageObjects.Dashboard_Page;
import pageObjects.Login_Page;


public class CheckTheBadgeAndStipendButton {

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
	public void loginAndClickTheBadgeButton() {

		try {
			String titleOfThePage = driver.getTitle();
			System.out.println("Title of the page is: " + titleOfThePage);
			Assert.assertEquals(titleOfThePage, "Texas OnCourse Academy");
			Login_Page.email(driver).sendKeys(Config.secondEmail);
			Login_Page.password(driver).sendKeys(Config.password);
			Login_Page.loginButton(driver).click();
			Thread.sleep(1000);
			
			Dashboard_Page.userBadge(driver).click();
			Thread.sleep(2000);			
			driver.navigate().back();
			Thread.sleep(1000);
			
			String stipendButton = Dashboard_Page.stipendButton(driver).getText();
			System.out.println("If you've qualified for a stipend, click here to claim it. = " + stipendButton);
			Assert.assertEquals(stipendButton, "If you've qualified for a stipend, click here to claim it.");
			Dashboard_Page.stipendButton(driver).click();
			
			Thread.sleep(1000);
			GoToTab.Execute(driver);
			SignOut_Action.Execute(driver);
	
		} catch (Throwable t) {
		     throw new Error ("Test failed: " + this.getClass().getSimpleName() + ", reason: " + t.getMessage());
		}
		  finally {

			driver.quit();
		}
	}

	//public static void main(String[] args) {

		/*CheckTheBadgeAndStipendButton obj = new CheckTheBadgeAndStipendButton();
		obj.invokeBrowser();
		CheckHelpVideosLink obj1 = new CheckHelpVideosLink();
		obj1.loginAndClickOnHelpVideos();
		CheckMiddleGalaxyButtonAndLink obj2 = new CheckMiddleGalaxyButtonAndLink();
		obj2.loginAndClickButtonAndLink();
		CheckTheGlossaryLink obj3 = new CheckTheGlossaryLink();
		obj3.loginAndClickTheGlossaryLink();
		CheckTheBannerLink obj4 = new CheckTheBannerLink();
		obj4.CheckTheBannerLink();*/

	}


