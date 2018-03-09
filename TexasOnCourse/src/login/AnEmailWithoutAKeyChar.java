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

public class AnEmailWithoutAKeyChar {

	WebDriver driver;
	
	@Test
	@Parameters("browser")
	public void invokeBrowser(@Optional("firefox") String browser) {

		try {
			
			driver = BrowserType.Execute(browser);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			typeInAnEmailWithoutAKeyChar();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test(dependsOnMethods = {"invokeBrowser"})
	public void typeInAnEmailWithoutAKeyChar() {

		try {
			driver.get(Config.url);
			driver.findElement(By.id("email")).sendKeys("tstipandzija.ee+9gmail.com"); // without @
			driver.findElement(By.id("password")).sendKeys(Config.password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
			typeInAnEmailWithoutSecKeyChar();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test(dependsOnMethods = {"typeInAnEmailWithoutAKeyChar"})
	public void typeInAnEmailWithoutSecKeyChar() {

		try {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys("tstipandzija.ee+9Atgmail.com"); // with At 
			driver.findElement(By.id("password")).sendKeys(Config.password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
			typeInAnEmailWithoutThirdKeyChar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	@Test(dependsOnMethods = {"typeInAnEmailWithoutSecKeyChar"})
	public void typeInAnEmailWithoutThirdKeyChar() {

		try {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys("tstipandzija.ee+9@gmailcom"); // without dot
			driver.findElement(By.id("password")).sendKeys(Config.password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			String message = driver.findElement(By.xpath("html/body/div/div/div/div[2]")).getText();
			System.out.println("Sorry, we don't recognize that email/password. = " + message);
			Assert.assertEquals(message, "Sorry, we don't recognize that email/password.");
			driver.navigate().refresh();
			Thread.sleep(3000);
			typeInAnIncompleteEmail();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	@Test(dependsOnMethods = {"typeInAnEmailWithoutThirdKeyChar"})
	public void typeInAnIncompleteEmail() {

		try {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys("tstipandzija.ee+9@gmail"); // without .com
			driver.findElement(By.id("password")).sendKeys(Config.password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			String message = driver.findElement(By.xpath("html/body/div/div/div/div[2]")).getText();
			System.out.println("Sorry, we don't recognize that email/password. = " + message);
			Assert.assertEquals(message, "Sorry, we don't recognize that email/password.");
			driver.navigate().refresh();
			Thread.sleep(3000);
			typeInAnIncompleteEmailAgain();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	@Test(dependsOnMethods = {"typeInAnIncompleteEmail"})
	public void typeInAnIncompleteEmailAgain() {

		try {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys("@gmail.com"); // without first part
			driver.findElement(By.id("password")).sendKeys(Config.password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
			typeInAnIncompleteEmailAgain2();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dependsOnMethods = {"typeInAnIncompleteEmailAgain"})
	public void typeInAnIncompleteEmailAgain2() {

		try {
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys("@gmail"); // just with @gmail
			driver.findElement(By.id("password")).sendKeys(Config.password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
