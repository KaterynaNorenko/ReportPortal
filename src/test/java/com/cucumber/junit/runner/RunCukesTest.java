package com.cucumber.junit.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter"},
        monochrome = true,
        tags = "@regression",
        glue = "com.cucumber.junit",
        features = "classpath:com/cucumber/junit/features"
)

public class RunCukesTest {
}
