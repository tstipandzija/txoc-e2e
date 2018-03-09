package login;


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

public class CorrectEmailIncorrectPass {
	
	WebDriver driver;

	@Test
	@Parameters("browser")
	public void invokeBrowser(@Optional("firefox") String browser) {

		try {
		
			driver = BrowserType.Execute(browser);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			typeInTheWrongCredentials1 ();				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void typeInTheWrongCredentials1 () {
		
		try {
			driver.get(Config.url);
			driver.findElement(By.id("email")).sendKeys(Config.email);
			driver.findElement(By.id("password")).sendKeys("!#$%$%&'('()=??**ĐŽĆŠČ");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			String message = driver.findElement(By.xpath("html/body/div/div/div/div[2]")).getText();
			System.out.println("Sorry, we don't recognize that email/password. = " + message);
			Assert.assertEquals(message, "Sorry, we don't recognize that email/password.");
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	

}
	
