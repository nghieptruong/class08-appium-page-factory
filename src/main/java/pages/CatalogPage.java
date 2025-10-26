package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage extends CommonPage {

    @AndroidFindBy(accessibility = "title")
    public WebElement lblTitle;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageDisplayed() {
        return getText(lblTitle).equals("Products");
    }

}
