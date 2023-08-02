package SakanatyAcceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import role.Tenant;

import static org.junit.Assert.assertTrue;

public class ViewTenantHousing {
    Tenant tenant;

    public ViewTenantHousing(Tenant tenant) {
        this.tenant = tenant;
    }

    @Given("that the user is a tenant")
    public void that_the_user_is_a_tenant() {
        assertTrue(tenant.getType().equals("Tenant"));
    }
    @Then("the tenant can view housing.")
    public void the_tenant_can_view_housing() {
        tenant.viewHousings();
    }


}
