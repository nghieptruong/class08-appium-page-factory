package pages;

import pages.abstracts.components.NavigationBar;
import org.openqa.selenium.WebDriver;
import pages.factories.PageManagerFactory;


public class CommonPage extends BasePage {

    private NavigationBar navigationBar;

    public CommonPage(WebDriver driver) {
        super(driver);
        this.navigationBar = PageManagerFactory.getNavigationBar();
    }

    public NavigationBar getNavigationBar() {
        return this.navigationBar;
    }
}
