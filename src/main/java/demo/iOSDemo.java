package demo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class iOSDemo {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("ios");
        options.setAutomationName("XCUITest");
        options.setDeviceName("iPhone 17 Pro Simulator");
        options.setUdid("87F8DA42-F0F6-4C6F-85C9-84646D59A10B");
//        options.setApp("/Users/nghieptruong/Data/TrainingMac/AppiumTraining/iOSDemoApp/My Demo App.app"); // install app moi
        options.setBundleId("com.saucelabs.mydemo.app.ios"); // tu do mo app
        AppiumDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        By byMainMenu = AppiumBy.accessibilityId("More-tab-item");
        WebElement mainMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(byMainMenu));
        mainMenu.click();

        Thread.sleep(3000);
    }
}
