package example.stepsDefinition.base;

import example.support.cucumber.World;

public abstract class BaseStepsDefinition {

    public World world;

    public BaseStepsDefinition(World world) {
        this.world = world;
    }
}
