package pages;

import Utilities.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class orderSummaryPage extends TestBase {

    @FindBy(how= How.XPATH, using ="//*[contains(@class,'step_current')]/span")
    WebElement currentStep;

    @FindBy(how= How.XPATH, using ="//*[text()='I confirm my order']")
    WebElement confirmOrderButton;

    WebDriver driver;
    public orderSummaryPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyThatUserIsOnOrderSummaryPage(){
        Assert.assertEquals(driver.getTitle(),"Order");
        Assert.assertEquals(currentStep.getText(),"05. Payment");
    }

    public void orderSummary(){
        scroll(confirmOrderButton);
        confirmOrderButton.click();
    }
}
