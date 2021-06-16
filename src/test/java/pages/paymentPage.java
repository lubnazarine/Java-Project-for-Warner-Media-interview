package pages;

import Utilities.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class paymentPage extends TestBase {

    @FindBy(how= How.XPATH, using ="//*[contains(@class,'step_current')]/span")
    WebElement currentStep;

    @FindBy(how= How.XPATH, using ="//*[contains(@title,'Pay by bank wire')]")
    WebElement bankWirePayment;

    @FindBy(how= How.XPATH, using ="//*[contains(@title,'Pay by check')]")
    WebElement checkPayment;

    WebDriver driver;
    public paymentPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyThatUserIsOnPaymentPage(){
        Assert.assertEquals(driver.getTitle(),"Order - My Store");
        Assert.assertEquals(currentStep.getText(),"05. Payment");
    }

    public void payByBankWire(){
        scroll(bankWirePayment);
        bankWirePayment.click();
    }

    public void payByCheck(){
        scroll(checkPayment);
        checkPayment.click();
    }
}
