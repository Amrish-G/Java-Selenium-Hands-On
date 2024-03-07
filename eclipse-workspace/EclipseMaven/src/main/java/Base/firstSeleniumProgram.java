package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class firstSeleniumProgram {
	
	@Test
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\amris\\Webdrivers\\chromedriver-win64\\chromedriver-win64\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/");
		driver.quit();
		
		System.out.println("Done");
		
	}

}
