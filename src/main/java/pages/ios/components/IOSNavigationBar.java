package pages.ios.components;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.components.NavigationBar;

public class IOSNavigationBar extends NavigationBar {

    @iOSXCUITFindBy(accessibility = "More-tab-item")
    public WebElement mainMenu;

    @iOSXCUITFindBy(accessibility = "Login Button")
    public WebElement loginMenuItem;

    @iOSXCUITFindBy(accessibility = "Login Button")
    public WebElement logoutMenuItem;

    public IOSNavigationBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openMainMenu() {
        click(mainMenu);
    }

    @Override
    public void openLoginPage() {
        click(loginMenuItem);
    }

    @Override
    public void openMenuItem(String item) {

    }

    @Override
    public boolean isLogoutMenuItemDisplayed() {
        return logoutMenuItem.isDisplayed();
    }
}
