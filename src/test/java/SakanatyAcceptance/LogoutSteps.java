package SakanatyAcceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.LoginInfo;
import role.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LogoutSteps {

    LoginInfo loginInfo;

    public LogoutSteps(LoginInfo loginInfo) { this.loginInfo = loginInfo;}

    @Given("that the user is logged in")
    public void that_the_user_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        loginInfo.login();
        assertTrue(loginInfo.isLoggedIn());
    }
    @Then("the user logout successfully")
    public void the_user_logout_successfully() {
        // Write code here that turns the phrase above into concrete actions
        loginInfo.logout();
        assertFalse(loginInfo.isLoggedIn());
    }

}
