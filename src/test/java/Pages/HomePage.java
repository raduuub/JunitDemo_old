package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.DriverBuilder.getDriver;

public class HomePage {


    public HomePage(WebDriver getDriver) {
    }



    public InputsPage clickInputsPage() {
        clickLink("Inputs");
        return new InputsPage();
    }

    public FormLoginPage clickFormAuthentificationPage() {
        clickLink("Form Authentication");
        return new FormLoginPage();
    }

    public static WebElement searchField() {
        return getDriver.findElement(By.cssSelector("input[title='Search']"));
    }

    public static java.util.List<WebElement> results() {
        return getDriver.findElements(By.cssSelector("div.rc h3"));
    }


    private void clickLink(String linkText) {
        getDriver.findElement(By.linkText(linkText)).click();
    }

}