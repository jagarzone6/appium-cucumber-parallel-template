package example.support.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

public class AppiumServerHelper {
    private static ThreadLocal<AppiumDriverLocalService> serverThreadLocal =
            new ThreadLocal<AppiumDriverLocalService>();
    private static Properties properties = new Properties();

    public static URL launchAppiumServer() throws IOException {
        InputStream input = AppiumDriver.class.getClassLoader().getResourceAsStream(
                "appium-server.properties"
        );
        properties.load(input);
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingDriverExecutable(new File(properties.getProperty("nodejs.executable.path")));
        serviceBuilder.withAppiumJS(new File(properties.getProperty("appiumjs.instalation.path")));
        HashMap<String, String> environment = new HashMap();
        environment.put("PATH", System.getenv("PATH"));
        serviceBuilder.withEnvironment(environment);
        serviceBuilder.usingAnyFreePort();
        serverThreadLocal.set(AppiumDriverLocalService.buildService(serviceBuilder));
        serverThreadLocal.get().start();
        return serverThreadLocal.get().getUrl();
    }

    public static void shutDownAppiumServer() {
        serverThreadLocal.get().stop();
    }
}
