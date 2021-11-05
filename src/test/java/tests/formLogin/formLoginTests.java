package tests.formLogin;

import Pages.FormLoginPage;
import Pages.SecureAreaPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Pages.HomePage;
import utils.DriverBuilder;
import utils.Helpers;
import java.io.IOException;

import static utils.DriverBuilder.getDriver;

public class formLoginTests{
    protected HomePage homePage;
    @Before
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before each test executes");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(10);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
    }

    @Test
    public void testSuccessfulFormLogin(){
        HomePage homePage = new HomePage(getDriver);
        FormLoginPage formLoginPage = homePage.clickFormAuthentificationPage();
        formLoginPage.setUsername("tomsmith");
        formLoginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = formLoginPage.clickLoginButton();
        Assert.assertTrue("Login not succesful!", secureAreaPage.getAlertText().contains("You logged into a secure area!"));

    }

    @Test
    public void testPasswordInputType(){

    }
    @After
    public void afterMethod() throws IOException {
        DriverBuilder.kill();
    }
}
