package example.stepsDefinition;

import example.stepsDefinition.base.BaseStepsDefinition;
import example.support.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculateTip extends BaseStepsDefinition {

    public CalculateTip(World world) {
        super(world);
    }

    @Given("I am using FasTip app")
    public void i_am_using_FasTip_app() {

    }

    @When("I use {int} of bill amount")
    public void i_enter_of_bill_amount(Integer int1) {
        world.mainLayout.setBillAmount(int1.toString());
        world.mainLayout.calculateTip();
    }

    @Then("tip value is {string}")
    public void tip_value_is(String amount) {
        assert world.mainLayout.getTipAmount().equals(amount);
    }

    @Then("total amount is {string}")
    public void total_amount_is(String amount) {
        assert world.mainLayout.getTotalAmount().equals(amount);
    }
}
