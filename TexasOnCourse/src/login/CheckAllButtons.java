package login;

import java.util.Properties;
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
import pageObjects.Login_Page;
import pageObjects.ResetPassword_Page;

public class CheckAllButtons {

	
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
	public void checkTheButtons() {

		try {
			String titleofThePage = driver.getTitle();
			System.out.println("Title of the page is: " + titleofThePage);
			Assert.assertEquals(titleofThePage, "Texas OnCourse Academy");
			Login_Page.loginButton(driver).click();
			String buttonName = Login_Page.loginButton(driver).getText();
			System.out.println("Login = " + buttonName);
			Assert.assertEquals(buttonName, "Login");
			String needToRegister = Login_Page.alreadyRegistered(driver).getText();
			System.out.println("Need to register? = " + needToRegister);
			Assert.assertEquals(needToRegister, "Need to register?");
			Login_Page.alreadyRegistered(driver).click();
			driver.navigate().back();
			String forgotPassword = Login_Page.forgotPassword(driver).getText();
			System.out.println("Forgot password? = " + forgotPassword);
			Assert.assertEquals(forgotPassword, "Forgot password?");
			Login_Page.forgotPassword(driver).click();
			ResetPassword_Page.resetButton(driver).click();
			String reset = ResetPassword_Page.resetButton(driver).getText();
			System.out.println("Reset = " + reset);
			Assert.assertEquals(reset, "Reset");
			String contactSupport = ResetPassword_Page.contactSupport(driver).getText();
			System.out.println("Contact support = " + contactSupport);
			Assert.assertEquals(contactSupport, "Contact support");
			Login_Page.contactSupport(driver).click();
			driver.navigate().back();
			driver.navigate().back();
			String contactsupport = Login_Page.contactSupport(driver).getText();
			System.out.println("Contact support = " + contactsupport);
			Assert.assertEquals(contactsupport, "Contact support");
			Login_Page.contactSupport(driver).click();
			driver.navigate().back();
			
		} catch (Throwable t) {
		     throw new Error ("Test failed: " + this.getClass().getSimpleName() + ", reason: " + t.getMessage());
		}
		  finally {

			driver.quit();
		}

	}

	//public static void main(String[] args) {

		/*CheckAllButtons obj = new CheckAllButtons();
		obj.invokeBrowser();
		LoginWithNonexistingAccount obj1 = new LoginWithNonexistingAccount();
		obj1.typeInTheNonexistingAccount();
		CorrectEmailIncorrectPass obj2 = new CorrectEmailIncorrectPass();
		obj2.typeInTheWrongCredentials1();
		IncorrectEmailCorrectPass obj3 = new IncorrectEmailCorrectPass();
		obj3.typeInTheWrongCredentials2();
		LoginWithExistingAccount obj4 = new LoginWithExistingAccount();
		obj4.typeInTheRightCredentials();
		LoginWithEmptyPass obj5 = new LoginWIthEmptyPass();
		obj5.leaveEmptyPass();
		LoginWithEmptyEmail obj6 = new LoginWithEmptyEmail();
		obj6.leaveEmptyEmail();
		LoginWithTheSamePassAsEmail obj7 = new LoginWithTheSamePassAsEmail();
		obj7.typePassAsEmail(); 
		LoginWithTheSameEmailAsPass obj8 = new LoginWithTheSameEmailAsPass();
		obj8.typeEmailAsPass();
		AnEmailWithoutAKeyChar obj10 = new AnEmailWithoutAKeyChar();
		obj10.typeInAnEmailWithoutAKeyChar();
		CheckForgotPassword obj9 = new CheckForgotPassword();
		obj9.checkForgotPass();*/
			
	}


