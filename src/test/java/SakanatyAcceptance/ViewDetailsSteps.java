package SakanatyAcceptance;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.LoginInfo;

import static org.junit.Assert.assertTrue;

public class ViewDetailsSteps {

    Housing housing;
    LoginInfo loginInfo;

    public ViewDetailsSteps(LoginInfo loginInfo , Housing housing) {
        this.loginInfo = loginInfo;
        this.housing = housing;
    }

    @When("the tenant select View available housing")
    public void the_tenant_select_view_available_housing() {
        loginInfo.showHousing();
    }
    @When("the tenant select View details of any housing")
    public void the_tenant_select_view_details_of_any_housing(String numRow) {
        housing = loginInfo.findHousingByNumRow(numRow);
    }
    @Then("display all details about select housing")
    public void display_all_details_about_select_housing() {
        loginInfo.showDetails(housing);
    }
}





