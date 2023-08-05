package SakanatyAcceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import role.Admin;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class ViewReservations {
    Admin admin;

    public ViewReservations(Admin admin) {
        this.admin = admin;
    }

    @Given("that the user is admin")
    public void that_the_user_is_admin() {
        assertEquals("Admin",admin.getType());
    }

    @Given("admin chooses {string}")
    public void admin_chooses(String string) {
        assertEquals("view reservations", string);
    }

    @Then("the the reservations show up")
    public void the_the_reservations_show_up() {
        assertEquals(1,admin.showReservations());
    }
}
