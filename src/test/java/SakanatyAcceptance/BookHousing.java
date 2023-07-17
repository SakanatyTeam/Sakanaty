package SakanatyAcceptance;

import StaticDB.HousingList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Apartment;
import org.example.Floor;
import org.example.Housing;
import org.example.LoginInfo;
import role.Tenant;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookHousing {
    boolean full;
    int apartNum=0;
    int floorNum=0;
    int apartmentID;
    int housingID;
    Tenant tenant;
    Housing housing;
     int floorID;

    public BookHousing(Tenant tenant ) {
        this.tenant = tenant;

    }

    @Given("the tenant has apartment ID equals {int}")
    public void the_tenant_has_apartment_id_equals(Integer int1) {

        assertTrue(tenant.getApartmentID()==-1);
    }

    @Given("tenant enters housing id {int}")
    public void tenant_enters_housing_id(Integer int1) {
        int1--;
        this.housingID=int1;
        housing=HousingList.getHousing().get(int1);
    }

    @Given("tenant enters Floor id {int}")
    public void tenant_enters_floor_id(Integer int1) {
        this.floorID=int1;
        this.floorNum=0;
        for (; floorNum <= housing.getFloors().size(); floorNum++) {
            if(housing.getFloors().get(floorNum).getFloorId()==int1)
                break;
        }
    }

    @Given("tenant enters Apartment id {int}")
    public void tenant_enters_apartment_id(Integer int1) {
        apartNum=0;
        this.apartmentID=int1;
        for (; apartNum <= housing.getFloors().get(floorNum).getApartments().size(); apartNum++) {
            if(housing.getFloors().get(floorNum).getApartments().get(apartNum).getApartmentId()==int1)
                break;
        }
    }
    @Given("the apartment is not full")
    public void the_apartment_is_not_full() {
        int i=0;
        Housing housing = HousingList.getHousing().get(housingID);
        for (Floor floor:housing.getFloors()){
            if(floor.getFloorId()==this.floorID)
            {
                for(Apartment apartment:floor.getApartments())
                {
                    if(apartment.getApartmentId()==this.apartmentID)
                    {
                        if(!apartment.apartmentIsFull()) {
                            full=false;
                            break;
                        }
                    }
                }
            }
        }
        assertFalse(full);

    }
    @Then("the tenant can reserve this apartment")
    public void the_tenant_can_reserve_this_apartment() {
        assertTrue(tenant.bookHouse(housingID,floorNum,apartNum,tenant)==2);
    }

    @Given("the tenant has apartment ID {int}")
    public void the_tenant_has_apartment_id(Integer int1) {
        tenant.setApartmentID(int1);
    }
    @Given("the apartment is full")
    public void the_apartment_is_full() {

    }

    @Then("the tenant cant reserve this full apartment")
    public void the_tenant_cant_reserve_this_full_apartment() {

        assertTrue(tenant.bookHouse(housingID,floorNum,apartNum,tenant)==1);
    }


    @Then("the the tenant cant reserve an apartment")
    public void the_the_tenant_cant_reserve_an_apartment() {
        assertTrue(tenant.bookHouse(housingID,floorNum,apartNum,tenant)==0);
    }
}
