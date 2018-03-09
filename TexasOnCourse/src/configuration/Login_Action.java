package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Action {
	
	public static void Execute(WebDriver driver) {
		
		driver.get(Config.url);
		driver.findElement(By.id("email")).sendKeys(Config.email);
		driver.findElement(By.id("password")).sendKeys(Config.password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
			
	}

}
