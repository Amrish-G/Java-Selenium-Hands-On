package PageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import Base.utils;


public class BaseFunc {

	String launchURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	protected RemoteWebDriver driver = null ;

	public void startWebApp() {
		//intializing web-application
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amris\\Webdrivers\\chromedriver-win64\\chromedriver-win64\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(launchURL);
		System.out.println("Browser Opened");
	}
	
	public void closeWebApp() {
		driver.quit();
		System.out.println("Browser closed");
	}
	
	@DataProvider(name = "tdata")
	public String[][] testData() throws IOException{
		String[][] loginCredentials = utils.propetyFileData();
		return loginCredentials;
		
	}

}
