package org.brianjuan.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.brianjuan.pages.HomePage;
import org.testng.Assert;

public class HomeSteps {

    private final HomePage homePage;

    public HomeSteps(BaseStep base) {
        homePage = new HomePage(base.driver);
    }

    @Given("I visit phptravels Home page")
    public void iVisitHomePage() {
        homePage.goToHomePage();
    }

    @Then("I should be able to see phptravels Home page")
    public void iShouldSeeLogoAndRequestForm() {
        Assert.assertTrue(homePage.isBrandLogoDisplayed() && homePage.isStartBusinessTitleDisplayed()
                ,"Logo and request form are not displayed.");
    }
}
