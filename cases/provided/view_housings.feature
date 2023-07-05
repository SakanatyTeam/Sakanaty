Feature: Tenant can view available housings
  Actor: Tenant
  Scenario: Tenant views available housings
    Given The tenant is logged in
    And tenant use "view"
    Then print housings list
