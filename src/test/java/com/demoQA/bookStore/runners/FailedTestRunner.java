package com.demoQA.bookStore.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/demoQA/bookStore/stepDefinitions",
        features = "@target/rerun.txt"
)

public class FailedTestRunner {
}