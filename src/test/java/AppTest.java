import Pages.HomePage;
import Pages.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class AppTest extends BaseTest{

   //appium server --address 127.0.0.1 --port 4723 --use-drivers uiautomator2
    String Login_Data = "src/test/java/TestData/TestData.json";
    String checkoutTestData = "src/test/java/TestData/CheckoutData.json";
    String paymentTestData = "src/test/java/TestData/PaymentData.json";
    @Test
    public void CheckOutOrderTest() throws IOException, ParseException, org.json.simple.parser.ParseException {

        new HomePage(driver).ClickOnOpenMenu()
        .ClickOnLoginButton()
                .LoginData
                        (JsonReader.TestJson.getJson(Login_Data, "email"),
                        JsonReader.TestJson.getJson(Login_Data, "password"))
                .ClickOnProduct1().clickOnPlusButton()
                .clickOnaddToCartbutton().clickOnCartBadge()
                .clickOnProceedToCheckoutButton()
                .enterCheckoutInformation(
                        JsonReader.TestJson.getJson(checkoutTestData, "FullName"),
                        JsonReader.TestJson.getJson(checkoutTestData, "AddressLine"),
                        JsonReader.TestJson.getJson(checkoutTestData, "AddressLine2"),
                        JsonReader.TestJson.getJson(checkoutTestData, "City"),
                        JsonReader.TestJson.getJson(checkoutTestData, "State"),
                        JsonReader.TestJson.getJson(checkoutTestData, "ZipCode"),
                        JsonReader.TestJson.getJson(checkoutTestData, "Country")
                )
                .enterPaymentInformation(
                        JsonReader.TestJson.getJson(paymentTestData, "FullName"),
                        JsonReader.TestJson.getJson(paymentTestData, "CardNumber"),
                        JsonReader.TestJson.getJson(paymentTestData, "ExpirationDate"),
                        JsonReader.TestJson.getJson(paymentTestData, "SecurityCode"))
                .clickOnplaceOrderbutton()
                .ClickOncontinueShoppingButton();
        String productText = driver.findElement(HomePage.products).getText();
        Assert.assertEquals(productText, "Products");
    }
}
