package org.brianjuan.steps;

import io.cucumber.java.en.When;
import org.brianjuan.pages.Menu;

public class MenuSteps {

    private final Menu menu;

    public MenuSteps(BaseStep base) {
        menu = new Menu(base.driver);
    }

    @When("I click {string} in menu")
    public void iClickMenu(String menuItemName) {
        menu.clickMenu(menuItemName);
    }
}
