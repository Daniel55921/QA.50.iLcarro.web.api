package ui_tests;

import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utils.TestNGListener;

import java.time.LocalDate;
@Listeners(TestNGListener.class)

public class SearchCarTests_negatives extends AppManager {
    SoftAssert softAssert = new SoftAssert();
    HomePage homePage;

    @BeforeMethod
    public void openHomePage() {
        homePage = new HomePage(getDriver());
    }

    @Test(expectedExceptions = org.openqa.selenium.
            TimeoutException.class)
    public void searchCarNegativeTest_EmptyFieldCity() {
        String city = "";
        LocalDate startDate = LocalDate.of(2026, 3, 23);
        LocalDate endDate = LocalDate.of(2026, 3, 28);
        homePage.typeSearchFormWOJS(city, startDate, endDate);
        homePage.clickBtnYalla();
    }

    @Test
    public void searchCarNegativeTest_EmptyFieldCityValidateError() {
        String city = "";
        LocalDate startDate = LocalDate.of(2026, 3, 23);
        LocalDate endDate = LocalDate.of(2026, 3, 28);
        homePage.typeSearchFormWOJS(city, startDate, endDate);
        Assert.assertTrue(homePage
                .isTextInErrorPresent("City is required"));
    }

    @Test
    public void searchCarNegativeTest_EqualData() {
        String city = "Rehovot";
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now();
        homePage.typeSearchForm(city, startDate, endDate);
        homePage.clickBtnYalla();
        softAssert.assertTrue(homePage
                .isTextInErrorPresent("You can't book car for less than a day"),"You can't book car for less than a day");
    }

    @Test
    public void searchCarNegativeTest_WrongFirstData() {
        String city = "Rehovot";
        LocalDate startDate = LocalDate.now().minusDays(1);
        LocalDate endDate = LocalDate.now();
        homePage.typeSearchForm(city, startDate, endDate);
        homePage.clickBtnYalla();
        softAssert.assertTrue(homePage
                .isTextInErrorPresent("You can't pick date before today"),"You can't pick date before today");
        softAssert.assertTrue(homePage
                .isTextInErrorPresent("You can't book car for less than a day"),"You can't book car for less than a day");
    }

    @Test
    public void searchCarNegativeTest_WrongSecondData() {
        String city = "Rehovot";
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().minusDays(2);
        homePage.typeSearchForm(city, startDate, endDate);
        homePage.clickBtnYalla();
        softAssert.assertTrue(homePage
                .isTextInErrorPresent("You can't pick date before today"),"You can't pick date before today");
        softAssert.assertTrue(homePage
                .isTextInErrorPresent("Second date must be after first date"),"Second date must be after first date");
        softAssert.assertTrue(homePage
                .isTextInErrorPresent("You can't book car for less than a day"),"You can't book car for less than a day");
    }

    @Test
    public void searchCarNegativeTest_StartDate_AfterEndDate() {
        String city = "Rehovot";
        LocalDate startDate = LocalDate.now().plusDays(10);
        LocalDate endDate = LocalDate.now().plusDays(8);
        homePage.typeSearchForm(city, startDate, endDate);
        homePage.clickBtnYalla();
        softAssert.assertTrue(homePage
                .isTextInErrorPresent("Second date must be after first date"),"Second date must be after first date");
        softAssert.assertTrue(homePage
                .isTextInErrorPresent("You can't book car for less than a day"),"You can't book car for less than a day");
    }

    @Test(expectedExceptions = java.time.DateTimeException.class)
    public void searchCarNegativeTest_DateNotValid() {
        String city = "Rehovot";
        LocalDate startDate = LocalDate.of(2026,2,30);
        LocalDate endDate = LocalDate.of(2026,3,28);
        homePage.typeSearchForm(city, startDate, endDate);
        homePage.clickBtnYalla();
    }


}