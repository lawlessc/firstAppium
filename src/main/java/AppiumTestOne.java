import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Onur Baskirt on 05.04.2016.
 */
public class AppiumTestOne {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Setup Appium
        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability(MobileCapabilityType.APP, "c.lawless.gameoflife");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"AndroidOreo");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appActivity", "MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait= new WebDriverWait(driver,20);
    }

    @Test
    public void appiumBitBarTest() throws MalformedURLException, InterruptedException,URISyntaxException {
        setUp();
        //Click second radio button
        //driver.findElement(By.name("Use Testdroid Cloud")).click();

        //Write SW Test Academy to the text area
        //driver.findElement(By.className("android.widget.EditText")).sendKeys("SW Test Academy");

        //Hide Keyboard
       // driver.hideKeyboard();

        //Click Answer Button
       // driver.findElement(By.name("Answer")).click();

        //Synchronization after click and check the expected text
      //  wait.until(ExpectedConditions.presenceOfElementLocated(By.name("You are right!")));
    }

    @AfterClass
    public void teardown(){
        //Teardown operation
        driver.quit();
    }
}

