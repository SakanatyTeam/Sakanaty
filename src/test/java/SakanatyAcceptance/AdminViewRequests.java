package SakanatyAcceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import role.Admin;

import static org.junit.Assert.assertTrue;

public class AdminViewRequests {
    Admin admin;

    public AdminViewRequests(Admin admin) {
        this.admin = admin;
    }

    @Given("that the user is an admin")
    public void that_the_user_is_an_admin() {
        assertTrue(admin.getType().equals("Admin"));
    }

    @Then("the admin can view the requests")
    public void the_admin_can_view_the_requests() {
       assertTrue( admin.viewRequests()>1);
    }

}
