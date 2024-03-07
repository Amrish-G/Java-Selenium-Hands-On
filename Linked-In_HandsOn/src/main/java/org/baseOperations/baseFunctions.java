package org.baseOperations;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;

public interface baseFunctions {
    /**
     * @author amris
     * @param url
     * Description -> This function is to launch Chrome browser and opens given WebApp
     */
    void openBrowser(String url);


    /**
     * Description -> This function is to launch browser based on user inputs and opens given WebApp
     * @author amris
     * @param browser
     * @param url
     * @exception null Pointer Exceptionxception
     */
    void openBrowser(String browser, String url) ;


    /**
     * Description -> This function closes current window
     * @author amris
     */
    void closeApp();


    /**
     * Description -> This function quits all active operation
     * @author amris
     */
    void quitApp();


    /**
     * Description -> This function takes the type of Locator and value to search as its argument and returns the webelement
     * @author amris
     * @param type,value
     * @return Webelement
     */
    WebElement findElement(String type, String value) ;


    /**
     * Description -> This function clicks the passed Webelement
     * @author amris
     * @param element
     */
    void clickElement(WebElement element);


    /**
     * Description -> This function takes string value passed and type it in passed webelement
     * @author amris
     * @param element
     * @param message
     */
    void addText(WebElement element, String message) ;


    /**
     * Description -> This function takes string value passed and type it in  passed webelement after clearing already written value
     * @author amris
     * @param element
     * @param message
     */
    void appendText(WebElement element, String message) ;


    /**
     * Description -> This function is used to handle multiple windows
     * @author amris
     * @param a
     */
    void multiWindows(int a);


    /**
     * Description -> This function is used to select value in drop-down using the value's visibleText
     * @author amris
     * @param element
     * @param visibleText
     */
    void selectByVisibleText(WebElement element, String visibleText);


    /**
     * Description -> This function is used to select value in drop-down using the value's text
     * @author amris
     * @param element
     * @param value
     */
    void selectByValue(WebElement element, String value);


    /**
     * Description -> THis function is used to select value in drop-down using the value's index
     * @author amris
     * @param element
     * @param i
     */
    void selectByIndex(WebElement element, int i);


    /**
     * Description -> This function returns the value of current window title
     * @author amris
     * @return String
     */
    String windowTitle();


    /**
     * Description -> This function returns value of current page's URL
     * @author amris
     * @return String
     */
    String currentURL();


    /**
     * Description -> This function returns the text value on passed element
     * @param element
     * @return String
     */
    String getTextValue(WebElement element);


    /**
     * Description -> This function takes webelement as input and validates whether it's displayed or not
     * @author amris
     * @param element
     * @return boolean True/False
     */
    boolean isDisplayed(WebElement element);


    /**
     * Description -> This function takes webelement as input and validates whether it's selected or not
     * @author amris
     * @param element
     * @return boolean True/False
     */
    boolean isSelected(WebElement element);


    /**
     * Description -> This fucntion validates whether the passed element is enabled or not
     * @param element
     * @return boolean True/False
     */
    boolean isEnabled(WebElement element);


    /**
     * Description -> This function is to switch to iframes using its index
     * @author amris
     * @param i
     * @exception NoSuchFrameException
     */
    void iframeViaIndex(int i);


    /**
     * Description -> This function is to switch to iframe using Web element
     * @author amris
     * @param element
     * @exception NoSuchFrameException, NoSuchElementException
     */
    void iframeViaElement(WebElement element);


    /**
     * Description -> This function is to switch to iframe using its name or id
     * @author amris
     * @param name
     * @exception NoSuchFrameException
     */
    void iframeViaString(String name);


    /**
     * Description -> This function is used to switch back to default content
     */
    void navigateDefaultContent();


    /**
     * Description -> This function is used to switch to parent frame
     */
    void navigateToParentframe();



}
