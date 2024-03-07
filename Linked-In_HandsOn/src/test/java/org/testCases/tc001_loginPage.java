package org.testCases;
import org.baseOperations.seleniumBaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.pageObjects.demoApp_loginPage;
import org.testUtils.fileUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class tc001_loginPage extends seleniumBaseFunctions{

        @Test(dataProvider = "login-credentials", dataProviderClass = fileUtils.class)
        public void testcase(String[] dta){
        demoApp_loginPage demo = new demoApp_loginPage();
        System.out.println(demo.elementTitle());
        addText(demo.username(),dta[0]);
        addText(demo.password(), dta[1]);
        clickElement(demo.btn());
        Assert.assertEquals(demo.pageTitle(),"ACME demo app");
      }



    @BeforeMethod
    public void launchBrowser() throws IOException {
        openBrowser("edge",fileUtils.readPropertyFile());
    }

    @AfterMethod
    public void tearDown(){
        quitApp();
    }


}
