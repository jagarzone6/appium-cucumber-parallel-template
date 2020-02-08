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
    }
    @BeforeClass
    @Parameters({"platform", "udid", "server_url"})
    public static void setUpDriver(String platform, String udid, String server_url) {
        System.out.println("Current Thread ID- " + Thread.currentThread().getId() + " For Thread- " + Thread.currentThread().getName());
        Appium.initDriver(platform, udid, server_url);
    }
}
