package SakanatyAcceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.LoginInfo;
import role.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LogoutSteps {

    LoginInfo loginInfo;

    public LogoutSteps(LoginInfo loginInfo) {
        super();
        this.loginInfo = loginInfo;
    }

    @Given("that the admin is logged in")
    public void that_the_admin_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        loginInfo.login();
        assertTrue(loginInfo.isLoggedIn());
    }
    @Then("the admin logout successfully")
    public void the_admin_logout_successfully() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        loginInfo.logout();
        assertFalse(loginInfo.isLoggedIn());
    }

    @Given("that the owner is logged in")
    public void that_the_owner_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        loginInfo.login();
        assertTrue(loginInfo.isLoggedIn());
    }
    @Then("the owner logout successfully")
    public void the_owner_logout_successfully() {
        // Write code here that turns the phrase above into concrete actions
        loginInfo.logout();
        assertFalse(loginInfo.isLoggedIn());
    }

    @Given("that the tenant is logged in")
    public void that_the_tenant_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        loginInfo.login();
        assertTrue(loginInfo.isLoggedIn());
    }
    @Then("the tenant logout successfully")
    public void the_tenant_logout_successfully() {
        // Write code here that turns the phrase above into concrete actions
        loginInfo.logout();
        assertFalse(loginInfo.isLoggedIn());
    }
}
