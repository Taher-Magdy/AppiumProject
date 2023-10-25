package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class PaymentPage {
    private final By fullName = AppiumBy.xpath("//*[@content-desc=\"Full Name* input field\"]");
    private final By cardNumber = AppiumBy.accessibilityId("Card Number* input field");
    private final By expirationDate = AppiumBy.accessibilityId("Expiration Date* input field");
    private final By securityCode = AppiumBy.accessibilityId("Security Code* input field");
    private final By reviewOrderButton = AppiumBy.xpath("//*[@content-desc=\"Review Order button\"]");

    private final AndroidDriver driver;

    public PaymentPage(AndroidDriver driver) { this.driver = driver;}
    public ReviewProductPage enterPaymentInformation(String FullName, String CardNumber, String ExpirationDate, String SecurityCode) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(fullName).clear();
        driver.findElement(fullName).sendKeys(FullName);

        driver.findElement(cardNumber).clear();
        driver.findElement(cardNumber).sendKeys(CardNumber);

        driver.findElement(expirationDate).clear();
        driver.findElement(expirationDate).sendKeys(ExpirationDate);

        driver.findElement(securityCode).clear();
        driver.findElement(securityCode).sendKeys(SecurityCode);

        driver.findElement(reviewOrderButton).click();

        return new ReviewProductPage(driver);
    }
}
