package pages.ios;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.CatalogPage;

public class IOSCatalogPage extends CatalogPage {

    @iOSXCUITFindBy(accessibility = "title")
    public WebElement lblTitle;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == \"Product Image\"`][1]")
    public WebElement imgFirstProduct;

    public IOSCatalogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageDisplayed() {
        return imgFirstProduct.isDisplayed();
    }
}
