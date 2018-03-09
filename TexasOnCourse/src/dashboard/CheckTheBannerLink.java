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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import configuration.BrowserType;
import configuration.Config;

public class CheckTheBannerLink {
	
	WebDriver driver; 
	
	@Test
	@Parameters("browser")
	public void invokeBrowser(@Optional("firefox") String browser) {

		try {

			driver = BrowserType.Execute(browser);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			loginAndClickTheBannerLink();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void loginAndClickTheBannerLink() {
		
		try {
			driver.get(Config.url);
			driver.findElement(By.id("email")).sendKeys("tstipandzija@extensionengine.com");
			driver.findElement(By.id("password")).sendKeys(Config.password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div[2]/p/a")).click();
			Thread.sleep(5000);
			
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
			Thread.sleep(2000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
	}
	

}
