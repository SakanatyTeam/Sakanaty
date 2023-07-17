Feature: Admin can accept or reject a housing advertisement
  Scenario Outline: An admin accepts the advertisement
    Given that the user is an admin
    And the admin recieves a housing advertisement with id <ID>
    And the admin chooses to "Accept" it
    Then the house is accepted
    Examples:
    |ID|
    |1 |
    |2|

  Scenario Outline: An admin rejects the advertisement
    Given that the user is an admin
    And the admin recieves a housing advertisement with id <ID>
    And the admin chooses to "Reject" it
    Then the house is rejected
    Examples:
      |ID|
      |1 |
      |2 |