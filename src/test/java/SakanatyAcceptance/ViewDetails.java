package SakanatyAcceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.LoginInfo;
import org.junit.function.ThrowingRunnable;
import role.Tenant;
import role.User;

import static org.junit.Assert.*;

public class ViewDetails {
    private Throwable exception;
    LoginInfo loginInfo;
    Tenant tenant;
    public ViewDetails(Tenant tenant) {
        this.tenant=tenant;
    }
    int id;
    @Given("that the user is tenant")
    public void that_the_user_is_tenant() {
        assertEquals("Tenant",tenant.getType());
    }
    @Given("the housing selected is {int}")
    public void the_housing_selected_is(Integer int1) {
        this.id=int1;
    }

    @Then("display all details about selected housing")
    public void display_all_details_about_selected_housing() {
        assertEquals(1,(tenant.viewDetails(id)));
    }
    @Then("display Fails")
    public void display_fails() {

         assertThrows(IndexOutOfBoundsException.class, () -> {
            int x= tenant.viewDetails(-1);
        });
    }
}
