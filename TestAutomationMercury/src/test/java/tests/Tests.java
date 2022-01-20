package tests;

import helpers.Helpers;
import helpers.Screenshooter;
import helpers.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Tests {
    Helpers helpers = new Helpers();
    private WebDriver driver;
    ArrayList<String> tabs;
    @BeforeMethod
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
        //driver.manage().window().setSize(new Dimension(200,200)); //determinar tamaño del browser
        /*for (int i=0;i<800;i++)
            driver.manage().window().setPosition(new Point(i,i));*/
        //driver.manage().window().setPosition(new Point(500, 500)); //determianr posición del browser
        driver.navigate().to("https://demo.guru99.com/test/newtours/");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver; // ejecutar script nueva tab
        String googleWindow = "window.open('http://www.google.com')";
        javascriptExecutor.executeScript(googleWindow);
        tabs = new ArrayList<String>(driver.getWindowHandles());
        //helpers.sleepSeconds(4);
    }

    @Test
    public void pruebaUno() {
        WebDriverManager.setWindowSize(driver, "maximized");
        WebDriverManager.setWindowSize(driver, 400, 400);
        driver.switchTo().window(tabs.get(1)).navigate().to("http://www.youtfffu5rwerewrbe.com");
        driver.switchTo().window(tabs.get(0));
        PageLogin pagelogin = new PageLogin(driver);
        PageLogon pageLogon = new PageLogon(driver);
        PageReservation pageReservation = new PageReservation(driver);
        pagelogin.login("user", "user");
        pageReservation.selectPassengers(2);
        pageReservation.selectDeparture(6);
        pageReservation.selectArrival("New York");
        pageLogon.assertLogonPage();

    }

    @Test
    public void pruebaCantidadDeCampos() {
        //WebDriverManager.setWindowSize(driver, "fullscreen");
        PageLogin pageLogin = new PageLogin(driver);
        pageLogin.verifyFields();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if (!result.isSuccess()){
            Screenshooter.takeScreenShot("Error", driver);
        }
        driver.switchTo().window(tabs.get(1)).close();
        driver.switchTo().window(tabs.get(0)).close();
    }
}
