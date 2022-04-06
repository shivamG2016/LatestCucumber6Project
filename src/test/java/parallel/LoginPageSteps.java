package parallel;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

   private static String ActualTile;

    private LoginPage loginpage= new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {

        System.out.println(" I am in login page");

        DriverFactory.getDriver().get("https://demo.guru99.com/V4/");

    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        ActualTile =  loginpage.getLoginPageTitle();
        System.out.println(ActualTile);
    }

    @When("user gets the title of the home page")
    public void user_gets_the_title_of_the_home_page() {



    }

    @Then("page title should be {string}")
    public void page_title_should_be(String ExpectedTitleName) {

        System.out.println(".....IN page title step......");

        Assert.assertTrue(ActualTile.trim().contains(ExpectedTitleName.trim()));

    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {

        Assert.assertTrue(loginpage.isResetBtnExist());

    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {

        loginpage.enterUserName(username);

    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
       loginpage.enterPassword(password);
    }

    @When("user enters valid username as {string}")
    public void user_enters_valid_username_as(String uname) {

        System.out.println("in enter username step...");
        loginpage.enterUserName(uname);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginpage.clickONLogin();
    }
}
