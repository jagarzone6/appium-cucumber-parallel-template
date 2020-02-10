package example.support;

import example.support.appium.AppiumDriver;
import example.support.appium.AppiumServerHelper;
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
    @Parameters({"deviceName", "platformName", "platformVersion", "udid"})
    public static void setUpDriver(String deviceName, String platformName, String platformVersion, String udid) {
        AppiumDriver.initDriver(deviceName, platformName, platformVersion, udid);
    }

    @AfterClass(alwaysRun = true)
    public static void shutDown() {
        AppiumServerHelper.shutDownAppiumServer();
        AppiumDriver.shutDownDriver();
    }
}
