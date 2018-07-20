package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard_Page {
	
	private static WebElement element = null;
	
	public static WebElement banner(WebDriver driver) {

		element = driver.findElement(By.xpath("//p[@class='banner']//a[@target='_blank']"));

		return element;

	}
	
	public static WebElement dropdown(WebDriver driver) {

		element = driver.findElement(By.xpath("//span[@class='angle-down']"));

		return element;

	}
	
	public static WebElement admin(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='#/admin']"));

		return element;

	}
	
	public static WebElement dropdownDashboard(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='#/']"));

		return element;

	}
	
	
	public static WebElement account(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='#/account']"));

		return element;

	}
	
	public static WebElement dropdownHelpVideos(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@target='_blank']"));

		return element;

	}
	
	public static WebElement SignOut(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='/oidc/logout']"));

		return element;

	}
	
	public static WebElement userBadge(WebDriver driver) {

		element = driver.findElement(By.xpath("//img[@alt='User Badge']"));

		return element;

	}
	
	public static WebElement stipendButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[@id='user-dashboard']//a[@target='_blank']"));

		return element;

	}
	
	public static WebElement middleGalaxyButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='#/middle_galaxy/educator']"));

		return element;

	}
	
	public static WebElement middleGalaxyLink(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[@class='flex xs12']//a[@target='_blank']"));

		return element;

	}
	
	public static WebElement glossaryLink(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='https://docs.google.com/document/d/125Un1_8o58LEPcp20GfXQ1lUhM96eq06A5B2RZC3fwo/edit?usp=sharing']"));

		return element;

	}
	
	public static WebElement helpVideos(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='https://www.youtube.com/playlist?list=PL8-bXn0RMgsp2vPnaiyuF8p3o1AzZxxkS']"));

		return element;

	}
	
	public static WebElement logoHeader(WebDriver driver) {

		element = driver.findElement(By.xpath("//img[@class='logo']"));

		return element;

	}
	
	public static WebElement logoFooter(WebDriver driver) {

		element = driver.findElement(By.xpath("//footer[@id='footer-component']//img[@class='logo']"));

		return element;

	}
	
	public static WebElement contactUs(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='https://texasoncourse.org/trainingmodules/support']"));

		return element;

	}
	
	public static WebElement dashboardFooter(WebDriver driver) {

		element = driver.findElement(By.xpath("//footer[@id='footer-component']//a[@href='#/']"));

		return element;

	}
	
	public static WebElement webAccessibility(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@href='https://cio.utexas.edu/policies/web-accessibility']"));

		return element;

	}
	
	

}
