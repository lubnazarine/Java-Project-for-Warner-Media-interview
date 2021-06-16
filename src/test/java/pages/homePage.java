package pages;

import Utilities.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class homePage extends TestBase {

    @FindBy(how= How.XPATH, using ="//*[contains(@title,'View my customer account')]/span")
    WebElement signedInAccountName;
    @FindBy(how= How.XPATH, using ="//*[text()='Women']")
    WebElement womenTab;

    public homePage(WebDriver driver) {
        PageFactory.initElements(TestBase.driver, this);
    }

    public void verifySignedInAccount(){
        Assert.assertEquals(signedInAccountName.getText(),prop.getProperty("user"));
    }

    public void clickOnWomen(){
        womenTab.click();
    }
}
