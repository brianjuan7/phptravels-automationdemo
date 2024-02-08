package org.brianjuan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage extends BasePage {

    @FindBy(xpath = "//main[@id='swup']/div[@class='headline']/div[@class='container']/h1[contains(text(), 'Demonstration')]")
    private WebElement titleDemonstration;

    @FindBy(xpath = "//h2[contains(text(), 'Instant demo request form')]")
    private WebElement titleRequestForm;

    @FindBy(xpath = "//input[@name='first_name']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[@name='business_name']")
    private WebElement inputBusinessName;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement inputEmail;

    @FindBy(id = "numb1")
    private WebElement textNumber1;

    @FindBy(id = "numb2")
    private WebElement textNumber2;

    @FindBy(id = "number")
    private WebElement inputNumberResult;

    @FindBy(xpath = "//button[@id='demo']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//div[@class='completed']/h2/strong")
    private WebElement textThankYou;

    @FindBy(xpath = "//div[@class='completed']/p")
    private WebElement textSuccessMessage;

    public DemoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isDemonstrationTitleDisplayed() {
        return waitUntilElementIsVisible(titleDemonstration).isDisplayed();
    }

    public boolean isRequestFormDisplayed() {
        return waitUntilElementIsVisible(titleRequestForm).isDisplayed();
    }

    public void inputFirstName(String firstName) {
        waitUntilElementIsVisible(inputFirstName).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        waitUntilElementIsVisible(inputLastName).sendKeys(lastName);
    }

    public void inputBusinessName(String businessName) {
        waitUntilElementIsVisible(inputBusinessName).sendKeys(businessName);
    }

    public void inputEmail(String email) {
        waitUntilElementIsVisible(inputEmail).sendKeys(email);
    }

    public void inputNumberResult() {
        int number1 = Integer.parseInt(waitUntilElementIsVisible(textNumber1).getText());
        int number2 = Integer.parseInt(waitUntilElementIsVisible(textNumber2).getText());
        int result = number1 + number2;

        waitUntilElementIsVisible(inputNumberResult).sendKeys(Integer.toString(result));
    }

    public void clickSubmit() {
        waitUntilElementIsVisible(buttonSubmit).click();
    }

    public String getTextThankYou() {
        return waitUntilElementIsVisible(textThankYou).getText();
    }

    public String getSuccessMessage() {
        return waitUntilElementIsVisible(textSuccessMessage).getText();
    }
}
