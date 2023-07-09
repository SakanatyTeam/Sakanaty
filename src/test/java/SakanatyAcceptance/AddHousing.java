package SakanatyAcceptance;

import StaticDB.HousingList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Floor;
import org.example.Housing;

import static org.junit.Assert.assertEquals;

public class AddHousing {


    private String name;
    private String loction;
    private String imge;
    private int price;
    private String service;
    private String type;
    private int ownerId;

    Housing housing;

    @Given("there is a housing with name {string},location {string}, image {string} , price {int}, service {string}, type {string}")
    public void there_is_a_housing_with_name_location_image_price_service_type(String name, String location, String image, Integer price, String service, String type) {
        this.name = name;
        this.loction = location;
        this.imge = image;
        this.price = price;
        this.service = service;
        this.type = type;
    }
    @Given("the owner id is {int}")
    public void the_owner_id_is(int ownerId) {
        this.ownerId = ownerId;
    }
    @Then("the housing will be saved in the housing list")
    public void the_housing_will_be_saved_in_the_housing_list() {
        int numOfHousingBeforeAdd = HousingList.getHousing().size();
        housing = new Housing(name,loction,imge,price,service.split(","),ownerId,type);

        HousingList.addHousing(housing);
        int numOfHousingAfterAdd = HousingList.getHousing().size();

        assertEquals(numOfHousingBeforeAdd+1,numOfHousingAfterAdd);
    }

}
