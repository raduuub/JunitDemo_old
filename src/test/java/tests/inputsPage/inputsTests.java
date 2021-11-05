package tests.inputsPage;

import Pages.InputsPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Pages.HomePage;
import utils.DriverBuilder;
import utils.Helpers;
import java.io.IOException;

import static java.lang.Thread.sleep;
import static utils.DriverBuilder.getDriver;

public class inputsTests {
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
    public void testOnlyNumbersCanBeWritten() throws InterruptedException {
        homePage = new HomePage(getDriver);
        InputsPage inputsPage = homePage.clickInputsPage();
        inputsPage.setNumber("!412sC6");
        sleep(1000);
        Assert.assertTrue("Not only numbers can be sent",inputsPage.getNumber()
                .equals("4126"));
    }

    @Test
    public void testNumberIncrementationStep() throws InterruptedException {
        homePage = new HomePage(getDriver);
        InputsPage inputsPage = homePage.clickInputsPage();
        inputsPage.setNumber("12");
        inputsPage.increaseNumber();
        Assert.assertTrue("Increment method is not working!", inputsPage.getNumber().equals("13"));
    }


    @Test
    public void testNumberDecrementationStep() throws InterruptedException {
        homePage = new HomePage(getDriver);
        InputsPage inputsPage = homePage.clickInputsPage();
        inputsPage.setNumber("12");
        inputsPage.decreaseNumber();
        Assert.assertEquals("Decrease method is not working!","11", inputsPage.getNumber());
    }

    @Test
    public void testPasswordInputType(){
    }


    
    @After
    public void afterMethod() throws IOException {
        DriverBuilder.kill();
    }
}
