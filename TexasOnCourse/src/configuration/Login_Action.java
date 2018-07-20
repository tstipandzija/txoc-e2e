package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.Login_Page;

public class Login_Action {
	
	public static void Execute(WebDriver driver) {
		
		Login_Page.email(driver).sendKeys(Config.email);
		Login_Page.password(driver).sendKeys(Config.password);
		Login_Page.loginButton(driver).click();
			
	}

}
