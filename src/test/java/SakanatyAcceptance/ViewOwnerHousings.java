package SakanatyAcceptance;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Housing;
import org.example.LoginInfo;
import role.User;


import java.util.List;


public class ViewOwnerHousings {

    List <Housing> housingList;
    LoginInfo loginInfo;

    public ViewOwnerHousings(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    @When("the user select {string} with id {int}")
    public void the_user_select_with_id(String action, Integer id) {
        housingList = User.getHousingList(id);
    }

    @Then("display user housings list")
    public void display_user_housings_list() {
        User.viewMyHousings(housingList);
    }

}