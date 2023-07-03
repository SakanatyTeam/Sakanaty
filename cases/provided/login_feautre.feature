Feature: User login

  Scenario: Admin logs in successfully
    Given that the admin is not logged in
    And the username is "Yazan"
    And the password is "Pass"
    Then the admin logs in successfully

  Scenario: Owner logs in successfully
    Given that the owner is not logged in
    And the username is "Bdair"
    And the password is "Pass"
    Then the Owner logs in successfully

  Scenario: Tenant logs in successfully
    Given that the tenant is not logged in
    And the username is "Baraa"
    And the password is "Pass"
    Then the Tenant logs in successfully

  Scenario: User entered wrong username
    Given that the user is not logged in
    And the username is "doesn't exist"
    And the password is "Pass"
    Then the User will not login
    And show error

  Scenario: User entered wrong password
    Given that the user is not logged in
    And the username is "ahmad"
    And the password is "not true"
    Then the user will not login
    And show error