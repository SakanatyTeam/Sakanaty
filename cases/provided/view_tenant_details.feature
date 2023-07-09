Feature: View the details of select housing

  Scenario Outline: view the details of select housing successfully
    Given that the user is tenant
    And the housing selected is <ID>
    Then display all details about selected housing
    Examples:
      | ID |
      | 1  |
      | 2  |

  Scenario: view the details of select housing successfully
    Given that the user is tenant
    Then display Fails
