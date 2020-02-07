package example.support;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"example.stepsDefinition"}
)
public class TestNGCucumberTests extends AbstractTestNGCucumberTests {
    public TestNGCucumberTests(String testName){
        testName.trim();
        //System.setProperty("cucumber.plugin", "json:target/reports/");
    }
    @BeforeClass
    @Parameters({"platform", "udid"})
    public static void setUpDriver(String platform, String udid) {
        Appium.initDriver(platform, udid);
    }
}
