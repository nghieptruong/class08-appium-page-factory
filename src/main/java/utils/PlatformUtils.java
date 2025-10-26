package utils;

import drivers.DriverManager;
import enums.PlatformType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class PlatformUtils {

    public static PlatformType getPlatformType() {
        WebDriver driver = DriverManager.getCurrentDriver();
        if(driver instanceof AndroidDriver) {
            return PlatformType.ANDROID;
        } else if(driver instanceof IOSDriver) {
            return PlatformType.IOS;
        } else {
            return null;
        }
    }

    public static URL getRemoteURL() {
        String host = ConfigManager.getProperty("appium.host");
        String port = ConfigManager.getProperty("appium.port");
        try {
            return new URL(String.format("http://%s:%s/", host, port));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
