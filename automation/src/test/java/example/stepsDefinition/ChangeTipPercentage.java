package example.stepsDefinition;

import example.stepsDefinition.base.BaseStepsDefinition;
import example.support.cucumber.World;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangeTipPercentage extends BaseStepsDefinition {
    public ChangeTipPercentage(World world) {
        super(world);
    }

    @When("I change tip percentage to {string}")
    public void i_change_tip_percentage_to(String value) {
        world.mainLayout.goToSettings();
        world.settingsLayout.clearTipPercentage();
        world.settingsLayout.setTipPercentage(value);
    }

    @And("save settings")
    public void save_settings() {
        world.settingsLayout.saveSettings();
    }

    @And("go back to calculate view")
    public void go_back() {
        world.settingsLayout.goBack();
    }

    @Then("tip percentage is {string}")
    public void tip_percentage_is(String value) {
        assert world.mainLayout.getTipPercentage().equals(value);
    }

    @Then("tip percentage is not {string}")
    public void tip_percentage_is_not(String value) {
        assert !world.mainLayout.getTipPercentage().equals(value);
    }
}
