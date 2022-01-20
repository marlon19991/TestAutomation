package pages;

import helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageLogon {
    Helpers helpers = new Helpers();
    private WebDriver driver;
    private By assertText;
    public PageLogon (WebDriver driver) {
        this.driver = driver;
        assertText = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
    }

    public void assertLogonPage () {
        Assert.assertTrue(driver.findElement(assertText).getText().contains("Use our Flight"));
    }
}
