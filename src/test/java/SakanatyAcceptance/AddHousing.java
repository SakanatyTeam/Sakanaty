package SakanatyAcceptance;

import StaticDB.HousingList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Housing;

import static org.junit.Assert.assertEquals;

public class AddHousing {


    private String name;
    private String loction;
    private String imge;
    private int price;
    private String []service;
    private Integer floor;
    private Integer ownerId;

    Housing housing;

    @Given("there is a houseing with name {string},location {string}, imge {string} , price {int}, service {string}, floor {int}")
    public void there_is_a_houseing_with_name_location_imge_price_service_floor(String name, String location, String imge, Integer price, String service, Integer floor) {
        this.name = name;
        this.loction = location;
        this.imge = imge;
        this.price = price;
//        this.service = service;
        this.service = service.split(",");
        this.floor = floor;
    }
    @Given("the owner id is {int}")
    public void the_owner_id_is(Integer ownerId) {
        this.ownerId = ownerId;
    }
    @Then("the houseing will be saved in the houseing list")
    public void the_houseing_will_be_saved_in_the_houseing_list() {
        int numOfHousingBeforeAdd = HousingList.getHousing().size();
        housing = new Housing(name,loction,imge,price,service,floor,ownerId);

        HousingList.addHousing(housing);
        int numOfHousingAfterAdd=HousingList.getHousing().size();

        assertEquals(numOfHousingBeforeAdd+1,numOfHousingAfterAdd);
//        assertEquals("in treatment",product.getStatus());
    }

}
