package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.PropertiesReader;

import java.time.LocalDate;

import static utils.PropertiesReader.*;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
        setDriver(driver);
        driver.get(PropertiesReader.getProperty("base.properties","baseUrl"));
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy(xpath = "//a[text() ='Log in']")
    WebElement btnLogin;
    @FindBy(xpath = "//a[text() ='Sign up']")
    WebElement btnSignUp;
    @FindBy(id = "city")
    WebElement inputCity;
    @FindBy(id = "dates")
    WebElement inputDates;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;

    public void clickBtnLogin(){
        btnLogin.click();
    }

    public void clickBtnSignUp(){
        btnSignUp.click();
    }

    public void typeSearchForm(String city,
                               LocalDate startDate, LocalDate endDate) {
        inputCity.sendKeys(city);
        System.out.println(startDate.toString());
        String dates = startDate.getMonthValue()+"/"
                + startDate.getDayOfMonth()+"/"
                + startDate.getYear()+" - "
                + endDate.getMonthValue()+"/"
                + endDate.getDayOfMonth()+"/"
                + endDate.getYear();
        inputDates.sendKeys(dates);
        btnYalla.click();
    }
}
