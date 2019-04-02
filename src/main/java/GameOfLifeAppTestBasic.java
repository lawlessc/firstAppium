import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
 * Appropriated and updated by Christopher Lawless 2019
 *
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameOfLifeAppTestBasic {

    public static AndroidDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
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
    @Order(1)
    public void GameOfLifePauseAndSave() throws MalformedURLException, InterruptedException,URISyntaxException {


        //We wait for Pause button to be visible to start
        wait.until(ExpectedConditions.elementToBeClickable(By.id("c.lawless.gameoflife:id/pause")));

        driver.tap(1, 429, 581,2);

        driver.tap(1, 581, 581,2);


        driver.findElement(By.id("c.lawless.gameoflife:id/pause")).click();

        driver.findElement(By.id("c.lawless.gameoflife:id/save")).click();


        driver.findElement(By.id("c.lawless.gameoflife:id/pause")).click();


        driver.findElement(By.id("c.lawless.gameoflife:id/load")).click();

    }

    @AfterAll
    public void teardown(){
        //Teardown operation
        driver.quit();
    }
}

