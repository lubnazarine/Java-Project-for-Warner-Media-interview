
package stepDefinitions;

import Utilities.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;
import pages.loginPage;
import pages.logoutPage;

public class loginStepDefinition extends TestBase{

    static loginPage login;
    static logoutPage logout;

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Given("user opens browser and enters url and lands on homepage")
    public void user_opens_browser_and_enters_url_and_lands_on_homepage() throws InterruptedException {
        TestBase.initialize();

    }
    @When("user clicks on sign in")
    public void user_clicks_on_sign_in() throws InterruptedException {
        login = new loginPage(driver);
        login.clickSignIn();

    }
    @Then("verify user land on login screen")
    public void verify_user_land_on_login_screen() throws InterruptedException {
        //loginPage login = new loginPage(driver);
        login.verifySignPage();
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() throws InterruptedException {
        //loginPage login = new loginPage(driver);
        login.enterUsernameAndPassword(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Then("user is able to login successfully")
    public void user_is_able_to_login_successfully() {
        homePage home = new homePage(driver);
        home.verifySignedInAccount();

    }

    @Given("user is already signed in")
    public void user_is_already_signed_in() {
    }

    @When("user clicks on sign out")
    public void user_clicks_on_sign_out() {
        logout = new logoutPage();
        logout.signOut();
    }
    @Then("user is able to sign out successfully")
    public void user_is_able_to_sign_out_successfully() {
        //logoutPage logout = new logoutPage();
        logout.verifyThatUserIsLoggedOut();

    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) throws InterruptedException {
        //loginPage page = new loginPage(driver);
        login.enterUsernameAndPassword(username,password);
    }
    @Then("verify error {string}")
    public void verify_error(String errorMessage) {

    }

}

