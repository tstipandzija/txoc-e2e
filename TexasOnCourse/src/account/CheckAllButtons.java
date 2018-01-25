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

public class CheckAllButtons {

	WebDriver driver; 

	public void invokeBrowser(String url) {

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
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void checkButtonsAndLinks() {

		try {
			invokeBrowser("https://account.stage.texasoncourse.org/interaction/1ac8be08-0660-4cdf-8998-0e10aedd20a3");
			driver.findElement(By.id("email")).sendKeys("dsdsds");
			driver.findElement(By.id("password")).sendKeys("dsdsds");
			driver.findElement(By.xpath("html/body/div/div/div/div[1]/form/fieldset/div[3]/button")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='app']/div[3]/div[2]/div/div/div/div/p")).click();
			driver.findElement(By.xpath(".//*[@id='app']/div[2]/ul/li[2]/a/div")).click();

			int iframeSize = driver.findElements(By.tagName("iframe")).size();
			System.out.println("Total number of iframes = " + iframeSize);
			driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div/div[3]/iframe")));
			
			String update = driver.findElement(By.xpath(".//*[@id='updateButton']")).getText();
			System.out.println("Update = " + update);
			WebElement el0 = driver.findElement(By.xpath(".//*[@id='updateButton']"));
			JavascriptExecutor jsExec0 = (JavascriptExecutor) driver;
			jsExec0.executeScript("arguments[0].click()", el0);
			Thread.sleep(2000);

			String classCodes = driver.findElement(By.xpath(".//*[@id='profileForm']/fieldset/div[2]/a")).getText();
			System.out.println("Class codes = " + classCodes);
			WebElement el = driver.findElement(By.xpath(".//*[@id='profileForm']/fieldset/div[2]/a"));
			JavascriptExecutor jsExec = (JavascriptExecutor) driver;
			jsExec.executeScript("arguments[0].click()", el);
			Thread.sleep(3000);

			WebElement el1 = driver.findElement(By.xpath("html/body/div/div/div/div[2]/fieldset/div[1]/a"));
			JavascriptExecutor jsExec1 = (JavascriptExecutor) driver;
			jsExec1.executeScript("arguments[0].click()", el1);
			String newCode = driver.findElement(By.xpath("html/body/div/div/div/div[2]/fieldset/div[1]/a")).getText();
			System.out.println("+ New Code = " + newCode);

			WebElement el2 = driver.findElement(By.xpath("html/body/div/div/div/div[2]/table/tbody[2]/tr[2]/td[1]/a"));
			JavascriptExecutor jsExec2 = (JavascriptExecutor) driver;
			jsExec2.executeScript("arguments[0].click()", el2);
			Thread.sleep(3000);

			String contactSupport = driver.findElement(By.linkText("Contact support")).getText();
			System.out.println("Contact support = " + contactSupport);
			WebElement el3 = driver.findElement(By.linkText("Contact support"));
			JavascriptExecutor jsExec3 = (JavascriptExecutor) driver;
			jsExec3.executeScript("arguments[0].click()", el3);
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);

			String classCodeList = driver.findElement(By.xpath("html/body/div/div/div/div[2]/fieldset/div[1]/a"))
					.getText();
			System.out.println("Class code list = " + classCodeList);
			WebElement el4 = driver.findElement(By.xpath("html/body/div/div/div/div[2]/fieldset/div[1]/a"));
			JavascriptExecutor jsExec4 = (JavascriptExecutor) driver;
			jsExec4.executeScript("arguments[0].click()", el4);
			Thread.sleep(2000);

			String contactsupport = driver.findElement(By.linkText("Contact support")).getText();
			System.out.println("Contact support = " + contactsupport);
			WebElement el5 = driver.findElement(By.linkText("Contact support"));
			JavascriptExecutor jsExec5 = (JavascriptExecutor) driver;
			jsExec5.executeScript("arguments[0].click()", el5);
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);

			String profilePage = driver.findElement(By.linkText("Profile page")).getText();
			System.out.println("Profile page = " + profilePage);
			WebElement el6 = driver.findElement(By.linkText("Profile page"));
			JavascriptExecutor jsExec6 = (JavascriptExecutor) driver;
			jsExec6.executeScript("arguments[0].click()", el6);
			Thread.sleep(2000);

			String contactSupport1 = driver.findElement(By.linkText("Contact support")).getText();
			System.out.println("Contact support = " + contactSupport1);
			WebElement el7 = driver.findElement(By.linkText("Contact support"));
			JavascriptExecutor jsExec7 = (JavascriptExecutor) driver;
			jsExec7.executeScript("arguments[0].click()", el7);
			Thread.sleep(2000);
			driver.navigate().back();

			WebElement el8 = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/ul/li[3]/a"));
			JavascriptExecutor jsExec8 = (JavascriptExecutor) driver;
			jsExec8.executeScript("arguments[0].click()", el8);

			Thread.sleep(3000);
			String acces = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/form/div[3]/a")).getText();
			System.out.println("Access Pathbrite Profile = " + acces);
			WebElement el9 = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/form/div[3]/a"));
			JavascriptExecutor jsExec9 = (JavascriptExecutor) driver;
			jsExec9.executeScript("arguments[0].click()", el9);
			Thread.sleep(4000);

			driver.switchTo().defaultContent();
			driver.findElement(By.xpath(".//*[@id='app']/div[2]/div[2]/div/div/div/div/p")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div[1]/ul/li[4]/a/div")).click();
			Thread.sleep(5000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		CheckAllButtons obj = new CheckAllButtons();
		obj.checkButtonsAndLinks();
		UpdateWithABlankFirstName obj1 = new UpdateWithABlankFirstName();
		obj1.leaveEmptyFirstNameAndUpdate();
		UpdateWithABlankLastName obj2 = new UpdateWithABlankLastName();
		obj2.leaveEmptyLastNameAndUpdate();
		UpdateWithABlankEmail obj3 = new UpdateWithABlankEmail();
		obj3.leaveEmptyEmailAndUpdate();
		UpdateWithABlankOccupation obj4 = new UpdateWithABlankOccupation();
		obj4.leaveEmptyOccupationAndUpdate();
		UpdateOccupationTwice obj5 = new UpdateOccupationTwice();
		obj5.selectOccupationSelectEmptyAndUpdate();
		UpdateWithSomeOccupation obj6 = new UpdateWithSomeOccupation();
		obj6.selectOccupationAndUpdate();
		UpdateWithSpecCharacters obj7 = new UpdateWithSpecCharacters();
		obj7.sendSpecCharactersAndUpdate();
		UpdateAnEmailWithAnExistingOne obj8 = new UpdateAnEmailWithAnExistingOne();
		obj8.sendEmailThatExistsAndUpdate();
		UpdateWithABlankSchool obj9 = new UpdateWithABlankSchool();
		obj9.leaveEmptyDistrictAndUpdate();
		UpdateWithADifferentESCRegion obj10 = new UpdateWithADifferentESCRegion();
		obj10.changeRegionAndUpdate();
		UpdateWithABlankSupervisor obj11 = new UpdateWithABlankSupervisor();
		obj11.leaveBlankAndUpdate();
		UpdateSupervisorWithASpecChar obj12 = new UpdateSupervisorWithASpecChar();
		obj12.passSupTheSpecChar();
		UpdateWitABlankSupEmail obj13 = new UpdateWitABlankSupEmail();
		obj13.leaveABlankEmail();
		UpdateDistrictWithASpecChar obj14 = new UpdateDistrictWithASpecChar();
		obj14.passDisTheSpecChar();
		UpdateWithABlankTwitterAndLinkedIn obj15 = new UpdateWithABlankTwitterAndLinkedIn();
		obj15.leaveEmptyTwitterAndLinkedIn();
		UpdateTwitterAndLinkendInWithASpecChar obj16 = new UpdateTwitterAndLinkendInWithASpecChar();
		obj16.passTwitterAndLinkedInSpecChar();
		
		
		
		
		


	}

}
