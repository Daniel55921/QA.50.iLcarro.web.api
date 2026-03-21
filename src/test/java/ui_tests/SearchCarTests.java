package ui_tests;

import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.LocalDate;

public class SearchCarTests extends AppManager {
    HomePage homePage;
    @BeforeMethod
    public void openHomePage(){
        homePage = new HomePage(getDriver());
    }

    @Test
    public void searchCarPositiveTest(){
        String city = "Rehovot";
        LocalDate startDate = LocalDate.of(2026,3,21);
        LocalDate endDate = LocalDate.of(2026,3,22);
        homePage.typeSearchForm(city, startDate, endDate);
    }
}
