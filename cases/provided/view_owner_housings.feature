Feature: View User Housings By Id

  Scenario: View user Housings By Id successfully
    Given that the user is logged in
    And numhousing is larger than -1
    When the user select "View My Housing" with id 100
    Then display user housings list

  Example:
  | IDD |
  | 100 |

