package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
	
	@FindBy(xpath = "//span/i[1]")
	public static WebElement profileMenu;
	
	@FindBy(xpath = "//*/a[text()='Logout']")
	public static WebElement logoutBtn;

}
