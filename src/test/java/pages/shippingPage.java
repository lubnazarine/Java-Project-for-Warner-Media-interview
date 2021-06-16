package pages;

import Utilities.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class shippingPage extends TestBase {

    @FindBy(how= How.XPATH, using ="//*[contains(@class,'step_current')]/span")
    WebElement currentStep;

    @FindBy(how= How.XPATH, using ="//*[contains(@type,'checkbox')]")
    WebElement termsCheckbox;

    @FindBy(how= How.XPATH, using ="//*[contains(text(),'Proceed to checkout')]")
    List<WebElement> proceedToCheckoutButton;

    WebDriver driver;
    public shippingPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyThatUserIsOnShippingPage(){
        Assert.assertEquals(driver.getTitle(),"Order - My Store");
        Assert.assertEquals(currentStep.getText(),"04. Shipping");
    }

    public void shippingCheckout() {
        scroll(termsCheckbox);
        termsCheckbox.click();
        proceedToCheckoutButton.get(1).click();
    }
}
