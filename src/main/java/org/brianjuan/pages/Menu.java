package org.brianjuan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Menu extends BasePage {

    public Menu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private WebElement menuItem(String menuItemName) {
        String xpath = String.format("//div[@id='mynavbar']/ul/li/a[contains(text(),'%s')]", menuItemName);

        return driver.findElement(By.xpath(xpath));
    }

    public void clickMenu(String menuItemName) {
        waitUntilElementIsVisible(menuItem(menuItemName)).click();
    }
}
