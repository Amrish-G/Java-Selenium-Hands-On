package org.pageObjects;

import org.baseOperations.seleniumBaseFunctions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class demoApp_loginPage extends seleniumBaseFunctions{

    public WebElement username(){
         return findElement("id","username");
    }

    public WebElement password(){
        return findElement("id","password");
    }

    public WebElement btn(){
        return findElement("id","log-in");
    }

    public String elementTitle(){
        return getTextValue(findElement("classname","auth-header"));
    }

    public String pageTitle(){
        return windowTitle();
    }
}
