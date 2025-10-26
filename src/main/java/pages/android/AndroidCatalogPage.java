package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.CatalogPage;

public class AndroidCatalogPage extends CatalogPage {

    @AndroidFindBy(accessibility = "title")
    public WebElement lblTitle;

    public AndroidCatalogPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageDisplayed() {
        return getText(lblTitle).equals("Products");
    }

}
