package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @AndroidFindBy(id = "nameET")
    private WebElement txtName;

    @AndroidFindBy(id = "passwordET")
    private WebElement txtPassword;

    @AndroidFindBy(id = "loginBtn")
    private WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(txtName));
        return txtName.isDisplayed() && txtPassword.isDisplayed();
    }

    public void login(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLogin();
    }

    public void enterUserName(String userName) {
        sendKeys(txtName, userName);
    }

    public void enterPassword(String password) {
        sendKeys(txtPassword, password);
    }

    public void clickLogin() {
        click(btnLogin);
    }
}

