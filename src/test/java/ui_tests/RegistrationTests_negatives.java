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

    @BeforeMethod
    public void goToRegistrationPage(){
        new HomePage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
    }

    @Test
    public void registrationNegativeTest_WithPopUpPage() {
        int i = new Random().nextInt(1000);
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
    public void registrationNegativeTest_WithSoftAssert() {
        SoftAssert softAssert = new SoftAssert();
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
}


