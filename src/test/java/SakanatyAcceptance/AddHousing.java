package SakanatyAcceptance;

import staticdb.HousingList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Apartment;
import org.example.Floor;
import org.example.Housing;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class AddHousing {

    Floor floor;
    Apartment apartment;

    private String name;
    int index;
    private String loction;
    private String imge;
    private int price;
    private String service;
    private String type;
    private int ownerId;

    Housing housing;

    List <Floor> floorList = new ArrayList<Floor>();

@Given("there is a housing with name {string},location {string}, image {string} , price {int} and type {string}")
public void there_is_a_housing_with_name_location_image_price_service_and_type(String string, String string2, String string3, Integer int1, String string5) {
    this.name = string;
    this.loction = string2;
    this.imge = string3;
    this.price = int1;
    this.type = string5;
}

    @Given("the housing have floors with id and max apartment {int}")
    public void theHousingHaveFloorsWithIdAndMaxApartment(Integer int1) {
        floor = new Floor(Floor.autoIncrementTenantId(),int1);
        floorList.add(floor);
    }
    @Given("the floor by id  have apartments with id and max tenant number {int}")
    public void theFloorByIdHaveApartmentsWithIdAndMaxTenantNumber(Integer int1) {
        apartment= new Apartment(Apartment.autoIncrementFloorId(),int1);
        for(;index<floorList.size();index++){
            {
                if(floor.getFloorId()==int1)
                {
                    floorList.get(index).addApartment(apartment);
                }
            }
        }
    }

    @Given("that services are {string}")
    public void that_services_are(String string) {
        this.service=string;
    }
    @Given("the owner id is {int}")
    public void the_owner_id_is(int ownerId) {
        this.ownerId = ownerId;
    }
    @Then("the housing will be saved in the housing list")
    public void the_housing_will_be_saved_in_the_housing_list() {
        int numOfHousingBeforeAdd = HousingList.getHousing().size();
        housing = new Housing(name,loction,imge,price,service.split(","),ownerId,type);
        for (Floor floor1: floorList){
            housing.addFloors(floor1);
        }
        HousingList.addHousing(housing);
        int numOfHousingAfterAdd = HousingList.getHousing().size();
        assertEquals(numOfHousingBeforeAdd + 1, numOfHousingAfterAdd);
    }
}
