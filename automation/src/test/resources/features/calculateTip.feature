Feature: Calculate Tip
  As a user
  I would like to calculate tip with different %
  So that I can pay total amount

  Scenario: Calculate tip with default 20%
    Given I am using FasTip app
    When I enter 100 of bill amount
    Then tip value is 20
    And total amount is 120