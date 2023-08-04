package SakanatyAcceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import role.Furniture;
import role.Tenant;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class BuyFurniture {
Tenant tenant;

    public BuyFurniture(Tenant tenant) {
        this.tenant = tenant;
    }
    String oname;
    String fname;

    @Given("The tenant enters {string} of furniture he wants to buy")
    public void the_tenant_enters_of_furniture_he_wants_to_buy(String string) {
    this.fname=string;
    }
    @Given("the tenant  enters {string} of the owner of that furniture")
    public void the_tenant_enters_of_the_owner_of_that_furniture(String string) {
        this.oname=string;
    }

    @Then("the tenant buys it")
    public void the_tenant_buys_it() {
        Furniture.getFurnitureList().put(tenant,new ArrayList<>());
        assertTrue(tenant.buyFurniture(tenant,oname,fname)==2);
    }

    @Then("the buy fails due to owner name")
    public void the_buy_fails_due_to_owner_name() {
        assertTrue(tenant.buyFurniture(tenant,oname,fname)==0);
    }

    @Given("the tenant  enters name of the owner of that furniture")
    public void the_tenant_enters_name_of_the_owner_of_that_furniture() {
        assertTrue(true);
    }

    @Then("the buy fails due to furniture name")
    public void the_buy_fails_due_to_furniture_name() {
        assertTrue(tenant.buyFurniture(tenant,oname,fname)==1);
    }
    @Given("tenant name is not {string}")
    public void tenant_name_is_not(String string) {
        tenant.setUsername("Yazan");
        assertTrue(!tenant.getUsername().equals(string));
    }
}
