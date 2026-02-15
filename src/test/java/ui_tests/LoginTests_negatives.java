package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.PopUpPage;

public class LoginTests_negatives extends AppManager {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void loginNegativeTest_WrongPassword_WOSpecSymbol() {
        User user = User.builder()
                .email("sima_simonova370@gmail.com")
                .password("BSas1244")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("Login or Password incorrect"));
    }

    @Test
    public void loginNegativeTest_WrongEmail_Empty() {
        User user = User.builder()
                .email("sima_simonova370gmail.com")
                .password("")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        softAssert.assertTrue(loginPage.isTextInErrorPresent
                ("It'snot loo like email"), "validate field email");
        System.out.println("wrong text!!");
        softAssert.assertTrue(loginPage.isTextInErrorPresent
                ("Password is required"), "validate field password");
        System.out.println("right text!!");
        softAssert.assertAll();
    }

    @Test
    public void loginNegativeTest_WrongPassword_WithoutDigit() {
        User user = User.builder()
                .email("sima_simonova370@gmail.com")
                .password("BSasssss")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("Login or Password incorrect"));
    }

    @Test
    public void loginNegativeTest_WrongPassword_WithoutSmallEnglishLetter() {
        User user = User.builder()
                .email("sima_simonova370@gmail.com")
                .password("BSASSSS1")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("Login or Password incorrect"));
    }

    @Test
    public void loginNegativeTest_WrongPassword_WithoutBigEnglishLetter() {
        User user = User.builder()
                .email("sima_simonova370@gmail.com")
                .password("bsassss1")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("Login or Password incorrect"));
    }

    @Test
    public void loginNegativeTest_WrongPassword_WithoutSpecialCharacter() {
        User user = User.builder()
                .email("sima_simonova370@gmail.com")
                .password("Bsassss")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("Login or Password incorrect"));
    }

    @Test
    public void loginNegativeTest_WrongPassword_WithoutLenghLessThan8Characters() {
        User user = User.builder()
                .email("sima_simonova370@gmail.com")
                .password("Bsa1")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("Login or Password incorrect"));
    }

    @Test
    public void loginNegativeTest_WrongPassword_WithRussianLetters() {
        User user = User.builder()
                .email("sima_simonova370@gmail.com")
                .password("BsaФФФФ1")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("Login or Password incorrect"));
    }

    @Test
    public void loginNegativeTest_WrongPassword_WithHebrewLetters() {
        User user = User.builder()
                .email("sima_simonova370@gmail.com")
                .password("Bsaלללל1")
                .build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("Login or Password incorrect"));
    }
}
