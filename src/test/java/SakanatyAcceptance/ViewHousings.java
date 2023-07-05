package SakanatyAcceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import role.Tenant;

import static org.junit.Assert.assertTrue;

public class ViewHousings {
Tenant tenant;

    public ViewHousings(Tenant tenant) {
        this.tenant = tenant;
    }

    @Given("tenant use {string}")
    public void tenant_use(String string) {
        assertTrue(string.equals("view"));
    }


    @Then("print housings list")
    public void print_housings_list() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(tenant.viewHousings()==1);
    }
}
