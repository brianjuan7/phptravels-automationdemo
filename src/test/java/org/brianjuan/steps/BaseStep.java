package org.brianjuan.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.brianjuan.pages.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseStep {

    protected WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(BasePage.class);

    @Before
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            // Take a screenshot
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String filename = String.format("%s_Failed_Screenshot", scenario.getName().replace(" ","-"));

            // Attach screenshot in the HTML report
            scenario.attach(screenshot,"image/png", filename);

            logger.info("{} was saved and attached to the HTML report.", filename);
        }

        driver.quit();
    }
}
