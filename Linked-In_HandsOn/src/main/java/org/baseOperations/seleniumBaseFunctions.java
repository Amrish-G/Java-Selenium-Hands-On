package org.baseOperations;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class seleniumBaseFunctions implements baseFunctions{

    private static RemoteWebDriver driver = null;
    long time = 10000;
    long waitTime = 10000;
    WebDriverWait wait ;


    private void windowSetting() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    private WebElement eleAvailability(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\amris\\Webdrivers\\chromedriver-win64\\chromedriver-win64\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        windowSetting();
        driver.get(url);
    }

    public void openBrowser(String browser, String url) {
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        "C:\\Users\\amris\\Webdrivers\\chromedriver-win64\\chromedriver-win64\\chromedriver-win32\\chromedriver.exe");
                driver = new ChromeDriver();
                windowSetting();
                driver.get(url);
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver",
                        "C:\\Users\\amris\\Webdrivers\\edgedriver_win64 (1)\\msedgedriver.exe");
                driver = new EdgeDriver();
                windowSetting();
                driver.get(url);
            default:
                System.err.println("No proper browser input provided");
                break;
        }

    }

    public void closeApp() {
        driver.close();
    }

    public void quitApp() {
        driver.quit();
    }

    public WebElement findElement(String type, String value) {
        try {
            switch (type.toLowerCase()) {
                case "name" :
                    return driver.findElement(By.name(value));
                case "id" :
                    return driver.findElement(By.id(value));
                case "xpath" :
                    return driver.findElement(By.xpath(value));
                case "classname" :
                    return driver.findElement(By.className(value));
                case "linktext" :
                    return driver.findElement(By.linkText(value));
                case "tagname" :
                    return driver.findElement(By.tagName(value));
                case "cssselector" :
                    return driver.findElement(By.cssSelector(value));
                default:
                    System.err.println("Proper Locator not defined");
                    break;
            }
        } catch (NoSuchElementException e) {
            System.out.println("No element returned "+ e.getMessage());
        }
        return null;
    }

    public void clickElement(WebElement element) {
        WebElement ele = eleAvailability(element);
        ele.click();
    }

    public void addText(WebElement element, String message) {
        WebElement ele = eleAvailability(element);
        ele.sendKeys(message);
    }

    public void appendText(WebElement element, String message) {
        WebElement ele = eleAvailability(element);
        ele.clear();
        ele.sendKeys(message);
    }

    public void multiWindows(int a) {
        Set<String> windowSet =  driver.getWindowHandles();
        List<String> openWindowStrings = new ArrayList<>(windowSet);
        driver.switchTo().window(openWindowStrings.get(a));
    }

    public void selectByVisibleText(WebElement element, String visibleText) {
        WebElement ele = eleAvailability(element);
        Select s = new Select(ele);
        s.selectByValue(visibleText);;
    }

    public void selectByValue(WebElement element, String value) {
        WebElement ele = eleAvailability(element);
        Select s = new Select(ele);
        s.selectByValue(value);
    }

    public void selectByIndex(WebElement element, int i) {
        WebElement ele = eleAvailability(element);
        Select s = new Select(ele);
        s.selectByIndex(i);
    }

    public String windowTitle() {
        return driver.getTitle();
    }

    public String currentURL() {
        return driver.getCurrentUrl();
    }

    public String getTextValue(WebElement element) {
        return element.getText();
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    public void iframeViaIndex(int i) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(i));
    }

    public void iframeViaElement(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public void iframeViaString(String name) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
    }

    public void navigateDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void navigateToParentframe() {
        driver.switchTo().parentFrame();
    }
}
