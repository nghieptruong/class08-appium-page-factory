package pages.factories;

import drivers.DriverManager;
import enums.PlatformType;
import pages.abstracts.CatalogPage;
import pages.abstracts.LoginPage;
import pages.abstracts.components.NavigationBar;
import pages.android.AndroidCatalogPage;
import pages.android.AndroidLoginPage;
import pages.android.components.AndroidNavigationBar;
import pages.ios.IOSCatalogPage;
import pages.ios.IOSLoginPage;
import pages.ios.components.IOSNavigationBar;
import utils.PlatformUtils;

public class PageManagerFactory {

    public static CatalogPage getCatalogPage() {
        if(PlatformUtils.getPlatformType() == PlatformType.ANDROID) {
            return new AndroidCatalogPage(DriverManager.getCurrentDriver());
        } else if(PlatformUtils.getPlatformType() == PlatformType.IOS) {
            return new IOSCatalogPage(DriverManager.getCurrentDriver());
        } else {
            return null;
        }
    }

    public static LoginPage getLoginPage() {
        if(PlatformUtils.getPlatformType() == PlatformType.ANDROID) {
            return new AndroidLoginPage(DriverManager.getCurrentDriver());
        } else if(PlatformUtils.getPlatformType() == PlatformType.IOS) {
            return new IOSLoginPage(DriverManager.getCurrentDriver());
        } else {
            return null;
        }
    }

    public static NavigationBar getNavigationBar() {
        if(PlatformUtils.getPlatformType() == PlatformType.ANDROID) {
            return new AndroidNavigationBar(DriverManager.getCurrentDriver());
        } else if(PlatformUtils.getPlatformType() == PlatformType.IOS) {
            return new IOSNavigationBar(DriverManager.getCurrentDriver());
        } else {
            return null;
        }
    }
}
