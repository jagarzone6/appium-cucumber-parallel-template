package example;

import example.support.Appium;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "json:target/reports/cucumber-report.json",
        features = "src/test/resources/features"
)
public class Runner {
    @BeforeClass
    public static void setUpDriver() {
    Appium.initDriver();
    }
}
