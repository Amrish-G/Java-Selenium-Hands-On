package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import PageObjects.BaseFunc;
public class Login_TestCase extends BaseFunc {

//	Login_TestCase(RemoteWebDriver driver){
//		this.driver = driver;
//	}

	@Test(dataProvider = "tdata", dataProviderClass = PageObjects.BaseFunc.class)
	public void login_Test(String[] dta) throws InterruptedException {
		

		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, DashboardPage.class);

		//Login page scripts
		LoginPage.userName.sendKeys(dta[0]);
		LoginPage.password.sendKeys(dta[1]);
		LoginPage.loginBtn.click();

		//Dashboard page scripts
		DashboardPage.profileMenu.click();
		DashboardPage.logoutBtn.click();
		System.out.println("Logged out successfully");

	}
	
	@BeforeMethod
	public void launch() {
		startWebApp();
	}
	
	@AfterMethod
	public void close() {
		closeWebApp();
	}
}
