Feature: Example
  Description: Example feature file

  Scenario Outline: User want to learn HTML at w3schools
    Given User is on Home screen
    When User click on "<objectiveName>" label
    And User input valid "<username>" and "<password>"
    Then Title is displayed correctly

    Examples:
      | objectiveName | username | password    |
      | Learn HTML    | vu_123   | password123 |
      | Learn HTML    | vu_456   | password456 |