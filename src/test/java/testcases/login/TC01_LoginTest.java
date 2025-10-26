package testcases.login;

import base.BaseTest;
import drivers.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.LoginPage;
import reports.ExtentReportManager;

public class TC01_LoginTest extends BaseTest {

    @Test
    public void TC01_Verify_Valid_Login() {

        LoginPage loginPage = new LoginPage(DriverManager.getCurrentDriver());
        CatalogPage catalogPage = new CatalogPage(DriverManager.getCurrentDriver());

        ExtentReportManager.info("Start TC01_Verify_Valid_Login");

        final String username = "bod@example.com";
        final String password = "10203040";

        //Step 1: Go to login page
        logger.info("Step 1: Go to login page");
        ExtentReportManager.info("Step 1: Go to login page");
        catalogPage.getNavigationBar().openMainMenu();
        catalogPage.getNavigationBar().openLoginPage();

        //Step 2: Enter username
        //Step 3: Enter password
        //Step 4: Click "Login" button
        logger.info("Step 2: Enter username");
        logger.info("Step 3: Enter password");
        logger.info("Step 4: Click 'Login' button");
        ExtentReportManager.info("Step 2: Enter username");
        ExtentReportManager.info("Step 3: Enter password");
        ExtentReportManager.info("Step 4: Click 'Login' button");

        loginPage.login(username, password);

        //Step 5: Verify that the user logged in successfully
        logger.info("Step 5: Verify that the user logged in successfully");
        logger.info("VP1: Catalog page displays");
        ExtentReportManager.info("Step 5: Verify that the user logged in successfully");
        ExtentReportManager.info("VP1: Catalog page displays");
        Assert.assertTrue(catalogPage.isPageDisplayed());

        logger.info("VP2: Logout menu item displays");
        ExtentReportManager.info("VP2: Logout menu item displays");
        catalogPage.getNavigationBar().openMainMenu();
        Assert.assertTrue(catalogPage.getNavigationBar().isLogoutMenuItemDisplayed());

        ExtentReportManager.pass("PASSED");
    }
}
