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
import configuration.Login_Action;
import configuration.SignOut_Action;
import pageObjects.Account_Page;

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
	public void checkButtonsAndLinks() {

		try {
			Login_Action.Execute(driver);
			Thread.sleep(3000);
			GoToAccount.Execute(driver);

			int iframeSize = driver.findElements(By.tagName("iframe")).size();
			System.out.println("Total number of iframes = " + iframeSize);
			driver.switchTo().frame(Account_Page.iframe(driver));
			String update = Account_Page.updateButton(driver).getText();
			System.out.println("Update = " + update);
			Assert.assertEquals(update, "Update");
			WebElement el0 = Account_Page.updateButton(driver);
			JavascriptExecutor jsExec0 = (JavascriptExecutor) driver;
			jsExec0.executeScript("arguments[0].click()", el0);
			Thread.sleep(2000);

			String classCodes = Account_Page.classCodes(driver).getText();
			System.out.println("Class codes = " + classCodes);
			WebElement el = Account_Page.classCodes(driver);
			JavascriptExecutor jsExec = (JavascriptExecutor) driver;
			jsExec.executeScript("arguments[0].click()", el);
			Thread.sleep(3000);

			WebElement el1 = Account_Page.newClassCode(driver);
			JavascriptExecutor jsExec1 = (JavascriptExecutor) driver;
			jsExec1.executeScript("arguments[0].click()", el1);
			String newCode = Account_Page.newClassCode(driver).getText();
			System.out.println("+ New Code = " + newCode);

			WebElement el2 = Account_Page.issuedClassCode(driver);
			JavascriptExecutor jsExec2 = (JavascriptExecutor) driver;
			jsExec2.executeScript("arguments[0].click()", el2);
			Thread.sleep(2000);

			String contactSupport = Account_Page.contactSupport(driver).getText();
			System.out.println("Contact support = " + contactSupport);
			Assert.assertEquals(contactSupport, "Contact support");
			WebElement el3 = Account_Page.contactSupport(driver);
			JavascriptExecutor jsExec3 = (JavascriptExecutor) driver;
			jsExec3.executeScript("arguments[0].click()", el3);
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);

			String classCodeList = Account_Page.classCodeList(driver).getText();
			System.out.println("Class code list = " + classCodeList);
			Assert.assertEquals(classCodeList, "Class code list");
			WebElement el4 = Account_Page.classCodeList(driver);
			JavascriptExecutor jsExec4 = (JavascriptExecutor) driver;
			jsExec4.executeScript("arguments[0].click()", el4);
			Thread.sleep(2000);

			String contactsupport = Account_Page.contactSupport(driver).getText();
			System.out.println("Contact support = " + contactsupport);
			WebElement el5 = Account_Page.contactSupport(driver);
			Assert.assertEquals(contactSupport, "Contact support");
			JavascriptExecutor jsExec5 = (JavascriptExecutor) driver;
			jsExec5.executeScript("arguments[0].click()", el5);
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);

			String profilePage = Account_Page.profilePage(driver).getText();
			System.out.println("Profile page = " + profilePage);
			Assert.assertEquals(profilePage, "Profile page");
			WebElement el6 = Account_Page.profilePage(driver);
			JavascriptExecutor jsExec6 = (JavascriptExecutor) driver;
			jsExec6.executeScript("arguments[0].click()", el6);
			Thread.sleep(2000);

			String contactSupport1 = Account_Page.contactSupport(driver).getText();
			System.out.println("Contact support = " + contactSupport1);
			Assert.assertEquals(contactSupport1, "Contact support");
			WebElement el7 = Account_Page.contactSupport(driver);
			JavascriptExecutor jsExec7 = (JavascriptExecutor) driver;
			jsExec7.executeScript("arguments[0].click()", el7);
			Thread.sleep(2000);
			driver.navigate().back();

			WebElement el8 = Account_Page.social(driver);
			JavascriptExecutor jsExec8 = (JavascriptExecutor) driver;
			jsExec8.executeScript("arguments[0].click()", el8);

			Thread.sleep(3000);
			String acces = Account_Page.accessPathbriteProfile(driver).getText();
			System.out.println("Access Pathbrite Profile = " + acces);
			Assert.assertEquals(acces, "Access Pathbrite Profile");
			WebElement el9 = Account_Page.accessPathbriteProfile(driver);
			JavascriptExecutor jsExec9 = (JavascriptExecutor) driver;
			jsExec9.executeScript("arguments[0].click()", el9);

			driver.switchTo().defaultContent();
			SignOut_Action.Execute(driver);

		} catch (Throwable t) {
		     throw new Error ("Test failed: " + this.getClass().getSimpleName() + ", reason: " + t.getMessage());
		
		} finally {

			driver.quit();
		}

	}

	// public static void main(String[] args) {

	/*
	 * CheckAllButtons obj = new CheckAllButtons(); obj.checkButtonsAndLinks();
	 * UpdateWithABlankFirstName obj1 = new UpdateWithABlankFirstName();
	 * obj1.leaveEmptyFirstNameAndUpdate(); UpdateWithABlankLastName obj2 = new
	 * UpdateWithABlankLastName(); obj2.leaveEmptyLastNameAndUpdate();
	 * UpdateWithABlankEmail obj3 = new UpdateWithABlankEmail();
	 * obj3.leaveEmptyEmailAndUpdate(); UpdateWithABlankOccupation obj4 = new
	 * UpdateWithABlankOccupation(); obj4.leaveEmptyOccupationAndUpdate();
	 * UpdateOccupationTwice obj5 = new UpdateOccupationTwice();
	 * obj5.selectOccupationSelectEmptyAndUpdate(); UpdateWithSomeOccupation obj6 =
	 * new UpdateWithSomeOccupation(); obj6.selectOccupationAndUpdate();
	 * UpdateWithSpecCharacters obj7 = new UpdateWithSpecCharacters();
	 * obj7.sendSpecCharactersAndUpdate(); UpdateAnEmailWithAnExistingOne obj8 = new
	 * UpdateAnEmailWithAnExistingOne(); obj8.sendEmailThatExistsAndUpdate();
	 * UpdateWithABlankSchool obj9 = new UpdateWithABlankSchool();
	 * obj9.leaveEmptyDistrictAndUpdate(); UpdateWithADifferentESCRegion obj10 = new
	 * UpdateWithADifferentESCRegion(); obj10.changeRegionAndUpdate();
	 * UpdateWithABlankSupervisor obj11 = new UpdateWithABlankSupervisor();
	 * obj11.leaveBlankAndUpdate(); UpdateSupervisorWithASpecChar obj12 = new
	 * UpdateSupervisorWithASpecChar(); obj12.passSupTheSpecChar();
	 * UpdateWitABlankSupEmail obj13 = new UpdateWitABlankSupEmail();
	 * obj13.leaveABlankEmail(); UpdateDistrictWithASpecChar obj14 = new
	 * UpdateDistrictWithASpecChar(); obj14.passDisTheSpecChar();
	 * UpdateWithABlankTwitterAndLinkedIn obj15 = new
	 * UpdateWithABlankTwitterAndLinkedIn(); obj15.leaveEmptyTwitterAndLinkedIn();
	 * UpdateTwitterAndLinkendInWithASpecChar obj16 = new
	 * UpdateTwitterAndLinkendInWithASpecChar();
	 * obj16.passTwitterAndLinkedInSpecChar();
	 */

}
