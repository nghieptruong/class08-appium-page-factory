package pages.android.components;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.components.NavigationBar;

public class AndroidNavigationBar extends NavigationBar {

    @AndroidFindBy(accessibility = "View menu")
    public WebElement mainMenu;

    @AndroidFindBy(accessibility = "Login Menu Item")
    public WebElement loginMenuItem;

    @AndroidFindBy(accessibility = "Logout Menu Item")
    public WebElement logoutMenuItem;

    public AndroidNavigationBar(WebDriver driver) {
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
