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
//        loginInfo.adminIsLogged = true;
        assertTrue(loginInfo.adminIsLogged);
    }
    @Then("the admin logout successfully")
    public void the_admin_logout_successfully() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        assertFalse(loginInfo.adminIsLogged);
    }

    @Given("that the owner is logged in")
    public void that_the_owner_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
//        loginInfo.ownerIsLogged = true;
        assertTrue(loginInfo.ownerIsLogged);
    }
    @Then("the owner logout successfully")
    public void the_owner_logout_successfully() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        assertFalse(loginInfo.ownerIsLogged);
    }

    @Given("that the tenant is logged in")
    public void that_the_tenant_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
//        loginInfo.tenantIsLogged = true;
        assertTrue(loginInfo.tenantIsLogged);
    }
    @Then("the tenant logout successfully")
    public void the_tenant_logout_successfully() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        assertFalse(loginInfo.tenantIsLogged);
    }
}
