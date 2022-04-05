package stepdefinitions;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class HomePageSteps {


    private LoginPage loginpage= new LoginPage(DriverFactory.getDriver());
    private HomePage hp;

    @Given("user has already loggedIn in to application")
    public void user_has_already_logged_in_in_to_application(DataTable dataTable) {

        System.out.println("...in login application step....");
     List<Map<String , String>> credList =dataTable.asMaps();
       String username= credList.get(0).get("usernmae");
        String password= credList.get(0).get("password");
        hp= loginpage.doLogin(username,password);
    }

    @Given("user is on home page")
    public void user_is_on_home_page() {
        System.out.println(" at login page");

        // Verification that user should be on the home page

        hp.getHomePagetitle();

    }

    @Then("page tile should be {string}")
    public void page_tile_should_be(String ExpectedTitle) {

        // Verification of page title

        Assert.assertEquals(hp.getHomePagetitle().trim(),ExpectedTitle.trim());
    }

    @Then("user get home page section list")
    public void user_get_home_page_section(DataTable leftPannelList) {

        System.out.println("In page section step ..");
     List<String> ExpectedList =  leftPannelList.asList();
        System.out.println("Expected left pannel list"+ExpectedList);
        List<String> AcctualList= hp.getLeftPannelList();
        System.out.println("Actual left pannel list"+AcctualList);

        Assert.assertTrue(ExpectedList.containsAll(AcctualList));
    }

    @Then("section count should be {int}")
    public void section_count_should_be(Integer int1) {
        Integer ActualCount=  hp.getDifferentTabCount();
        Assert.assertEquals(ActualCount,int1);
    }
}
