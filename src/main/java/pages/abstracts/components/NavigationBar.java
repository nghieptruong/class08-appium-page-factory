package pages.abstracts.components;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public abstract class NavigationBar extends BasePage {

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public abstract void openMainMenu();

    public abstract void openLoginPage();

    public abstract void openMenuItem(String item);

    public abstract boolean isLogoutMenuItemDisplayed();
}
