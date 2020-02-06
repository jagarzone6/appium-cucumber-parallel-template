package example.activityLayout;

import example.activityLayout.base.BaseLayout;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SettingsLayout extends BaseLayout {
    @AndroidFindBy(id = "org.traeg.fastip:id/tipPercentageEditText")
    @iOSXCUITFindBy()
    private WebElement tipPercentage_EditText;

    @AndroidFindBy(id = "org.traeg.fastip:id/saveSettingsButton")
    @iOSXCUITFindBy()
    private WebElement saveSettings_Button;


    public SettingsLayout() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clearTipPercentage() {
        this.clearElement(tipPercentage_EditText);
    }

    public void setTipPercentage(String amount) {
        this.sendKeys(amount, tipPercentage_EditText);
    }

    public void saveSettings() {
        this.clickElement(saveSettings_Button);
    }


}
