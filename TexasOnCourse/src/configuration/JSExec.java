package configuration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExec {
	
	public static void clickElement(WebElement element, WebDriver driver) {
		
		WebElement elementToClick = element;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		JavascriptExecutor jsExec = null;
		jsExec.executeScript("arguments[0].click();", elementToClick);
	}

}
