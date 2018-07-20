package configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.WebDriver;

public class GoToTab {

	public static void Execute(WebDriver driver) {

		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		System.out.println("Number of tabs = " + tabs.size());
		driver.switchTo().window((String) tabs.get(1));
		driver.navigate().refresh();
		driver.close();
		driver.switchTo().window((String) tabs.get(0));
		 }

		/*
		 * for (String handle : driver.getWindowHandles()) {
		 * driver.switchTo().window(handle); }
		 * 
		 * driver.navigate().refresh(); driver.close();
		 */

	}


