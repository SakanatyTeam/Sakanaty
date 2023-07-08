Feature: View Housing Details

  Scenario: User views housing details
    Given that the user is logged in
    When the user requests to view the housing details by <"name">
    Then display housing details

  Example:
  | name |
  | Sakan1 |
  | Sakan2 |
  | Sakan3 |
  | Sakan4 |
