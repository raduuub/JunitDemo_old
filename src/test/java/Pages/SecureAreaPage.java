package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.DriverBuilder.getDriver;

public class SecureAreaPage {
    private By statusAlert = By.id("flash");

    public SecureAreaPage() {
    }

    public String getAlertText(){
        return getDriver.findElement(statusAlert).getText();
    }
}
