Feature: Calculate Tip
  As a user
  I would like to calculate tip with different bill amounts
  So that I can pay total amount

  Scenario: Calculate tip with default percentage (15%)
    Given I am using FasTip app
    When I use 100 of bill amount
    Then tip value is "$15.00"
    And total amount is "$115.00"
