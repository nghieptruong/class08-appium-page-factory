package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static final Logger logger = LogManager.getLogger(DriverManager.class);
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(String browserName) {
        if(driver.get() == null) {
            try {
                driver.set(createDriver(browserName));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        return driver.get();
    }

    private static WebDriver createDriver(String platformName) throws MalformedURLException {
        WebDriver webDriver;
        switch (platformName) {
            case "android":
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setAutomationName("UiAutomator2");
                options.setDeviceName("Pixel 9");
                options.setUdid("emulator-5554");
                options.setPlatformVersion("15");
                options.setAppPackage("com.saucelabs.mydemoapp.android");
                options.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");
                options.setAppWaitActivity("com.saucelabs.mydemoapp.android.view.activities.MainActivity");
                webDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
                break;
            case "ios":
                //Not implemented yet !
                webDriver = null;
                break;
            default:
                throw new IllegalArgumentException("Platform not supported: " + platformName);
        }
        logger.info("Driver initialized for platform: " + platformName);
        return webDriver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static WebDriver getCurrentDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if(driver.get() != null) {
            driver.get().quit();
            driver.remove();
            logger.info("Driver quit successfully");
        }
    }
}
