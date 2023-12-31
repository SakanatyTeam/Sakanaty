package SakanatyAcceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.LoginInfo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class LoginSteps {
    private String username;
    private String password;
    private String type;
    LoginInfo loginInfo;

    public LoginSteps(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    @Given("that the admin is not logged in")
    public void that_the_admin_is_not_logged_in() {
        // Write code here that turns the phrase above into concrete actions
       assertFalse(loginInfo.isAdminIsLogged());
    }

    @Given("the username is {string}")
    public void the_username_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.username=string;
    }

    @Given("the password is {string}")
    public void the_password_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        this.password=string;
    }

    @Then("the admin logs in successfully")
    public void the_admin_logs_in_successfully() {
        // Write code here that turns the phrase above into concrete actions
        loginInfo.checkAuth(this.username, this.password);
        assertTrue(loginInfo.isAdminIsLogged());

    }

    @Given("that the owner is not logged in")
    public void that_the_owner_is_not_logged_in() {
        // Write code here that turns the phrase above into concrete actions
       assertFalse(loginInfo.isOwnerIsLogged());
    }

    @Then("the Owner logs in successfully")
    public void the_owner_logs_in_successfully() {
        // Write code here that turns the phrase above into concrete actions
        this.type="Owner";
        loginInfo.checkAuth(this.username, this.password);
        assertTrue(loginInfo.isOwnerIsLogged());
    }

    @Given("that the tenant is not logged in")
    public void that_the_tenant_is_not_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(loginInfo.isTenantIsLogged());
    }

    @Then("the Tenant logs in successfully")
    public void the_tenant_logs_in_successfully() {
        // Write code here that turns the phrase above into concrete actions
        loginInfo.checkAuth(this.username, this.password);
        assertTrue(loginInfo.isTenantIsLogged());
    }
    @Given("that the user is not logged in")
    public void that_the_user_is_not_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(loginInfo.isAdminIsLogged() && loginInfo.isOwnerIsLogged() && loginInfo.isTenantIsLogged());
    }

    @Then("the User will not login")
    public void the_user_will_not_login() {
        // Write code here that turns the phrase above into concrete actions
        loginInfo.checkAuth(this.username, this.password);
        assertFalse(loginInfo.isTenantIsLogged());
        assertFalse(loginInfo.isOwnerIsLogged());
        assertFalse(loginInfo.isAdminIsLogged());
    }

    @Then("show error")
    public void show_error() {
        // Write code here that turns the phrase above into concrete actions
        loginInfo.showError();
    }

    @Then("the user will not login")
    public void theUserWillNotLogin() {
        // Write code here that turns the phrase above into concrete actions
        loginInfo.checkAuth(this.username, this.password);
        assertFalse(loginInfo.isTenantIsLogged());
        assertFalse(loginInfo.isOwnerIsLogged());
        assertFalse(loginInfo.isAdminIsLogged());
    }



}

