Feature: A tenant books an available apartment
  Scenario Outline: Successfully booking of available apartment
    Given that the user is tenant
    And the tenant has apartment ID equals -1
    And tenant enters housing id <housing_ID>
    And tenant enters Floor id <floor_ID>
    And tenant enters Apartment id <apartment_ID>
    And the apartment is not full
    Then the tenant can reserve this apartment
    Examples:
    |housing_ID| floor_ID | apartment_ID |
    | 1        | 1        | 112          |
    | 1        | 2       | 121           |
    | 1        | 2       | 122           |
    | 1        | 2       | 123           |
    | 1        | 3       | 131           |
    | 2        | 4       | 211           |
    | 2        | 4       | 212           |
    | 2        | 5       | 221           |
Scenario Outline: Failed booking
  Given that the tenant is not logged in
  And the tenant has apartment ID <apartment_ID>
  Then the the tenant cant reserve an apartment
  Examples:
 | apartment_ID |
 | 111          |
 | 112          |
 | 121          |
 | 122          |
 | 123          |
 | 131          |
 | 211          |
 | 212          |
 | 221          |
  Scenario Outline: Unsuccessfully booking of unavailable apartment
    Given that the user is tenant
    And the tenant has apartment ID equals -1
    And tenant enters housing id <housing_ID>
    And tenant enters Floor id <floor_ID>
    And tenant enters Apartment id <apartment_ID>
    And the apartment is full
    Then the tenant cant reserve this full apartment
    Examples:
      |housing_ID| floor_ID | apartment_ID |
      | 1        | 1        | 111          |
