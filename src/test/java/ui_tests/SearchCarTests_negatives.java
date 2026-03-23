package ui_tests;

import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.LocalDate;

public class SearchCarTests_negatives extends AppManager {
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
    public void searchCarNegativeTest_FirstDataBiggerSecondData() {
        String city = "Rehovot";
        LocalDate startDate = LocalDate.of(2026, 3, 27);
        LocalDate endDate = LocalDate.of(2026, 3, 25);
        homePage.typeSearchFormWOJS(city, startDate, endDate);
        Assert.assertTrue(homePage.isTextInErrorPresent("Second date must be after first date"));
        Assert.assertTrue(homePage.isTextInErrorPresent("You can't book car for less than a day"));
    }
}