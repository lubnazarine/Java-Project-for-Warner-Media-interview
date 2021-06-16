package pages;

import Utilities.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class orderConfirmationPage extends TestBase {

    @FindBy(how= How.XPATH, using ="//*[contains(@class,'step_current')]/span")
    WebElement currentStep;

    @FindBy(how= How.XPATH, using ="//*[text()='Back to orders']")
    WebElement backToOrdersButton;

    WebDriver driver;
    public orderConfirmationPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyThatUserIsOnOrderConfirmationPage(){
        Assert.assertEquals(driver.getTitle(),"Order confirmation - My Store");
        Assert.assertEquals(currentStep.getText(),"05. Payment");
    }

    public void confirmOrder(){
        scroll(backToOrdersButton);
        backToOrdersButton.click();
    }
}
