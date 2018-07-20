package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.Dashboard_Page;

public class GoToAccount {

	public static void Execute(WebDriver driver) {

		Dashboard_Page.dropdown(driver).click();
		Dashboard_Page.account(driver).click();
	}

}
