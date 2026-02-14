package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.PopUpPage;
import pages.RegistrationPage;

import java.util.Random;

public class RegistrationTests_negatives extends AppManager {
    RegistrationPage registrationPage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void goToRegistrationPage(){
        new HomePage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
    }

    @Test
    public void registrationNegativeTest_WithPopUpPage() {
        User user = User.builder()
                .firstName("Victor")
                .lastName("Victorov")
                .email("sima_simonova370@gmail.com")
                .password("Pqwerty453!")
                .build();
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        registrationPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("User already exists"));
    }

    @Test
    public void registrationNegativeTest_WithSpaceInFirstName() {
        User user = User.builder()
                .firstName(" ")
                .lastName("dtrye")
                .email("victor444@smd.com")
                .password("Password123#")
                .build();
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        registrationPage.clickBtnYalla();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("must not be blank"));
    }

    @Test
    public void registrationNegativeTest_WithSoftAssert() {
        User user = User.builder()
                .firstName("Victor")
                .lastName("Victorov")
                .email("Vic@mail.ru")
                .password("Pqwerty453!")
                .build();
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        registrationPage.clickBtnYalla();
        softAssert.assertTrue(registrationPage.isTextInErrorPresent("Wrong email format"));
        softAssert.assertAll();
    }

    @Test
    public void registrationNegativeTest_WithAllEmptyFields() {
        User user = User.builder()
                .firstName("")
                .lastName("")
                .email("")
                .password("")
                .build();
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBoxWithActions();
        registrationPage.clickBtnYalla();
        softAssert.assertTrue(registrationPage
                .isTextInErrorPresent("Name is required"),
                "validate error message: Name is required");
        softAssert.assertTrue(registrationPage
                        .isTextInErrorPresent("Last name is required"),
                "validate error message: Last name is required");
        softAssert.assertTrue(registrationPage
                        .isTextInErrorPresent("Email is required"),
                "validate error message: Email is required");
        softAssert.assertTrue(registrationPage
                        .isTextInErrorPresent("Password is required"),
                "validate error message: Password is required");
        softAssert.assertAll();
    }
}


