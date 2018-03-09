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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import configuration.BrowserType;
import configuration.Config;


public class CheckTheBadgeAndStipendButton {

	WebDriver driver; 
	
	@Test
	@Parameters("browser")
	public void invokeBrowser(@Optional("firefox") String browser) {

		try {

			driver = BrowserType.Execute(browser);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			loginAndClickTheBadgeButton();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void loginAndClickTheBadgeButton() {

		try {
			driver.get(Config.url);
			String titleOfThePage = driver.getTitle();
			System.out.print("Title of the page is: " + titleOfThePage);
			Assert.assertEquals(titleOfThePage, "Texas OnCourse Academy");
			driver.findElement(By.id("email")).sendKeys("tstipandzija@extensionengine.com");
			driver.findElement(By.id("password")).sendKeys(Config.password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@alt='User Badge']")).click();
			Thread.sleep(4000);			
			driver.navigate().back();
			Thread.sleep(5000);
			
			String stipendButton = driver.findElement(By.xpath(".//*[@id='user-dashboard']/div[2]/div[2]/div[2]/div[2]/a/div")).getText();
			System.out.println("If you've qualified for a stipend, click here to claim it. = " + stipendButton);
			Assert.assertEquals(stipendButton, "If you've qualified for a stipend, click here to claim it.");
			driver.findElement(By.xpath(".//*[@id='user-dashboard']/div[2]/div[2]/div[2]/div[2]/a/div")).click();
			
			Thread.sleep(6000);
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}
			driver.navigate().refresh();
			driver.close();
			
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}

			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//span[@class='angle-down']")).click();
			driver.findElement(By.xpath("//a[@href='/oidc/logout']")).click();
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
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


