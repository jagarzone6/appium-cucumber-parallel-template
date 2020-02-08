package example.activityLayout.base;

import example.support.Appium;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseLayout extends Appium {
    protected AppiumDriver driver;

    public BaseLayout(){
        driver = driverThreadLocal.get();
    }

    protected void sendKeys(String keys, WebElement element){
        element.sendKeys(keys);
    }

    protected void clearElement(WebElement element){
        element.clear();
    }

    protected String getText(WebElement element){
        return element.getText();
    }

    protected void clickElement(WebElement element){
        element.click();
    }

    public void goBack(){
        driver.navigate().back();
    }
}
