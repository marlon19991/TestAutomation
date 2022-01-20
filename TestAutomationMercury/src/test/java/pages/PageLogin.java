package pages;

import helpers.Helpers;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageLogin {
    Helpers helpers = new Helpers();
    //traemos un nuevo webdrives
    private WebDriver driver;
    private By userField; //identificar los elementos con una nomenclatura especial
    private By passwordField;
    private By loginButton;
    private By flightsButton;
    private By fields;

    //necesitamos un constructor de clase
    public PageLogin(WebDriver driver){ //le vamos a pasar un webdriver
        this.driver = driver;
        userField = By.name("userName");
        passwordField = By.name("password");
        loginButton = By.name("submit");
        flightsButton = By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a");
        fields = By.tagName("input");
    }

    public void login (String user, String pass) {
        WebElement passwordFieldDos = driver.findElement(By.name("password"));
        driver.findElement(userField).sendKeys(user);
        passwordFieldDos.sendKeys(pass); //prueba webelement
        passwordFieldDos.submit();
        //driver.findElement(loginButton).click();
        driver.findElement(flightsButton).click();
        // Implicit Wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void fieldsLogin(String user, String pass) {
        List<WebElement> loginFields = driver.findElements(fields);
        loginFields.get(1).sendKeys(user);
        loginFields.get(2).sendKeys(pass);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void verifyFields() {
        List<WebElement> loginFields = driver.findElements(fields);
        System.out.println(loginFields.size());
        System.out.println(loginFields.get(3).getText().length());

        Assert.assertTrue(loginFields.size()==4, "No existe el número de elementos requeridos");
    }

}
