package org.brianjuan.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = "org.brianjuan.steps",
        plugin = { "pretty", "json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/cucumberreport.html" }
)
public class RunnerTest extends AbstractTestNGCucumberTests { }
