package example.support.cucumber;

import example.activityLayout.MainLayout;
import example.activityLayout.SettingsLayout;

public class World {

    public MainLayout mainLayout;
    public SettingsLayout settingsLayout;

    public World() {
        this.mainLayout = new MainLayout();
        this.settingsLayout = new SettingsLayout();
    }
}
