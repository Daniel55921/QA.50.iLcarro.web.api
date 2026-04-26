package ui_tests;

import manager.AppManager;
import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.enums.HeaderMenuItem;
import static utils.PropertiesReader.getProperty;

public class NavigationTests_Headers extends AppManager {
        HomePage homePage;

        @BeforeMethod
        public void ensureHomePage() {
            homePage = new HomePage(getDriver());
        }

        @Test
        public void searchNavigationTest() {
            Assert.assertTrue(homePage.clickHeaderItemAndCheckURL(HeaderMenuItem.SEARCH, "/search"));
        }

        @Test
        public void termsOfUseNavigationTest() {
            Assert.assertTrue(homePage.clickHeaderItemAndCheckURL(HeaderMenuItem.TERMS_OF_USE, "/terms"));
        }

        @Test
        public void authUserHeaderTests() {
            User user = User.builder()
                    .email(getProperty("base.properties","login"))
                    .password(getProperty("base.properties","password"))
                    .build();

            LoginPage loginPage = homePage.clickButtonHeader(HeaderMenuItem.LOGIN);
            loginPage.typeLoginForm(user);
            loginPage.clickBtnYalla();
            loginPage.clickBtnOk();

            Assert.assertTrue(homePage.clickHeaderItemAndCheckURL(HeaderMenuItem.LET_THE_CAR_WORK, "/let-car-work"));


            homePage.clickButtonHeader(HeaderMenuItem.LOGOUT);
            Assert.assertTrue(homePage.isHeaderMenuItemPresent(HeaderMenuItem.LOGIN));
        }
    }
