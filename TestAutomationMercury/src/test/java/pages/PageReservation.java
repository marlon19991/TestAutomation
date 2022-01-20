package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PageReservation {
    private WebDriver driver;
    private By passengersDrop;
    private By fromDrop;
    private By toDrop;

    public PageReservation (WebDriver driver) {
        this.driver = driver;
        passengersDrop = By.name("passCount");
        fromDrop = By.name("fromPort");
        toDrop = By.name("toPort");
    }

    public void selectPassengers(int cant) {
        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //se puede poner solo 10
        wait.until(ExpectedConditions.visibilityOfElementLocated(passengersDrop));
        // Fluent Wait
        FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);
        Select selectPassengers = new Select(driver.findElement(passengersDrop));
        selectPassengers.selectByVisibleText(Integer.toString(cant));
    }

    public void selectDeparture(int departureIndex) {
        Select selectDeparture = new Select(driver.findElement(fromDrop));
        selectDeparture.selectByIndex((departureIndex));
    }

    public void selectArrival(String arrival) {
        Select selectArrival = new Select(driver.findElement(toDrop));
        selectArrival.selectByValue((arrival));
    }
}
