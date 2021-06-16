package pages;

import Utilities.TestBase;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class womenPage extends TestBase {

    @FindBy(how= How.XPATH, using ="//img[contains(@title,'Faded')]")
    WebElement itemFadedShorts;

    @FindBy(how= How.XPATH, using ="//*[contains(@class,'color_to_pick')]/li/a")
    WebElement selectColor;

    @FindBy(how= How.XPATH, using ="//*[contains(text(),'Add to cart')]")
    WebElement addToCartButton;


    WebDriver driver;
    public womenPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyThatUserIsOnWomenPage(){
        Assert.assertEquals(driver.getTitle(),"Women - My Store");
    }

    public void addItem() throws InterruptedException {
        scroll(itemFadedShorts);
        mouseHover(itemFadedShorts);
        Thread.sleep(2000);
        selectColor.click();
        Thread.sleep(2000);
        addToCartButton.click();
    }
}
