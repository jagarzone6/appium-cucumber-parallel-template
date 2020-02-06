package example.activityLayout;

import example.activityLayout.base.BaseLayout;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainLayout extends BaseLayout {
    @AndroidFindBy(id = "org.traeg.fastip:id/billAmtEditText")
    @iOSXCUITFindBy()
    private WebElement billAmount_Input;

    @AndroidFindBy(id = "org.traeg.fastip:id/tipAmtTextView")
    @iOSXCUITFindBy()
    private WebElement tipAmt_TextView;

    @AndroidFindBy(id = "org.traeg.fastip:id/calcTipButton")
    @iOSXCUITFindBy()
    private WebElement calcTip_Button;

    @AndroidFindBy(id = "org.traeg.fastip:id/totalAmtTextView")
    @iOSXCUITFindBy()
    private WebElement totalAmt_TextView;

    public MainLayout() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void setBillAmount(String amount) {
        this.sendKeys(amount, billAmount_Input);
    }

    public void calculateTip() {
        this.tapElement(calcTip_Button);
    }

    public String getTipAmount() {
        return this.getText(tipAmt_TextView);
    }

    public String getTotalAmount() {
        return this.getText(totalAmt_TextView);
    }
}
