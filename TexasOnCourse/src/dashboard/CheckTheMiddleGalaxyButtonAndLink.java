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


public class CheckTheMiddleGalaxyButtonAndLink {

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
	public void loginAndClickButtonAndLink() {

		try {
			Login_Page.email(driver).sendKeys(Config.secondEmail);
			Login_Page.password(driver).sendKeys(Config.password);
			Login_Page.loginButton(driver).click();
			Thread.sleep(1000);
			String middleGalaxyTitle = Dashboard_Page.middleGalaxyButton(driver).getText();
			System.out.println("Go To MiddleGalaxy Dashboard = " + middleGalaxyTitle);
			Assert.assertEquals(middleGalaxyTitle, "Go To MiddleGalaxy Dashboard");
			Dashboard_Page.middleGalaxyButton(driver).click();
			Thread.sleep(10000);
			driver.navigate().back();
			Thread.sleep(3000);
			Dashboard_Page.middleGalaxyLink(driver).click();	
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

}
