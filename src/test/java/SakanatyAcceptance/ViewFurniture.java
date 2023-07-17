package SakanatyAcceptance;

import io.cucumber.java.en.Then;
import role.Tenant;

public class ViewFurniture {
    Tenant tenant;

    public ViewFurniture(Tenant tenant) {
        this.tenant = tenant;
    }

    @Then("the tenant can view all furnitures")
    public void the_tenant_can_view_all_furnitures_of_other_tenants_except_his() {
        tenant.viewFurnitures(tenant);
    }


}

