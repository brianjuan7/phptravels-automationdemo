package org.brianjuan.pages;

import org.brianjuan.utilities.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private Alert alert;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitUntilElementIsVisible(WebElement element) {
        long waitDurationSeconds = Long.parseLong(Properties.getValueFromConfiguration("default.wait.seconds"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitDurationSeconds));

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitUntilElementIsVisible(WebElement element, long seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getAlertMessage() {
        alert = driver.switchTo().alert();

        return alert.getText();
    }

    public void clickAlertOkay() {
        alert = driver.switchTo().alert();

        alert.accept();
    }
}
