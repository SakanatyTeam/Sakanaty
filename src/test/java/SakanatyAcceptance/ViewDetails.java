package SakanatyAcceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import role.Tenant;

import static org.junit.Assert.assertTrue;

public class ViewDetails {
    Tenant tenant;
    String houseSelected;

    public ViewDetails(Tenant tenant) {
        this.tenant = tenant;
    }

    @Given("the housing selected is {string}")
    public void the_housing_selected_is(String string) {
        houseSelected=string;
    }

    @Then("display all details about selected housing")
    public void display_all_details_about_selected_housing() {
        assertTrue(tenant.viewDetails(Integer.parseInt(houseSelected))==1);
    }

    @Then("show details fails")
    public void show_details_fails() {
        tenant.wrongID();
    }

}
