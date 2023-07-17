Feature: Admin can view system reservations
  Scenario: Admin chooses view reservations
  Given that the user is admin
  And admin chooses "view reservations"
  Then the the reservations show up