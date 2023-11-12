package appiumTask;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {

     AndroidDriver driver;
     AppiumDriverLocalService service;


    @BeforeClass
    public void runAppium() throws MalformedURLException {

    // create capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("NewDevice");
        options.setApp(System.getProperty("user.dir")+"\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();


        //create object for android driver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();
    }

    public void performLogin(String username, String password) {
            // Implement the login steps using Appium, for example:
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys(password);
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys(username);
            driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")).click();

        }

     public void assertSuccessfulLogin(){
         Assert.assertEquals(Boolean.TRUE,driver.findElement(AppiumBy.linkText("PRODUCTS")).isDisplayed());
     }
     public void assertFailedLogin(String expectedError){
         WebElement errorMessage = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Username is required\"]"));
         Assert.assertEquals(errorMessage.getText(), expectedError);
     }
    }

