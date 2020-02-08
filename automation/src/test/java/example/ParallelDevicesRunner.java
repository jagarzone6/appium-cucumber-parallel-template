package example;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParallelDevicesRunner {
    public static void main(String[] args) {
        XmlSuite suite = new XmlSuite();
        suite.setName("Parallel Devices Execution");
        suite.setThreadCount(2);
        suite.setParallel(XmlSuite.ParallelMode.TESTS);

        XmlTest test = new XmlTest(suite);
        test.setName("Android native app test on Android A device");
        List<XmlClass> classes = new ArrayList<XmlClass>();
        classes.add(new XmlClass("example.support.TestNGCucumberTests"));
        test.setXmlClasses(classes);
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("platform", "Android");
        parameters.put("udid", "emulator-5554");
        parameters.put("server_url", "http://127.0.0.1:4723/wd/hub");
        test.setParameters(parameters);

        XmlTest test2 = new XmlTest(suite);
        test2.setName("Android native app test on Android B device");
        List<XmlClass> classes2 = new ArrayList<XmlClass>();
        classes2.add(new XmlClass("example.support.TestNGCucumberTests"));
        test2.setXmlClasses(classes2);
        Map<String, String> parameters2 = new HashMap<String, String>();
        parameters2.put("platform", "Android");
        parameters2.put("udid", "emulator-5556");
        parameters2.put("server_url", "http://127.0.0.1:4724/wd/hub");
        test2.setParameters(parameters2);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        TestNG tng = new TestNG();
        tng.setOutputDirectory("target/testng-report");
        tng.setXmlSuites(suites);
        tng.run();
    }
}
