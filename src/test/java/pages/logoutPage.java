package pages;

import Utilities.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class logoutPage extends TestBase {

    @FindBy(how= How.XPATH, using ="//*[contains(text(),'Sign out') and contains(@title,'Log me out')]")
    WebElement signOut;

    @FindBy(how=How.XPATH, using ="//*[contains(text(),'Sign in')]")
    WebElement signIn;

    public logoutPage() {
        PageFactory.initElements(TestBase.driver, this);
    }

    public void signOut(){
        signOut.click();
    }

    public void verifyThatUserIsLoggedOut() {
        Assert.assertEquals(signIn.getText(),"Sign in");
    }
}
