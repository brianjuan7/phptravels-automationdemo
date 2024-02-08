package org.brianjuan.pages;

import org.brianjuan.utilities.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='mynavbar']/parent::div/a")
    private WebElement logoBrand;

    @FindBy(xpath = "//strong/small[contains(text(), 'Start an Online')]")
    private WebElement titleStartBusiness;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToHomePage() {
        driver.get(Properties.getValueFromConfiguration("url.home"));
    }

    public boolean isBrandLogoDisplayed() {
        return waitUntilElementIsVisible(logoBrand).isDisplayed();
    }

    public boolean isStartBusinessTitleDisplayed() {
        return waitUntilElementIsVisible(titleStartBusiness).isDisplayed();
    }
}
