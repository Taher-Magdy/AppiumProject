package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class HomePage extends BasePage {

    AndroidDriver driver;
    public HomePage (AndroidDriver driver){
        this.driver=driver;
    }
    public static By products = AppiumBy.xpath("//*[@text='Products']");
    private final By open_menu = AppiumBy.accessibilityId("open menu");
    private final By login = AppiumBy.accessibilityId("menu item log in");
    private final By product1 = AppiumBy.xpath("(//*[@content-desc=\"store item\"])[1]");
    /*public HomePage ClickOnOpenMenu(){
        driver.findElement(open_menu).click();
        return this;
    }*/
    public HomePage ClickOnOpenMenu() {
        driver.findElement(open_menu).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return this;
    }
    // driver.findElement(By.xpath("\"(//android.view.ViewGroup[@content-desc=\\\"store item\\\"])[3]/android.view.ViewGroup[1]/android.widget.ImageView\"");).click();
    public LoginPage ClickOnLoginButton(){
        driver.findElement(login).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
       return new LoginPage(driver);
    }

    public ProductsPage ClickOnProduct1 () {
        driver.findElement(product1).click();
        return new ProductsPage(driver);
    }
}
