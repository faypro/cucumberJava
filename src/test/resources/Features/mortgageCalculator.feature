Feature: Mortgage Calculator

  Scenario: Calculate Real Apr
    Given user is in the mortgage calculator home page
    And user is navigated to the Real Apr page
    When user click on the calculate button upon entering the data
    |HomePrice|DownPayment|InterestRate|
    |200000   |15000      |3           |
    Then the real apr rate is "3.139%"