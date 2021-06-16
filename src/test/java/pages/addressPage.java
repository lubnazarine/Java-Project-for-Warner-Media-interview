package pages;

import Utilities.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class addressPage extends TestBase {

    @FindBy(how= How.XPATH, using ="//*[contains(@class,'step_current')]/span")
    WebElement currentStep;

    @FindBy(how= How.XPATH, using ="//*[(@name='message')]")
    WebElement message;

    @FindBy(how= How.XPATH, using ="//*[text()='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    WebDriver driver;
    public addressPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyThatUserIsOnAddressPage(){
        Assert.assertEquals(driver.getTitle(),"Order - My Store");
        Assert.assertEquals(currentStep.getText(),"03. Address");
    }

    public void addressCheckout(){
        scroll(proceedToCheckoutButton);
        message.sendKeys("testing message 123");
        proceedToCheckoutButton.click();
    }
}
