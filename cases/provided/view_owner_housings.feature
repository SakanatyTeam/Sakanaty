Feature: View User Housings By Id

  Scenario: View user Housings By Id successfully
    Given that the user is logged in
    When the user select "View My Housing" with <"ID">
    Then display user housings list

    Example:
    | ID   |
    | 100  |
    | 1  |
    | 1001  |
    | 1002  |
