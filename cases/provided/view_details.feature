Feature: View the details of select housing

  Scenario: view the details of select housing successfully
    Given that the tenant is logged in
    And the housing selected is "<ID>"
    Then display all details about selected housing

  Scenario Outline: view the details of select housing fails
    Given that the tenant is logged in
    And the housing selected is "not exist"
    Then show details fails

    Examples:
      | ID |
      | 1  |
      | 2  |
