package Utilities;

import io.cucumber.java.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {

        try{
            prop = new Properties();
            FileInputStream fileInputStream = new FileInputStream(
                    "/Users/riyaz/IdeaProjects/Practice/src/test/java/config.properties");
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void initialize() throws InterruptedException {
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
            driver = new ChromeDriver();
        }
        else
            System.out.println("Please add browser = 'chrome' to config.properties file");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
    }

    public void scroll(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void mouseHover(WebElement element){
        ((JavascriptExecutor)driver).executeScript("var mouseEvent = document.createEvent('MouseEvents');mouseEvent.initEvent('mouseover', true, true); arguments[0].dispatchEvent(mouseEvent);", element);
    }

}
