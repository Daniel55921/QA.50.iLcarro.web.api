package ui_tests;

import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.LocalDate;

public class SearchCarTests_positives extends AppManager {
    HomePage homePage;
    @BeforeMethod
    public void openHomePage(){
        homePage = new HomePage(getDriver());
    }

    @Test
    public void searchCarPositiveTest(){
        String city = "Rehovot";
        LocalDate startDate = LocalDate.of(2026,3,23);
        LocalDate endDate = LocalDate.of(2026,3,28);
        homePage.typeSearchForm(city, startDate, endDate);
        homePage.clickBtnYalla();
        Assert.assertTrue(homePage.urlContains
                ("results", 5));
    }

    @Test
    public void searchCarPositiveTestWithCalendar(){
        String city = "Rehovot";
        LocalDate startDate = LocalDate.of(2026,3,23);
        LocalDate endDate = LocalDate.of(2026,3,28);
        homePage.typeSearchFormWithCalendar(city, startDate, endDate);
        //homePage.clickBtnYalla();
        //Assert.assertTrue(homePage.urlContains
        //       ("results", 5));
    }
}
