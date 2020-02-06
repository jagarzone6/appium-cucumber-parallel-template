package example.activityLayout.base;

import example.support.Appium;
import org.openqa.selenium.WebElement;

public abstract class BaseLayout extends Appium {

    protected void sendKeys(String keys, WebElement element){
        element.sendKeys(keys);
    }

    protected String getText(WebElement element){
        return element.getText();
    }

    protected void tapElement(WebElement element){
        element.click();
    }

}
