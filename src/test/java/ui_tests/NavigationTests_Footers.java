package ui_tests;

import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.enums.FooterMenuItem;

public class NavigationTests_Footers extends AppManager {
    @Test
    public void iconFacebookNavigationTest(){
        Assert.assertTrue(new HomePage(getDriver()).clickIconFooter
                (FooterMenuItem.ICON_FACEBOOK,"Facebook"));
    }

    @Test
    public void iconTelegramNavigationTest(){
        Assert.assertTrue(new HomePage(getDriver()).clickIconFooter
                (FooterMenuItem.ICON_TELEGRAM,"Telegram"));
    }

    @Test
    public void iconVKNavigationTest(){
        Assert.assertTrue(new HomePage(getDriver()).clickIconFooter
                (FooterMenuItem.ICON_VK,"VK"));
    }

    @Test
    public void iconInstagramNavigationTest(){
        Assert.assertTrue(new HomePage(getDriver()).clickIconFooter
                (FooterMenuItem.ICON_INSTAGRAM,"Instagram"));
    }

    @Test
    public void iconSlackNavigationTest(){
        Assert.assertTrue(new HomePage(getDriver()).clickIconFooter
                (FooterMenuItem.ICON_SLACK,"Slack"));
    }
}
