package example.support.testng;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.*;

public class TestSuiteBuilder {
    public static List<XmlSuite> buildTestSuite(JSONArray devices) {
        Iterator<JSONObject> deviceIterator = devices.iterator();
        XmlSuite suite = new XmlSuite();
        suite.setName("Parallel devices execution");
        suite.setThreadCount(devices.size());
        suite.setParallel(XmlSuite.ParallelMode.TESTS);
        while (deviceIterator.hasNext()) {
            JSONObject device = deviceIterator.next();
            XmlTest test = new XmlTest(suite);
            test.setName(device.get("platformName").toString() + "_" +
                    device.get("deviceName").toString() + "_" +
                    device.get("platformVersion").toString() + " " +
                    device.get("udid").toString()
            );
            List<XmlClass> classes = new ArrayList<XmlClass>();
            classes.add(new XmlClass("example.support.TestNGCucumberTests"));
            test.setXmlClasses(classes);
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("deviceName", device.get("deviceName").toString());
            parameters.put("platformName", device.get("platformName").toString());
            parameters.put("platformVersion", device.get("platformVersion").toString());
            parameters.put("udid", device.get("udid").toString());
            test.setParameters(parameters);
        }
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        return suites;
    }
}
