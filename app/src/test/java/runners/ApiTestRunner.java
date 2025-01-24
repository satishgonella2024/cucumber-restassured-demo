package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:features",
    glue = "stepdefinitions",
    plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    }
)
public class ApiTestRunner {
}