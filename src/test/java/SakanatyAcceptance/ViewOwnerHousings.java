package SakanatyAcceptance;

import StaticDB.HousingList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Housing;
import org.example.LoginInfo;
import role.Owner;
import role.Tenant;
import role.User;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ViewOwnerHousings {

    List <Housing> housingList;
    LoginInfo loginInfo;

    public ViewOwnerHousings(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    @When("the user select {string} with <{string}>")
    public void the_user_select_with(String string, String id) {
        housingList = User.getHousingList(id);
    }
    @Then("display user housings list")
    public void display_user_housings_list() {
        User.viewMyHousings(housingList);
    }

}
