package pages;

import Utilities.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends TestBase {

    @FindBy(how=How.XPATH, using ="//*[contains(text(),'Sign in')]")
    WebElement signIn;

    @FindBy(how=How.XPATH, using ="//*[@id='email']")
    WebElement username;

    @FindBy(how=How.XPATH, using ="//*[contains(@id,'passwd')]")
    WebElement password;

    @FindBy(how=How.XPATH, using ="//button[contains(@id,'SubmitLogin')]")
    WebElement signInButton;

    @FindBy(how=How.XPATH, using ="//*[contains(text(),'Authentication')]/following-sibling::div/ol/li")
    WebElement error;

    WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickSignIn(){
        Assert.assertEquals(signIn.getText(),"Sign in");
        signIn.click();
    }

    public void verifySignPage() throws InterruptedException {
        System.out.println("URL : " + driver.getCurrentUrl());
        if (!driver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=authentication&back=my-account")) {
            throw new IllegalStateException("Incorrect landing page, expected url : http://automationpractice.com/index.php?controller=authentication&back=my-account actual url : " + driver.getCurrentUrl());
        }
        System.out.println("Page Title : " + driver.getTitle());
        if (!driver.getTitle().contains("Login - My Store")) {
            throw new IllegalStateException("Incorrect landing page, expected Title : Login - My Store count actual title : " + driver.getTitle());
        }

    }

    public void enterUsernameAndPassword(String user, String pwd) throws InterruptedException {

        Thread.sleep(3000);
        username.sendKeys(user);
        password.sendKeys(pwd);
        signInButton.click();
    }

    public void verifyErrorMessage(String errorMsg){
        Assert.assertEquals(errorMsg,error.getText());
    }

}
