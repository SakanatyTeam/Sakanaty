Feature: A tenant can buy a furniture
  Scenario: Successfully buying
    Given that the user is tenant
    And The tenant enters "Chair Leg Aydi" of furniture he wants to buy
    And the tenant  enters "Ali" of the owner of that furniture
    And tenant name is not "Ali"
    Then the tenant buys it


    Scenario: Failed buy due to owner name
      Given that the user is tenant
      And The tenant enters "fname" of furniture he wants to buy
      And the tenant  enters "wrong name" of the owner of that furniture
      Then the buy fails due to owner name

  Scenario: Failed buy due to furniture name
    Given that the user is tenant
    And The tenant enters "wrong name" of furniture he wants to buy
    And the tenant  enters "Ali" of the owner of that furniture
    Then the buy fails due to furniture name
