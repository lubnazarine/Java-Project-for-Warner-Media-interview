package pages;

import Utilities.TestBase;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class fadedShortsPage extends TestBase {

    @FindBy(how= How.XPATH, using ="//*[contains(text(),'Add to cart')]")
    WebElement addToCartButton;

    @FindBy(how= How.XPATH, using ="//*[(@class='clearfix')]/div/div[2]/span")
    //@CacheLookup
    List<WebElement> productDetails;

    @FindBy(how= How.XPATH, using ="//*[contains(@title,'Proceed to checkout')]")
    WebElement proceedToCheckoutButton;

    WebDriver driver;
    public fadedShortsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyThatUserIsOnFadedShortsPage()  {
        System.out.println("Title of page is  : "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Faded Short Sleeve T-shirts - My Store");
    }

    public void addItemAndCheckout() throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(7000);
        System.out.println(productDetails.get(0).getText());
        System.out.println(productDetails.get(1).getText());
        //Assert.assertEquals(productDetails.get(0).getText(),"Faded Short Sleeve T-shirts");
        //Assert.assertEquals(productDetails.get(1).getText(),"Orange, S");
        proceedToCheckoutButton.click();
    }
}
