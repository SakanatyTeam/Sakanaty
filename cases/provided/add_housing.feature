Feature: Add Housing

  Scenario Outline: Add Housing Successfully
    Given that the user is logged in
    And there is a housing with name "name",location "location", image "image" , price 800 and type "student"
    And the housing have floors with id <FLOOR_ID> and max apartment <MAX_APARTMENT>
    And the floor by id <FLOOR_ID> have apartments with id <APARTMENT_ID> and max tenant number <MAX_TENANT_NUMBER>
    And the owner id is 100

  Examples:
  | FLOOR_ID | MAX_APARTMENT | APARTMENT_ID | MAX_TENANT_NUMBER |
  | 11       | 2             | 999          | 2                |
  | 22       | 3             | 998          | 2                |
  | 33       | 2             | 997          | 1                |

    Scenario: House info created successfully
      Given that services are "services"
      Then the housing will be saved in the housing list