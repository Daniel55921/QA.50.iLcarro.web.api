package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.PopUpPage;
import utils.RetryAnalyzer;
import static utils.PropertiesReader.*;

public class LoginTests_positives extends AppManager {
    SoftAssert softAssert = new SoftAssert();

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginPositiveTest() {
        User user = User.builder()
                .email(getProperty("base.properties","login"))
                .password(getProperty("base.properties","password"))
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(loginPage.isLoggedInDisplayed());
    }

    @Test
    public void loginPositiveTest_WithPopUpPage() {
        User user = User.builder()
                .email(getProperty("base.properties","login"))
                .password(getProperty("base.properties","password"))
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("Logged in success"));
    }
}

