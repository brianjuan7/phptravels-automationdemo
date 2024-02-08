package org.brianjuan.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.brianjuan.pages.DemoPage;
import org.brianjuan.utilities.Faker;
import org.brianjuan.utilities.Properties;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class DemoSteps {

    private final DemoPage demoPage;

    public DemoSteps(BaseStep base) {
        demoPage = new DemoPage(base.driver);
    }

    @Then("I should be able to see phptravels Demo page")
    public void iShouldSeeDemoPage() {
        Assert.assertTrue(demoPage.isDemonstrationTitleDisplayed() && demoPage.isRequestFormDisplayed(),
                "Demonstration page title and request form are not displayed.");
    }

    @When("I input all Demo Request Form fields")
    public void iInputAllDemoRequestFormFields(DataTable formFields) {
        List<Map<String, String>> listFormFields = formFields.asMaps(String.class, String.class);

        for(Map<String, String> mapFieldAndValue : listFormFields) {
            String value = mapFieldAndValue.get("Value");
            switch (mapFieldAndValue.get("Field")) {
                case "FirstName" -> demoPage.inputFirstName(value.equalsIgnoreCase("use-faker") ?
                        Faker.generateFirstName() : value);
                case "LastName" -> demoPage.inputLastName(value.equalsIgnoreCase("use-faker") ?
                        Faker.generateLastName() : value);
                case "BusinessName" -> demoPage.inputBusinessName(value);
                case "Email" -> demoPage.inputEmail(value.equalsIgnoreCase("use-faker") ?
                        Faker.generateEmail() : value);
                default -> throw new IllegalStateException("Unexpected value: " + mapFieldAndValue.get("Field"));
            }
        }
    }

    @And("I input addition result")
    public void iInputAdditionResult() {
        demoPage.inputNumberResult();
    }

    @And("I click Submit")
    public void iClickSubmit() {
        demoPage.clickSubmit();
    }

    @Then("I should be able to see successful request form message")
    public void iShouldAbleToSeeSuccessfulMessage() {
        String expectedThankYou = Properties.getValueFromMessaging("success.thankyou");
        String expectedSuccessMessage = Properties.getValueFromMessaging("success.message");

        Assert.assertTrue(demoPage.getTextThankYou().contains(expectedThankYou),
                String.format("Thank You message does not contain: %s", expectedThankYou));
        Assert.assertTrue(demoPage.getSuccessMessage().contains(expectedSuccessMessage),
                String.format("Success message does not contain: %s", expectedSuccessMessage));
    }

    @Then("^the \"(.*?)\" alert box should be displayed$")
    public void alertBoxShouldBeDisplayed(String messageType) throws InterruptedException {
        String expectedAlertMessage;

        switch (messageType) {
            case "No Result Number" -> expectedAlertMessage = Properties.getValueFromMessaging("alert.no.result.number");
            case "No First Name" -> expectedAlertMessage = Properties.getValueFromMessaging("alert.no.first.name");
            case "No Last Name" -> expectedAlertMessage = Properties.getValueFromMessaging("alert.no.last.name");
            case "No Business Name" -> expectedAlertMessage = Properties.getValueFromMessaging("alert.no.business.name");
            case "No Email" -> expectedAlertMessage = Properties.getValueFromMessaging("alert.no.email");
            default -> throw new IllegalStateException("Unexpected value: " + messageType);
        }

        Assert.assertEquals(demoPage.getAlertMessage(), expectedAlertMessage);
        Thread.sleep(5000);
        demoPage.clickAlertOkay();
    }
}
