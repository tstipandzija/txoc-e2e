package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CheckAllButtons {

	
	WebDriver driver; 

	public void invokeBrowser() {

		try {

			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "/Users/tomislavstipandzija/Downloads/chromedriver"); driver = new
			 * ChromeDriver();
			 */

			System.setProperty("webdriver.gecko.driver", "/Users/tomislavstipandzija/Downloads/geckodriver");
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myprofile = profile.getProfile("default");
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setCapability(FirefoxDriver.PROFILE, myprofile);
			dc.setCapability("marionette", true);
			driver = new FirefoxDriver();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			checkTheButtons();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void checkTheButtons() {

		try {
			driver.get("https://account.stage.texasoncourse.org/interaction/13a24ef4-7ca8-4d3a-aaf8-2600772bbf9d");
			String titleofThePage = driver.getTitle();
			System.out.println("Title of the page is: " + titleofThePage);
			driver.findElement(By.xpath("html/body/div/div/div/div[1]/form/fieldset/div[3]/button")).click();
			String buttonName = driver.findElement(By.xpath("html/body/div/div/div/div[1]/form/fieldset/div[3]/button")).getText();
			System.out.println("Login = " + buttonName);
			String needToRegister = driver.findElement(By.linkText("Need to register?")).getText();
			System.out.println("Need to register? = " + needToRegister);
			driver.findElement(By.linkText("Need to register?")).click();
			driver.navigate().back();
			String forgotPassword = driver.findElement(By.linkText("Forgot password?")).getText();
			System.out.println("Forgot password? = " + forgotPassword);
			driver.findElement(By.linkText("Forgot password?")).click();
			driver.findElement(By.xpath("html/body/div/div/div/div/form/fieldset/div[2]/button")).click();
			String reset = driver.findElement(By.xpath("html/body/div/div/div/div/form/fieldset/div[2]/button")).getText();
			System.out.println("Reset = " + reset);
			String contactSupport = driver.findElement(By.linkText("Contact support")).getText();
			System.out.println("Contact support = " + contactSupport);
			driver.findElement(By.linkText("Contact support")).click();
			driver.navigate().back();
			driver.navigate().back();
			String contactsupport = 	driver.findElement(By.linkText("Contact support")).getText();
			System.out.println("Contact support = " + contactsupport);
			driver.findElement(By.linkText("Contact support")).click();
			driver.navigate().back();
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		CheckAllButtons obj = new CheckAllButtons();
		obj.invokeBrowser();
		LogInWithNonexistingAccount obj1 = new LogInWithNonexistingAccount();
		obj1.typeInTheNonexistingAccount();
		CorrectEmailIncorrectPass obj2 = new CorrectEmailIncorrectPass();
		obj2.typeInTheWrongCredentials1();
		IncorrectEmailCorrectPass obj3 = new IncorrectEmailCorrectPass();
		obj3.typeInTheWrongCredentials2();
		LoginWithExistingAccount obj4 = new LoginWithExistingAccount();
		obj4.typeInTheRightCredentials();
		LoginWIthEmptyPass obj5 = new LoginWIthEmptyPass();
		obj5.leaveEmptyPass();
		LoginWithEmptyEmail obj6 = new LoginWithEmptyEmail();
		obj6.leaveEmptyEmail();
		LoginWithTheSamePassAsEmail obj7 = new LoginWithTheSamePassAsEmail();
		obj7.typePassAsEmail(); 
		LoginWithTheSameEmailAsPass obj8 = new LoginWithTheSameEmailAsPass();
		obj8.typeEmailAsPass();
		CheckForgotPassword obj9 = new CheckForgotPassword();
		obj9.checkForgotPass();
		AnEmailWithoutAKeyChar obj10 = new AnEmailWithoutAKeyChar();
		obj10.typeInAnEmailWithoutAKeyChar();
			
	}

}
