Feature: Change tip percentage
  As a user
  I would like to change the tip percentage
  So that I can calculate tip and total amount


  Scenario Outline: Change tip percentage to valid value
    Given I use 100 of bill amount
    When I change tip percentage to "<value>"
    And save settings
    Then tip percentage is "<value>%"
    And total amount is "<total>"
    Examples:
      | value | total   |
      | 0.00  | $100.00   |
      | 20.00 | $120.00 |
      | 50.55 | $150.55 |

  Scenario: Change tip percentage and not save settings
    Given I use 100 of bill amount
    When I change tip percentage to "10.00"
    And go back to calculate view
    Then tip percentage is not "10.00%"
