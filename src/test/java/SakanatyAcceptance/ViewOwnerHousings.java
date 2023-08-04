package SakanatyAcceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Housing;
import org.example.LoginInfo;
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

    @Given("numhousing is larger than {int}")
    public void numhousing_is_larger_than(Integer int1) {
       assertTrue(User.getNumHousing()>int1);
    }

    @When("the user select {string} with id {int}")
    public void the_user_select_with_id(String action, Integer id) {
        housingList = User.getHousingList(id);
        assertEquals("View My Housing",action);
    }

    @Then("display user housings list")
    public void display_user_housings_list() {
        assertTrue(User.viewMyHousings(housingList) > 0);
    }

}