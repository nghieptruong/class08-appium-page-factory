package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ConfigManager;
import utils.PlatformUtils;

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
                String androidPackage = ConfigManager.getProperty("android.package");
                String androidActivity = ConfigManager.getProperty("android.startActivity");
                String androidMainActivity = ConfigManager.getProperty("android.mainActivity");
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setAutomationName("UiAutomator2");
                options.setDeviceName(ConfigManager.getProperty("android.deviceName"));
                options.setUdid(ConfigManager.getProperty("android.udid"));
                options.setPlatformVersion(ConfigManager.getProperty("android.platformVersion"));
                options.setAppPackage(androidPackage);
                options.setAppActivity(androidActivity);
                options.setAppWaitActivity(androidMainActivity);
                webDriver = new AndroidDriver(PlatformUtils.getRemoteURL(), options);
                break;
            case "ios":
                String bundleId = ConfigManager.getProperty("ios.bundleid");
                XCUITestOptions iosOptions = new XCUITestOptions();
                iosOptions.setPlatformName("ios");
                iosOptions.setAutomationName("XCUITest");
                iosOptions.setDeviceName(ConfigManager.getProperty("ios.deviceName"));
                iosOptions.setUdid(ConfigManager.getProperty("ios.udid"));
    //        options.setApp("/Users/nghieptruong/Data/TrainingMac/AppiumTraining/iOSDemoApp/My Demo App.app"); // install app moi
                iosOptions.setBundleId(bundleId); // tu dong mo app
                webDriver = new IOSDriver(PlatformUtils.getRemoteURL(), iosOptions);
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
