package example;

import example.support.testng.TestSuiteBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ParallelDevicesTestsRunner {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray devices = (JSONArray) jsonParser.parse(
                new InputStreamReader(
                        ParallelDevicesTestsRunner.class.getClassLoader().getResourceAsStream(
                                "devices.json"
                        )));
        List<XmlSuite> suites = TestSuiteBuilder.buildTestSuite(devices);
        TestNG tng = new TestNG();
        tng.setOutputDirectory("target/testng-report");
        tng.setXmlSuites(suites);
        tng.run();
    }
}
