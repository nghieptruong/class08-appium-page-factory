package pages;

import pages.components.NavigationBar;
import org.openqa.selenium.WebDriver;


public class CommonPage extends BasePage {

    private NavigationBar navigationBar;

    public CommonPage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }

    public NavigationBar getNavigationBar() {
        return this.navigationBar;
    }
}
