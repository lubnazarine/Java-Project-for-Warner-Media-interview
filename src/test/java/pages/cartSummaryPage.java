package pages;

import Utilities.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class cartSummaryPage extends TestBase {

    @FindBy(how= How.XPATH, using ="//*[contains(@class,'step_current')]/span")
    WebElement currentStep;

    @FindBy(how= How.XPATH, using ="//*[text()='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    WebDriver driver;
    public cartSummaryPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyThatUserIsOnCartSummaryPage(){

        Assert.assertEquals(driver.getTitle(),"Order - My Store");
        Assert.assertEquals(currentStep.getText(),"01. Summary");
    }

    public void summaryCheckout(){
        scroll(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }
}
