Feature: View the details of select housing

  Scenario: view the details of select housing successfully
    Given that the tenant is logged in
    When the tenant select View available housing
    When the tenant select View details of any housing
    Then display all details about select housing