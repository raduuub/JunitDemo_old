package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.DriverBuilder.getDriver;

public class FormLoginPage {
    private By usernameFild = By.id("username");
    private By passwordFild = By.id("password");
    private By loginButton = By.cssSelector("#login > button");

    public FormLoginPage() {
    }

    public void setUsername(String username) {
        getDriver.findElement(usernameFild).sendKeys(username);
    }

    public void setPassword(String password) {
        getDriver.findElement(passwordFild).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton(){
        getDriver.findElement(loginButton).click();
        return new SecureAreaPage();
    }

}
