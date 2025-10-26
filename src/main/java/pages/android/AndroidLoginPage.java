package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.abstracts.LoginPage;

public class AndroidLoginPage extends LoginPage {

    @AndroidFindBy(id = "nameET")
    private WebElement txtName;

    @AndroidFindBy(id = "passwordET")
    private WebElement txtPassword;

    @AndroidFindBy(id = "loginBtn")
    private WebElement btnLogin;

    public AndroidLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoginPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(txtName));
        return txtName.isDisplayed() && txtPassword.isDisplayed();
    }

    @Override
    public void login(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
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

