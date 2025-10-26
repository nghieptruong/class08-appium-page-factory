package pages.abstracts;

import org.openqa.selenium.WebDriver;
import pages.CommonPage;

public abstract class CatalogPage extends CommonPage {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageDisplayed();
}
