import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;


public class BaseTest {
    AndroidDriver driver;
    UiAutomator2Options options = new UiAutomator2Options();
    @BeforeTest
    public void openApp() throws IOException {
        //appium server --address 127.0.0.1 --port 4723 --use-drivers uiautomator2
        //com.saucelabs.mydemoapp.rn.MainActivity
        //mCurrentFocus=Window{5655999 u0 com.saucelabs.mydemoapp.rn/com.saucelabs.mydemoapp.rn.MainActivity}
        //mFocusedApp=AppWindowToken{1e098ac token=Token{2011126 ActivityRecord{a174c81 u0 com.saucelabs.mydemoapp.rn/.MainActivity t67}}}
        options.setApp(Path.of(System.getProperty("user.dir"), "/app/Android-MyDemoAppRN.1.3.0.build-244.apk").toString());
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("device1");
        options.setUdid("emulator-5554");
        options.setAppWaitActivity("com.saucelabs.mydemoapp.rn.MainActivity");
        //options.setAppWaitPackage("com.saucelabs.mydemoapp.rn");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }
    @AfterTest
    public void closeApp(){driver.quit();}
}
