package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class CartPage {
    private final By proceedToCheckoutButton = AppiumBy.xpath("//*[@content-desc=\"Proceed To Checkout button\"]");
    AndroidDriver driver;
    public CartPage(AndroidDriver driver) { this.driver = driver;}


    public CheckOutPage clickOnProceedToCheckoutButton(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(proceedToCheckoutButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return new CheckOutPage(driver);
    }
}
