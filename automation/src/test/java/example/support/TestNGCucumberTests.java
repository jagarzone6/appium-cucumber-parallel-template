package example.support;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"example.stepsDefinition"}
)
public class TestNGCucumberTests extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters({"platform", "udid", "server_url"})
    public static void setUpDriver(String platform, String udid, String server_url) {
        Appium.initDriver(platform, udid, server_url);
    }

    @AfterClass
    public static void shutDown() {
        Appium.driverThreadLocal.get().quit();
    }
}
