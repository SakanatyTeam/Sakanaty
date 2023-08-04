package SakanatyAcceptance;

import staticdb.HousingList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Housing;
import role.Admin;

import static org.junit.Assert.assertTrue;

public class AdminAction {
    Housing housing;
    Admin admin;
    int id;
    int action;

    public AdminAction(Admin admin) {
        this.admin = admin;
    }

    @Given("the admin recieves a housing advertisement with id {int}")
    public void the_admin_recieves_a_housing_advertisement_with_id(Integer int1) {
        this.id=int1;
    }

    @Given("the admin chooses to {string} it")
    public void the_admin_chooses_to_it(String string) {
        if(string.equals("Accept"))
            action=1;
        else if(string.equals("Reject"))
            action=2;
        assertTrue(string.equals("Accept") || string.equals("Reject"));
    }

    @Then("the house is accepted")
    public void the_house_is_accepted() {
        housing=HousingList.getPendingHousings().get(id-1);
        assertTrue(admin.takeAction(action,id)==1);
        HousingList.getPendingHousings().add(id-1,housing);
    }

    @Then("the house is rejected")
    public void the_house_is_rejected() {
        housing=HousingList.getPendingHousings().get(id-1);
        assertTrue(admin.takeAction(action,id)==2);
        HousingList.getPendingHousings().add(id-1,housing);
    }

}
