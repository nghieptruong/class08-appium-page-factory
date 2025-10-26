package pages.components;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class NavigationBar extends BasePage {

    @AndroidFindBy(accessibility = "View menu")
    public WebElement mainMenu;

    @AndroidFindBy(accessibility = "Login Menu Item")
    public WebElement loginMenuItem;

    @AndroidFindBy(accessibility = "Logout Menu Item")
    public WebElement logoutMenuItem;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void openMainMenu() {
        click(mainMenu);
    }

    public void openLoginPage() {
        click(loginMenuItem);
    }

    public void openMenuItem(String item) {

    }

    public boolean isLogoutMenuItemDisplayed() {
        return logoutMenuItem.isDisplayed();
    }
}
