package example.support.appium;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AppiumDriver {
    protected static ThreadLocal<io.appium.java_client.AppiumDriver> driverThreadLocal =
            new ThreadLocal<io.appium.java_client.AppiumDriver>();
    private static Properties properties = new Properties();

    public static void initDriver(String deviceName, String platformName, String platformVersion, String udid) {
        InputStream input = AppiumDriver.class.getClassLoader().getResourceAsStream(
                platformName + ".properties"
        );
        try {
            properties.load(input);
        } catch (IOException e) {
            throw new Error("Properties file not found: " + platformName + ".properties");
        }
        File apk = new File(
                properties.getProperty("apk.dir"),
                properties.getProperty("apk.name"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        if (!udid.equals("")) {
            capabilities.setCapability(MobileCapabilityType.UDID, udid);
        }
        try {
            driverThreadLocal.set(new io.appium.java_client.AppiumDriver(
                    AppiumServerHelper.launchAppiumServer(),
                    capabilities));
        } catch (Exception e) {
            throw new Error("Could not initialize AppiumDriver: " + e.getCause().getMessage());
        }
    }

    public static void shutDownDriver() {
        driverThreadLocal.get().quit();
    }
}
