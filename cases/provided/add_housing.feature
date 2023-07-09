Feature: Add Housing

  Scenario: And Housing Successfully
    Given that the user is logged in
    And there is a houseing with name "name",location "location", imge "img" , price price, service "service", floor floor
    And the owner id is 100
    Then the houseing will be saved in the houseing list

