package example.support;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public abstract class Appium {
    protected static ThreadLocal<AppiumDriver> driverThreadLocal =
            new ThreadLocal<AppiumDriver>();
    private static Properties properties = new Properties();

    public static AppiumDriver initDriver(String platform, String udid, String serverURL) {
        InputStream input = Appium.class.getClassLoader().getResourceAsStream(
                platform + ".properties"
        );
        try {
            properties.load(input);
        } catch (IOException e) {
            throw new Error("Properties file not found: " + platform + ".properties");
        }
        File apk = new File(
                properties.getProperty("apk.dir"),
                properties.getProperty("apk.name"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
        capabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        //capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        if (!udid.equals("")) {
            capabilities.setCapability(MobileCapabilityType.UDID, udid);
        }
        try {
            driverThreadLocal.set(new AppiumDriver(
                    new URL(serverURL),
                    capabilities));
            return driverThreadLocal.get();
        } catch (Exception e) {
            throw new Error("Could not initialize AppiumDriver: " + e.getCause().getMessage());
        }
    }
}
