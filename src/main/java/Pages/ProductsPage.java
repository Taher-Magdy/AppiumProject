package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class ProductsPage extends BasePage {

    AndroidDriver driver;
    public ProductsPage(AndroidDriver driver){
        this.driver = driver;
    }
    // private static By product_ele =
    private final By counterPlusButton = AppiumBy.xpath("//*[@content-desc=\"counter plus button\"]");
    private final By addToCartButton = AppiumBy.xpath("//*[@content-desc=\"Add To Cart button\"]");
    private final By cartBadge = AppiumBy.xpath("//*[@content-desc=\"cart badge\"]");


    public ProductsPage clickOnPlusButton() {
        driver.findElement(counterPlusButton).click();
        return this;
    }

    public ProductsPage clickOnaddToCartbutton() {
        driver.findElement(addToCartButton).click();
        return this;
    }

    public CartPage clickOnCartBadge() {
        driver.findElement(cartBadge).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return new CartPage(driver);
    }
}
