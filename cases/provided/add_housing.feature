Feature: Add Housing

  Scenario Outline: Add Housing Successfully
    Given that the user is logged in
    And there is a housing with name "name",location "location", image "image" , price 800 and type "student"
    And the housing have floors with id and max apartment <MAX_APARTMENT>
    And the floor by id  have apartments with id and max tenant number <MAX_TENANT_NUMBER>
    And the owner id is 100

  Examples:
 | MAX_APARTMENT | MAX_TENANT_NUMBER |
 | 2             | 2                |
 | 3             | 2                |
 | 2             | 1                |

  Scenario: House info created successfully
      Given that services are "services"
      Then the housing will be saved in the housing list