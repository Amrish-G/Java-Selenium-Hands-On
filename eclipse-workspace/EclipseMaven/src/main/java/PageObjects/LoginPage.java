package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginPage {
	
	@FindBy(name = "username")
	public static WebElement userName;
	
	@FindBy(name = "password")
	public static WebElement password;
	
	@FindBy(xpath = "//*/button")
	public static WebElement loginBtn;
	
		
	}

