package SakanatyAcceptance;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Housing;
import org.example.Main;
import role.Owner;

public class ViewOwnerDetails {

    Housing housing;

    @When("the user requests to view the housing details by <{string}>")
    public void the_user_requests_to_view_the_housing_details_by(String name) {
        housing = Owner.getHousing(name);
    }
    @Then("display housing details")
    public void display_housing_details() {
        Owner.viewDetails(housing);
    }
}
