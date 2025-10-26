package pages.ios;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.abstracts.LoginPage;

public class IOSLoginPage extends LoginPage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private WebElement txtName;

    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeSecureTextField\"")
    private WebElement txtPassword;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Login\" AND label == \"Login\" AND type == \"XCUIElementTypeButton\"")
    private WebElement btnLogin;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"bob@example.com\"]")
    private WebElement lnkAccount;

    public IOSLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoginPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(txtName));
        return txtName.isDisplayed() && txtPassword.isDisplayed();
    }

    @Override
    public void login(String userName, String password) {
//        enterUserName(userName);
//        enterPassword(password);
//        clickLogin();

        //BUG: Keyboard covers login button
        //BUG: Enter keyboard does not work
        //Workaround step (de step ko bi blocked)
        click(lnkAccount);
        clickLogin();
    }

    @Override
    public void enterUserName(String userName) {
        sendKeys(txtName, userName);
    }

    @Override
    public void enterPassword(String password) {
        sendKeys(txtPassword, password);
    }

    @Override
    public void clickLogin() {
        click(btnLogin);
    }
}
