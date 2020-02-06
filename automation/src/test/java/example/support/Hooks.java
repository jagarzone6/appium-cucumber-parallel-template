package example.support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void doSomethingBefore(Scenario scenario) {
    }

    @After
    public void doSomethingAfter(Scenario scenario) {
    }
}
