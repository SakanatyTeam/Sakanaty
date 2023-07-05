package SakanatyAcceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.LoginInfo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ViewHousingSteps {

    LoginInfo loginInfo;
    public ViewHousingSteps(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    @Given("that the tenant is logged in")
    public void that_the_tenant_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
//        assertTrue(loginInfo.tenantIsLogged);
        loginInfo.login();
        assertTrue(loginInfo.isLoggedIn());   // ???????????????????????????????????????????????
    }

    @Then("display all information about available housing found")
    public void display_all_information_about_available_housing_found() {
        // Write code here that turns the phrase above into concrete actions
        loginInfo.showHousing();
    }

}
