package example.support;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public abstract class Appium {
    public static AppiumDriver driver;
    private static Properties properties = new Properties();

    public static void initDriver(String platform, String udid) {
        InputStream input = Appium.class.getClassLoader().getResourceAsStream(
                platform + ".properties"
        );
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File apk = new File(
                properties.getProperty("apk.dir"),
                properties.getProperty("apk.name"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
        capabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        if(!udid.equals("")) {
            capabilities.setCapability(MobileCapabilityType.UDID, udid);
        }

        try {
            driver = new AppiumDriver(
                    new URL("http://" +
                            properties.getProperty("appium.server.ip") + ":" +
                            properties.getProperty("appium.server.port") + "/wd/hub"),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
