package example;

import example.support.Appium;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        plugin = "json:target/reports/cucumber-report.json",
        features = "src/test/resources/features"
)
public class Runner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void setUpDriver() {
        Appium.initDriver();
    }
}
