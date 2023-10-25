package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ReviewProductPage {
    private final By placeOrderbutton = AppiumBy.xpath("//*[@content-desc=\"Place Order button\"]");

    AndroidDriver driver ;
    public ReviewProductPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public CheckoutCompletePage clickOnplaceOrderbutton (){
        driver.findElement(placeOrderbutton).click();
        return new CheckoutCompletePage(driver);
    }
}
