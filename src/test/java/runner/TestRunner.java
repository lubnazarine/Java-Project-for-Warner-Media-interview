package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/features/"},
        glue={"stepDefinitions"},
        plugin ={"pretty","json:target/cucumber-reports/json-report.json",
                "junit:target/cucumber-reports/junit-report.xml",
                "html:target/cucumber-reports/html-report.html"},
        tags = "@Add",
        publish = true,
        dryRun = false,
        monochrome = false
        )

public class TestRunner {
}
