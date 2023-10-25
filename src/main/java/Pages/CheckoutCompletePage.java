package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CheckoutCompletePage {
    private final By continueShoppingButton = AppiumBy.xpath("//*[@content-desc=\"Continue Shopping button\"]");
    AndroidDriver driver;
    public CheckoutCompletePage(AndroidDriver driver) {
        this.driver = driver;
    }
    public HomePage ClickOncontinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
        return new HomePage(driver);
    }
}

