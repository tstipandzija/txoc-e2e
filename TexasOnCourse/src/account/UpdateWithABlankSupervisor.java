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
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import configuration.BrowserType;
import configuration.Config;
import configuration.Login_Action;

public class UpdateWithABlankSupervisor {

	WebDriver driver; 

	@Test
	@Parameters("browser")
	public void invokeBrowser(@Optional("firefox") String browser) {

		try {
	
			driver = BrowserType.Execute(browser);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			leaveBlankAndUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void leaveBlankAndUpdate() {

		try {
			Login_Action.Execute(driver);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[@class='angle-down']")).click();
			driver.findElement(By.xpath("//a[@href='#/account']")).click();

			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://account.stage.texasoncourse.org/users/profile']")));

			String school = driver.findElement(By.xpath("//a[@href='#schoolContent']")).getText();
			System.out.println("School = " + school);
			Assert.assertEquals(school, "School");
			WebElement el = driver.findElement(By.xpath("//a[@href='#schoolContent']"));
			JavascriptExecutor jsExec = (JavascriptExecutor) driver;
			jsExec.executeScript("arguments[0].click()", el);
			Thread.sleep(2000);

			driver.findElement(By.id("supervisor")).clear();

			String update = driver.findElement(By.xpath("//a[@id='updateButton']")).getText();
			System.out.println("Update = " + update);
			Assert.assertEquals(update, "Update");
			WebElement el1 = driver.findElement(By.xpath("//a[@id='updateButton']"));
			JavascriptExecutor jsExec1 = (JavascriptExecutor) driver;
			jsExec1.executeScript("arguments[0].click()", el1);
			Thread.sleep(4000);

			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//span[@class='angle-down']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@href='/oidc/logout']")).click();
			Thread.sleep(5000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
