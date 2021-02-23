package com.cybertek.library.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "com/cybertek/library/step_definitions",
        plugin = "html:target/cucumber-report.html",
        tags = "@wip"




)
public class CukesRunner {
}
