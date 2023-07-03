Feature: User logout

  Scenario: Admin logout successfully
    Given that the admin is logged in
    Then the admin logout successfully

  Scenario: Owner logout successfully
    Given that the owner is logged in
    Then the owner logout successfully

  Scenario: Tenant logout successfully
    Given that the tenant is logged in
    Then the tenant logout successfully