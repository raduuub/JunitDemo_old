package tests.Test;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Invatam {

    public static void setupChromeDriver() {
        String OS = System.getProperty("os.name").toLowerCase();
        char osStringSeparator = File.separatorChar;


        if (OS.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "src" + osStringSeparator + "test" + osStringSeparator + "resources" + osStringSeparator + "drivers" + osStringSeparator + "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "src" + osStringSeparator + "test" + osStringSeparator + "resources" + osStringSeparator + "drivers" + osStringSeparator + "chromedriver");
        }
    }
    public static void main(String[] args) throws InterruptedException, AWTException {
        //setup
        WebDriver driver;
        setupChromeDriver();
        driver = new ChromeDriver();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //ne jucam

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a")).click();
        WebElement title = driver.findElement(By.cssSelector("#content > div > h3"));
        if(title.getText().contains("Test Variation 1")){
            System.out.println("Correct");
        }else{
            System.out.println("Fail");
        }
        Assertions.assertTrue(title.getText().contains("Test Variation 2"),"Nu a aparut ce trebuie");
        System.out.println(title.getText());
        sleep(5000);
        driver.close();
    }
}