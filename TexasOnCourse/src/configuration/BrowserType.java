package configuration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserType {

	public static WebDriver Execute(String browser) {

		WebDriver driver = null;

		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/tomislavstipandzija/Downloads/geckodriver");
			driver = new FirefoxDriver(); // launch firefox
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/tomislavstipandzija/Downloads/chromedriver");
			driver = new ChromeDriver(); // launch chrome
		}
		return driver;

	}

}
