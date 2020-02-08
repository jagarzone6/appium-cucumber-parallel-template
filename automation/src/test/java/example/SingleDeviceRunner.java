package example;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleDeviceRunner {
    public static void main(String[] args) {
        XmlSuite suite = new XmlSuite();
        suite.setName("Single Device Execution");

        XmlTest test = new XmlTest(suite);
        test.setName("Device A");
        List<XmlClass> classes = new ArrayList<XmlClass>();
        classes.add(new XmlClass("example.support.TestNGCucumberTests"));
        test.setXmlClasses(classes);
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("platform", "Android");
        parameters.put("udid", "");
        parameters.put("server_url", "http://127.0.0.1:4723/wd/hub");
        test.setParameters(parameters);
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.setOutputDirectory("target/testng-report");
        tng.run();
    }
}
