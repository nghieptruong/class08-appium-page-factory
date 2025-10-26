package pages.abstracts;

import org.openqa.selenium.WebDriver;
import pages.CommonPage;

public abstract class LoginPage extends CommonPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLoginPageDisplayed();

    public abstract void login(String userName, String password);

    public abstract void enterUserName(String userName);

    public abstract void enterPassword(String password);

    public abstract void clickLogin();
}
