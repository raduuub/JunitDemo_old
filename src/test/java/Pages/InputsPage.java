package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.DriverBuilder.getDriver;

public class InputsPage {
    private By numberField = By.cssSelector("#content > div > div > div > input[type=number]");

    public InputsPage(){
    }

    public void setNumber(String number){
        getDriver.findElement(numberField).sendKeys(number);
    }

    public String getNumber(){
       return getDriver.findElement(numberField).getAttribute("value");

    }

    public void increaseNumber(){
        getDriver.findElement(numberField).sendKeys(Keys.UP);
    }


    public void decreaseNumber(){
        getDriver.findElement(numberField).sendKeys(Keys.DOWN);
    }

    public String getInputType(String id){
        return getDriver.findElement(By.id(id)).getAttribute("type");

    }

}
