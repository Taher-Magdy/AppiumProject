package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoginPage extends BasePage {
    AndroidDriver driver;
    public LoginPage (AndroidDriver driver){
        this.driver = driver;
    }
    private static final By usernameele = AppiumBy.accessibilityId("Username input field");
    private static final By passwordele = AppiumBy.accessibilityId("Password input field");
    private static final By login = AppiumBy.accessibilityId("Login button");

    public HomePage LoginData(String username, String password){
        driver.findElement(usernameele).sendKeys(username);
        driver.findElement(passwordele).sendKeys(password);
        driver.findElement(login).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return new HomePage(driver);
    }
   /* public void login_Data(String username,String password){
        driver.findElement(usernameele).sendKeys(username);
        driver.findElement(passwordele).sendKeys(password);
        driver.findElement(login).click();
    }*/
  }
