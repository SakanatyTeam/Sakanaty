Feature: Add Housing

  Scenario: Add Housing Successfully
    Given that the user is logged in
    And there is a housing with name "name",location "location", image "image" , price 800, service "service", type "type"
    And the owner id is 100
    Then the housing will be saved in the housing list

